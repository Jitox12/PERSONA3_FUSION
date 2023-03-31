package com.example.FusionPersona.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fusion_persona")
public class FusionPersonaEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fusion_persona_id")
    private Integer fusionPersonaId;
    @Column(name = "fusion_id")
    private Integer fusionId;
    @Column(name = "fusion_r")
    private Integer fusionR;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private PersonaEntity persona;
}
