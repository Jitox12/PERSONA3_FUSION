package com.example.FusionPersona.services;

import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.RFusionPersonaDto;
import java.util.List;

public interface FusionPersonaService {
    public void createFusionPersona(List<RFusionPersonaDto> fusionPersonaDto);
    public List<GFusionPersonaDto>  findFusionPersonaByPersonaId(Integer personaId);
}
