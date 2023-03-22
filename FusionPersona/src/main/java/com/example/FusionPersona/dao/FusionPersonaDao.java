package com.example.FusionPersona.dao;

import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.entities.FusionPersonaEntity;

import java.io.IOException;
import java.util.List;

public interface FusionPersonaDao {
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDto) throws IOException;

    public List<FusionPersonaEntity> findFusionPersonaByPersonaId(Integer personaId) throws IOException;
}
