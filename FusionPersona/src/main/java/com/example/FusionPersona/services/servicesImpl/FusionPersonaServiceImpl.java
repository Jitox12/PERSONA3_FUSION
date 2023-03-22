package com.example.FusionPersona.services.servicesImpl;

import com.example.FusionPersona.dao.FusionPersonaDao;
import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.entities.FusionPersonaEntity;
import com.example.FusionPersona.mappers.FusionPersonaMappers;
import com.example.FusionPersona.services.FusionPersonaService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FusionPersonaServiceImpl implements FusionPersonaService {

    //DAO
    private final FusionPersonaDao fusionPersonaDao;

    //MAPPERS
    private final FusionPersonaMappers fusionPersonaMappers;

    public FusionPersonaServiceImpl(FusionPersonaDao fusionPersonaDao, FusionPersonaMappers fusionPersonaMappers) {
        this.fusionPersonaDao = fusionPersonaDao;
        this.fusionPersonaMappers = fusionPersonaMappers;
    }

    @Override
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDtoList) {
        try {
            fusionPersonaDao.createFusionPersona(fusionPersonaDtoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
