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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<String> createPersona(@Valid @RequestBody CPersonaDto cPersonaDto) {
        personaServices.createPersona(cPersonaDto);

        return ResponseEntity.status(HttpStatus.OK).body("PERSONA CREATED");
    }

    @Operation(summary = "FIND PERSONA LIST", description = "FIND ALL PERSONA SAVED IN DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GPERSONADTO LIST",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "DONT EXIST ANY PERSONA",
                    content = @Content)})
    @GetMapping(value = "find-all")
    public ResponseEntity<List<GPersonaDto>> findAllPersonas() {
        List<GPersonaDto> personaDtoList;
        personaDtoList = personaServices.findAllPersonas();

        return ResponseEntity.status(HttpStatus.OK).body(personaDtoList);
    }

    @Operation(summary = "FIND A UNIQUE PERSONA", description = "FIND A PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "GPERSONADTO",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @GetMapping(value = "find-one/{personaId}")
    public ResponseEntity<GPersonaDto> findPersonaById(@PathVariable Integer personaId) {
        GPersonaDto personaDto;
        personaDto = personaServices.findOnePersonaById(personaId);
        return ResponseEntity.status(HttpStatus.OK).body(personaDto);
    }

    @Operation(summary = "FIND A PERSONA", description = "EDIT PERSONA BY NAME")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA EDITED"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS NAME",
                    content = @Content)})
    @GetMapping(value = "find-one-by-name/{personaName}")
    public ResponseEntity<GPersonaDto> findPersonaByName(@PathVariable String personaName) {
        GPersonaDto personaDto;
        personaDto = personaServices.findPersonaByName(personaName);

        return ResponseEntity.status(HttpStatus.OK).body(personaDto);
    }

    @Operation(summary = "DELETE PERSONA", description = "DELETE PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA DELETE"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @DeleteMapping(value = "delete-one/{personaId}")
    public ResponseEntity<String> deletePersonaById(@PathVariable Integer personaId) {
        personaServices.deletePersonaById(personaId);

        return ResponseEntity.status(HttpStatus.OK).body("PERSONA ELIMINATED");
    }

    @Operation(summary = "DELETE PERSONA", description = "DELETE PERSONA BY NAME")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA DELETE"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS NAME",
                    content = @Content)})
    @DeleteMapping(value = "delete-one/{personaName}")
    public ResponseEntity<String> deletePersonaByName(@PathVariable String personaName) {
        personaServices.deletePersonaByName(personaName);

        return ResponseEntity.status(HttpStatus.OK).body("PERSONA ELIMINATED");
    }


    @Operation(summary = "EDIT PERSONA", description = "EDIT PERSONA BY ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PERSONA EDITED"),
            @ApiResponse(responseCode = "400", description = "PERSONA DOES NOT EXIST WITH THIS ID",
                    content = @Content)})
    @PutMapping(value = "edit-persona/{personaId}")
    public ResponseEntity<String> editPersona(@PathVariable Integer personaId, @RequestBody EPersonaDto personaDto) {
        personaServices.editPersona(personaId, personaDto);

        return ResponseEntity.status(HttpStatus.OK).body("PERSONA EDITED");
    }
}