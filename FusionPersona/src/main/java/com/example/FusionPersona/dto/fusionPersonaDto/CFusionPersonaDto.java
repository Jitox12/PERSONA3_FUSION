package com.example.FusionPersona.dto.fusionPersonaDto;

import com.example.FusionPersona.entities.PersonaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CFusionPersonaDto {
    @NotBlank
    @NotNull
    @Schema(description = "Persona OBJ",
            example = "Persona", required = true)
    private PersonaEntity personaDto;

    @NotBlank
    @NotNull
    @Size(min = 1)
    @Schema(description = "Fusion Id",
            example = "1", required = true)
    private Integer fusionIdDto;

    @NotBlank
    @NotNull
    @Size(min = 1)
    @Schema(description = "Fusion Result 0 = F AND 1 = V",
            example = "0", required = true)
    private Integer fusionRDto;
}