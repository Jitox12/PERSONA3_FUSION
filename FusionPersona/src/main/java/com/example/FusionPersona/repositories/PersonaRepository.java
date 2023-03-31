package com.example.FusionPersona.repositories;

import com.example.FusionPersona.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
    @Query("SELECT p, fp.fusionId " +
            "FROM PersonaEntity p " +
            "INNER JOIN FusionPersonaEntity fp " +
            "ON p.personaId = fp.persona.personaId " +
            "WHERE fp.fusionR = 0 " +
            "AND fp.persona.personaId != ?1")
    List<PersonaEntity> findFirstPersona(Integer personaId);

    @Query("SELECT p " +
            "FROM FusionPersonaEntity fp "+
            "INNER JOIN PersonaEntity p "+
            "ON p.personaId = fp.persona.personaId "+
            "WHERE fp.fusionR = 0 "+
            "AND fp.fusionId = ?1 " +
            "AND fp.persona.personaId != ?2")
    PersonaEntity findSecondPersonaByThirdPersona(Integer fusionId, Integer personaId);

    @Query("SELECT p " +
            "FROM FusionPersonaEntity fp "+
            "INNER JOIN PersonaEntity p "+
            "ON p.personaId = fp.persona.personaId "+
            "WHERE fp.fusionR = 1 "+
            "AND fp.fusionId = ?1")
    PersonaEntity findThirdPersonaBySecondPersona(Integer FusionId);

    Optional<PersonaEntity> findByPersonaName(String name);

    Optional<PersonaEntity> findByPersonaId(Integer personaId);

    void deleteByPersonaName(String personaName);

    List<PersonaEntity> findAll();
}
