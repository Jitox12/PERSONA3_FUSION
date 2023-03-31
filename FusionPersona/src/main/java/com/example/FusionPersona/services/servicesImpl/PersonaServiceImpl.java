package com.example.FusionPersona.services.servicesImpl;

import com.example.FusionPersona.dao.PersonaDao;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.dto.personaDto.GPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;
import com.example.FusionPersona.exception.exceptions.NotFoundException;
import com.example.FusionPersona.mappers.PersonaMappers;
import com.example.FusionPersona.services.PersonaServices;
import com.example.FusionPersona.utils.FirstKey;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaServices {

    private final PersonaDao personaDao;
    private final PersonaMappers personaMappers;

    public PersonaServiceImpl(PersonaDao personaDao, PersonaMappers personaMappers) {
        this.personaDao = personaDao;
        this.personaMappers = personaMappers;
    }

    @Override
    public void createPersona(CPersonaDto personaDto) {
        try {
            String upperName = FirstKey.UpperCase(personaDto.getPersonaNameDto());
            personaDto.setPersonaNameDto(upperName);

            personaDao.createPersona(personaDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GPersonaDto findOnePersonaById(Integer personaId) {
        PersonaEntity persona;
        GPersonaDto personaDto;
        try {
            persona = personaDao.findOnePersonaById(personaId);
            personaDto = personaMappers.personaEntityToPersonaDto(persona);
            return personaDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GPersonaDto findPersonaByName(String personaName) {
        PersonaEntity persona;
        GPersonaDto personaDto;
        try {
            persona = personaDao.findPersonaByName(personaName);
            personaDto = personaMappers.personaEntityToPersonaDto(persona);

            return personaDto;
        } catch (IOException e) {
            throw new NotFoundException("Persona by personaName: ".concat(personaName));
        }
    }

    @Override
    public void deletePersonaById(Integer personaId) {
        try {
            personaDao.deletePersonaById(personaId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GPersonaDto> findAllPersonas() {
        List<PersonaEntity> personaList = null;
        List<GPersonaDto> personaDtoList = null;

        try {
            personaList = personaDao.findAllPersonas();
            personaDtoList = personaList.stream().map(personaMappers::personaEntityToPersonaDto).collect(Collectors.toList());
            return personaDtoList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editPersona(Integer personaId, EPersonaDto personaDto) {
        try {
            personaDto.setPersonaIdDto(personaId);
            personaDao.editPersona(personaDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePersonaByName(String personaName) {
        try {
            personaDao.deletePersonaByName(personaName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}