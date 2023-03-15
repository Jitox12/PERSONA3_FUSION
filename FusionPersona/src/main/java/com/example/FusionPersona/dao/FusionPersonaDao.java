package com.example.FusionPersona.dao;

import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;

import java.io.IOException;
import java.util.List;

public interface FusionPersonaDao {
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDto) throws IOException;

}
