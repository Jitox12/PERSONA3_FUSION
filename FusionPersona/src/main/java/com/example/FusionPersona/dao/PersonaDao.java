package com.example.FusionPersona.dao;

import com.example.FusionPersona.dto.fusionPersonaDto.RFusionPersonaDto;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;

import java.io.IOException;
import java.util.List;

public interface PersonaDao {
    public void createPersona(CPersonaDto personaDto) throws IOException;
    public PersonaEntity findOnePersonaById(Integer personaId) throws IOException;
    public List<PersonaEntity> findAllPersonas() throws IOException;
    public PersonaEntity findPersonaByName(String personaName) throws IOException;
    public void deletePersonaByName(String personaName) throws IOException;
    public void deletePersonaById(Integer personaId) throws IOException;
    public void editPersona(EPersonaDto ePersonaDto) throws IOException;
    }
