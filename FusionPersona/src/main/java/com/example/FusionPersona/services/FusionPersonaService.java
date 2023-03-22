package com.example.FusionPersona.services;

import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;

import java.io.IOException;
import java.util.List;

public interface FusionPersonaService {
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDto);
    public List<GFusionPersonaDto>  findFusionPersonaByPersonaId(Integer personaId);
}
