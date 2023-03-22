package com.example.FusionPersona.dto.personaDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CPersonaDto {
    @NotBlank
    @Size(min = 3, max = 50)
    @Schema(description = "Name of the Persona",
            example = "Walama The God Of Destruction", required = true)
    private String personaNameDto;
    @NotBlank
    @Schema(description = "Base64 String",
            example ="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"
            , required = true)
    private String personaImgDto;
}