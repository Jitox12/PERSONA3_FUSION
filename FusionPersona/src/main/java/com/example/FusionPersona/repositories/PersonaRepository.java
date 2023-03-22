package com.example.FusionPersona.repositories;

import com.example.FusionPersona.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
//    @Query("SELECT p FROM Persona p INNER JOIN FusionPersona fp ON p.persona_id = fp.persona.persona_id WHERE fp.fusion_r = 0 AND fp.persona.persona_id != ?1")
    @Query("SELECT p FROM PersonaEntity p INNER JOIN FusionPersonaEntity fp ON p.personaId = fp.persona.personaId WHERE fp.fusionR = 0 AND fp.persona.personaId != ?1")
    List<PersonaEntity> findPersonas(Integer personaId);
    PersonaEntity findByPersonaId(Integer personaId);
    List<PersonaEntity> findAll();
}
