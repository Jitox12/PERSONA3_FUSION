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
public class GFusionPersonaDto {
    @NotBlank
    @NotNull(message = "Persona should not be null")
    @Size(min = 1)
    @Schema(description = "Persona Obj",
            example = "1", required = true)
    private PersonaEntity persona;

    @NotBlank
    @NotNull(message = "fusionIdDto should not be null")
    @Size(min = 1)
    @Schema(description = "Fusion Id",
            example = "1", required = true)
    private Integer fusionIdDto;

    @NotBlank
    @NotNull(message = "fusionRDto should't be null")
    @Size(min = 1)
    @Schema(description = "Fusion Result 0 = F AND 1 = V",
            example = "0", required = true)
    private Integer fusionRDto;
}