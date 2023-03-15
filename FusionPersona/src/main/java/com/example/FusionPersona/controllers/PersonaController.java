package com.example.FusionPersona.controllers;

import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.GPersonaDto;
import com.example.FusionPersona.services.PersonaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Persona's API", description = "Persona CRUD API")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping(value = "/api/persona")
public class PersonaController {
    private final PersonaServices personaServices;

    public PersonaController(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    @Operation(summary = "CREATE PERSONA", description = "CREATED PERSONA WITH DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA CREATED",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CPersonaDto.class))}),
            @ApiResponse(responseCode = "400", description = "UNCREATED PERSONA",
                    content = @Content)})
    @PostMapping(value = "create")
    public String createPersona(@RequestBody CPersonaDto cPersonaDto) {
        personaServices.createPersona(cPersonaDto);

        return "PERSONA CREATED";
    }

    @Operation(summary = "FIND PERSONA LIST", description = "FIND ALL PERSONA SAVED IN DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GPERSONADTO LIST",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CPersonaDto.class))}),
            @ApiResponse(responseCode = "400", description = "DONT EXIST ANY PERSONA",
                    content = @Content)})
    @GetMapping(value = "find-all")
    public List<GPersonaDto> findAllPersonas() {
        List<GPersonaDto> personaDtoList = null;
        personaDtoList = personaServices.findAllPersonas();

        return personaDtoList;
    }

    @Operation(summary = "FIND A UNIQUE PERSONA", description = "FIND A PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GPERSONADTO",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CPersonaDto.class))}),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @GetMapping(value = "find-one/{personaId}")
    public GPersonaDto findPersonaById(@PathVariable Integer personaId) {
        GPersonaDto personaDto = null;
        personaDto = personaServices.findOnePersonaById(personaId);

        return personaDto;
    }
}