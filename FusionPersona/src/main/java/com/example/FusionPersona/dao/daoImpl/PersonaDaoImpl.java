package com.example.FusionPersona.dao.daoImpl;

import com.example.FusionPersona.dao.PersonaDao;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;
import com.example.FusionPersona.exception.exceptions.NotFoundException;
import com.example.FusionPersona.repositories.PersonaRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonaDaoImpl implements PersonaDao {

    private final PersonaRepository personaRepository;

    public PersonaDaoImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Transactional
    @Override
    public void createPersona(CPersonaDto personaDto) throws IOException {

        PersonaEntity persona = PersonaEntity.builder()
                .personaName(personaDto.getPersonaNameDto())
                .personaImg(personaDto.getPersonaImgDto())
                .build();

        personaRepository.save(persona);
    }

    @Override
    public PersonaEntity findOnePersonaById(Integer personaId) {
        PersonaEntity persona ;

        persona = personaRepository
                .findByPersonaId(personaId)
                .orElseThrow(()-> new RuntimeException("Errorcito"));

        return persona;
    }

    @Override
    public List<PersonaEntity> findAllPersonas() {
        List<PersonaEntity> personaList = personaRepository.findAll()
                                .stream()
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());
        if(personaList.isEmpty()){
            throw new NotFoundException("Persona");
        }

        return personaList;
    }

    @Override
    public PersonaEntity findPersonaByName(String personaName) throws IOException {
        PersonaEntity persona = personaRepository.findByPersonaName(personaName)
                .orElseThrow(()->new RuntimeException("soy un error"));

        return persona;
    }

    @Override
    public void deletePersonaByName(String personaName) throws IOException {
        personaRepository.deleteByPersonaName(personaName);
    }
    @Transactional
    @Override
    public void deletePersonaById(Integer personaId) {
        personaRepository.deleteById(personaId);
    }

    @Transactional
    @Override
    public void editPersona(EPersonaDto ePersonaDto) {
        PersonaEntity persona = PersonaEntity.builder()
                .personaId(ePersonaDto.getPersonaIdDto())
                .personaName(ePersonaDto.getPersonaNameDto())
                .personaImg(ePersonaDto.getPersonaImgDto())
                .build();

        personaRepository.save(persona);
    }
}