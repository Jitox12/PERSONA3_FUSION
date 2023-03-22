package com.example.FusionPersona.dao.daoImpl;

import com.example.FusionPersona.dao.FusionPersonaDao;
import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.entities.FusionPersonaEntity;
import com.example.FusionPersona.repositories.FusionPersonaRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FusionPersonaDaoImpl implements FusionPersonaDao {

    private final FusionPersonaRepository fusionPersonaRepository;

    public FusionPersonaDaoImpl(FusionPersonaRepository fusionPersonaRepository, FusionPersonaRepository fusionPersonaRepository1) {
        this.fusionPersonaRepository = fusionPersonaRepository1;
    }

    @Override
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDto) throws IOException {
        List<FusionPersonaEntity> fusionPersonaList = new ArrayList<>();

        fusionPersonaDto.forEach((CFusionPersonaDto fusionPersona) -> {
            fusionPersonaList.add(FusionPersonaEntity.builder()
                    .persona(fusionPersona.getPersona())
                    .fusionId(fusionPersona.getFusionIdDto())
                    .fusionR(fusionPersona.getFusionRDto())
                    .build());
        });
        fusionPersonaRepository.saveAll(fusionPersonaList);
    }

    @Override
    public List<FusionPersonaEntity> findFusionPersonaByPersonaId(Integer personaId) {
        List<FusionPersonaEntity> fusionPersonaList = null;

        return fusionPersonaList;
    }
}
