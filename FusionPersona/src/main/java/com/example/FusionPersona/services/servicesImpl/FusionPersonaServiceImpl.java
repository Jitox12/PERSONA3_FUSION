package com.example.FusionPersona.services.servicesImpl;

import com.example.FusionPersona.dao.FusionPersonaDao;
import com.example.FusionPersona.dao.PersonaDao;
import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.RFusionPersonaDto;
import com.example.FusionPersona.entities.FusionPersonaEntity;
import com.example.FusionPersona.entities.PersonaEntity;
import com.example.FusionPersona.mappers.FusionPersonaMappers;
import com.example.FusionPersona.services.FusionPersonaService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FusionPersonaServiceImpl implements FusionPersonaService {

    //DAO
    private final FusionPersonaDao fusionPersonaDao;
    private final PersonaDao personaDao;
    //MAPPERS
    private final FusionPersonaMappers fusionPersonaMappers;

    public FusionPersonaServiceImpl(FusionPersonaDao fusionPersonaDao, PersonaDao personaDao, FusionPersonaMappers fusionPersonaMappers) {
        this.fusionPersonaDao = fusionPersonaDao;
        this.personaDao = personaDao;
        this.fusionPersonaMappers = fusionPersonaMappers;
    }

    @Override
    public void createFusionPersona(List<RFusionPersonaDto> rFusionPersonaDtoList) {
        List<CFusionPersonaDto> cFusionPersonaDtoList = new ArrayList<>();

            rFusionPersonaDtoList.forEach((RFusionPersonaDto fusionDto) ->{
                PersonaEntity persona = null;
                try {
                    persona = personaDao.findOnePersonaById(fusionDto.getPersonaId());

                    cFusionPersonaDtoList.add(CFusionPersonaDto.builder()
                            .personaDto(persona)
                            .fusionIdDto(fusionDto.getFusionIdDto())
                            .fusionRDto(fusionDto.getFusionRDto()).build());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try{
                    fusionPersonaDao.createFusionPersona(cFusionPersonaDtoList);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }

            });





    }

    @Override
    public List<GFusionPersonaDto> findFusionPersonaByPersonaId(Integer personaId) {
        List<FusionPersonaEntity> fusionPersonaList = null;
        List<GFusionPersonaDto> gFusionPersonaDtoList = null;

        try{
            fusionPersonaList = fusionPersonaDao.findFusionPersonaByPersonaId(personaId);
            gFusionPersonaDtoList = fusionPersonaList.stream().map(fusionPersonaMappers::fusionPersonaEntityToFusionPersonaDto).collect(Collectors.toList());

            return gFusionPersonaDtoList;
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}