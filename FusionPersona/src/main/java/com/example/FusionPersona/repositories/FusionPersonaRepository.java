package com.example.FusionPersona.repositories;

import com.example.FusionPersona.entities.FusionPersonaEntity;
import com.example.FusionPersona.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FusionPersonaRepository extends JpaRepository<FusionPersonaEntity, Integer> {
/*
    @Query(value = "SELECT p.persona_id, p.persona_name, fp.fusion_id, fp.fusion_r " +
            "FROM persona p " +
            "INNER JOIN fusion_persona fp " +
            "ON p.persona_id = fp.persona_id " +
            "WHERE fp.fusion_r = 1 " +
            "AND fp.fusion_id = ?1 " +
            "AND fp.persona_id NOT IN (?2, ?3)", nativeQuery = true)
    PersonaFusionPersona PersonaResult(Integer fusionId, Integer firstPersonaId, Integer secondPersonaId);

    @Query(value = "SELECT persona.* " +
            "FROM `persona` " +
            "INNER JOIN fusion_persona ON persona.persona_id =fusion_persona.persona_id " +
            "WHERE fusion_persona.fusion_r = 0 A" +
            "ND fusion_persona.persona_id != 10;\n", nativeQuery = true)
    List<PersonaEntity> PersonaMerge(Integer personaId);
*/

}
