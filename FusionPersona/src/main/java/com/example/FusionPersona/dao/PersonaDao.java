package com.example.FusionPersona.dao;

import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;

import java.io.IOException;
import java.util.List;

public interface PersonaDao {
    public void createPersona(CPersonaDto personaDto) throws IOException;
    public PersonaEntity findOnePersonaById(Integer personaId);
    public List<PersonaEntity> findAllPersonas();
}
