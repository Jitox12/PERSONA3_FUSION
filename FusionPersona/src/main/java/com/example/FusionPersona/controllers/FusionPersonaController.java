package com.example.FusionPersona.controllers;

import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.services.FusionPersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public String createFusionPersona(@RequestBody List<CFusionPersonaDto> fusionPersonaDto) {
        fusionPersonaService.createFusionPersona(fusionPersonaDto);
        return "FUSION CREATED";
    }

    @Operation(summary = "GET FUSION PERSONA", description = "GET FUSION PERSONA WITH DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "FUSION PERSONA LIST BY ID",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "FUSION PERSONA DOES NOT EXIST WHIT PERSONA ID",
                    content = @Content)})
    @GetMapping(value = "/find-by-persona-id/{personaId}")
    public List<GFusionPersonaDto> findFusionPersonaByPersonaId(@PathVariable Integer personaId) {
        List<GFusionPersonaDto> gFusionPersonaDto = null;

        gFusionPersonaDto = fusionPersonaService.findFusionPersonaByPersonaId(personaId);
        return gFusionPersonaDto;
    }
}