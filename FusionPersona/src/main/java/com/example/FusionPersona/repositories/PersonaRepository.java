package com.example.FusionPersona.repositories;

import com.example.FusionPersona.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

    PersonaEntity findByPersonaId(Integer personaId);
    List<PersonaEntity> findAll();
}
