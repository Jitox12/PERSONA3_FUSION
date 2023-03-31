package com.example.FusionPersona.controllers;

import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.RFusionPersonaDto;
import com.example.FusionPersona.services.FusionPersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/fusion-persona")
@Tag(name = "Persona Fusion API", description = "Persona CRU API")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class FusionPersonaController {

    private final FusionPersonaService fusionPersonaService;

    public FusionPersonaController(FusionPersonaService fusionPersonaService) {
        this.fusionPersonaService = fusionPersonaService;
    }

    @Operation(summary = "CREATE FUSION PERSONA", description = "CREATE FUSION PERSONA WITH DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA FUSION CREATED",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "UNCREATED PERSONA FUSION",
                    content = @Content)})
    @PostMapping(value = "/create")
    public ResponseEntity<String> createFusionPersona(@RequestBody List<RFusionPersonaDto> fusionPersonaDto) {
        fusionPersonaService.createFusionPersona(fusionPersonaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Merged Persona");
    }

    @Operation(summary = "GET FUSION PERSONA", description = "GET FUSION PERSONA WITH DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "FUSION PERSONA LIST BY ID",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "FUSION PERSONA DOES NOT EXIST WHIT PERSONA ID",
                    content = @Content)})
    @GetMapping(value = "/find-by-persona-id/{personaId}")
    public ResponseEntity<List<GFusionPersonaDto>> findFusionPersonaByPersonaId(@PathVariable Integer personaId) {
        List<GFusionPersonaDto> gFusionPersonaDto = null;

        gFusionPersonaDto = fusionPersonaService.findFusionPersonaByPersonaId(personaId);
        return ResponseEntity.status(HttpStatus.OK).body(gFusionPersonaDto);
    }
}