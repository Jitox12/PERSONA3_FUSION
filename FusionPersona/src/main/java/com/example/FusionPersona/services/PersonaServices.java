package com.example.FusionPersona.services;

import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.dto.personaDto.GPersonaDto;

import java.util.List;

public interface PersonaServices {

    public void createPersona(CPersonaDto cPersonaDto);
    public GPersonaDto findOnePersonaById(Integer personaId);
    public GPersonaDto findPersonaByName(String personaName);
    public void deletePersonaById(Integer personaId);
    public List<GPersonaDto> findAllPersonas();
    public void editPersona(Integer personaId, EPersonaDto personaDto);

    public void deletePersonaByName(String personaName);
}
