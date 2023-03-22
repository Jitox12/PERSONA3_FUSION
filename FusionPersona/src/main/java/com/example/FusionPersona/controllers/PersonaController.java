package com.example.FusionPersona.controllers;

import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.EPersonaDto;
import com.example.FusionPersona.dto.personaDto.GPersonaDto;
import com.example.FusionPersona.services.PersonaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Persona's API", description = "Persona CRUD API")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/persona")
public class PersonaController {
    private final PersonaServices personaServices;

    public PersonaController(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    @Operation(summary = "CREATE PERSONA", description = "CREATED PERSONA WITH DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "PERSONA CREATED",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "UNCREATED PERSONA",
                    content = @Content)})
    @PostMapping(value = "create")
    public void createPersona(@RequestBody CPersonaDto cPersonaDto) {
        personaServices.createPersona(cPersonaDto);
    }

    @Operation(summary = "FIND PERSONA LIST", description = "FIND ALL PERSONA SAVED IN DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GPERSONADTO LIST",
                    content = {@Content(mediaType = "application/json")}),
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
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @GetMapping(value = "find-one/{personaId}")
    public GPersonaDto findPersonaById(@PathVariable Integer personaId) {
        GPersonaDto personaDto = null;
        personaDto = personaServices.findOnePersonaById(personaId);
        return personaDto;
    }

    @Operation(summary = "DELETE PERSONA", description = "DELETE PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA DELETE"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @DeleteMapping(value = "delete-one/{personaId}")
    public void deletePersonaById(@PathVariable Integer personaId) {
        personaServices.deletePersonaById(personaId);
    }

    @Operation(summary = "EDIT PERSONA", description = "EDIT PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA EDITED"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @PutMapping(value = "edit-persona/{personaId}")
    public void editPersona(@PathVariable Integer personaId, @RequestBody EPersonaDto personaDto){
        personaServices.editPersona(personaId, personaDto);
    }
}