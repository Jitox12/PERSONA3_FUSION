package com.example.FusionPersona.dao.daoImpl;

import com.example.FusionPersona.dao.PersonaDao;
import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;
import com.example.FusionPersona.repositories.PersonaRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class PersonaDaoImpl implements PersonaDao {

    private final PersonaRepository personaRepository;

    public PersonaDaoImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void createPersona(CPersonaDto personaDto) throws IOException {
        byte[] img = personaDto.getPersonaImgDto().getBytes(StandardCharsets.UTF_8);

        PersonaEntity persona = PersonaEntity.builder()
                .personaName(personaDto.getPersonaNameDto())
                .personaImg(img)
                .build();
        personaRepository.findPersonas(10);

        personaRepository.save(persona);
    }

    @Override
    public PersonaEntity findOnePersonaById(Integer personaId) {
        PersonaEntity persona = null;
        persona = personaRepository.findByPersonaId(personaId);
        List<PersonaEntity> personaPrueba = null;
        return persona;
    }

    @Override
    public List<PersonaEntity> findAllPersonas() {
        List<PersonaEntity> personaList = null;
        personaList = personaRepository.findAll();

        return personaList;
    }

    @Override
    public void deletePersonaById(Integer personaId) {
        personaRepository.deleteById(personaId);
    }

    @Override
    public void editPersona(EPersonaDto ePersonaDto) {
        byte[] img = ePersonaDto.getPersonaImgDto().getBytes(StandardCharsets.UTF_8);

        PersonaEntity persona = PersonaEntity.builder()
                .personaId(ePersonaDto.getPersonaIdDto())
                .personaName(ePersonaDto.getPersonaNameDto())
                .personaImg(img)
                .build();


        personaRepository.save(persona);
    }
}