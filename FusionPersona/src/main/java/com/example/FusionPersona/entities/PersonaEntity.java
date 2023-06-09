package com.example.FusionPersona.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", unique = true)
    private Integer personaId;
    @Column(name = "persona_name",unique = true, nullable = false)
    private String personaName;
    @Lob
    @Column(name = "persona_img", nullable = false)
    private String personaImg;

    @OneToMany(mappedBy = "persona")
    private List<FusionPersonaEntity> fusionPersonaList;
}
