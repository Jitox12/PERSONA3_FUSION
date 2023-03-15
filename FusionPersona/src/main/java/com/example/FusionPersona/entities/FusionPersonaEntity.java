package com.example.FusionPersona.entities;

import ch.qos.logback.core.joran.event.SaxEventRecorder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(FusionPersonaEntity.class)
@Table(name = "fusion_persona")
public class FusionPersonaEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @Id
    @Column(name="persona_id")
    private Integer personaId;
    @Id
    @Column(name = "fusion_id")
    private Integer fusionId;
    @Column(name = "fusion_r")
    private Integer fusionR;
}
