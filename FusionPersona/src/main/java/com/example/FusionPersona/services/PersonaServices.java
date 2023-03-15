package com.example.FusionPersona.services;

import com.example.FusionPersona.dto.personaDto.CPersonaDto;
import com.example.FusionPersona.dto.personaDto.GPersonaDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonaServices {

    public void createPersona(CPersonaDto cPersonaDto);
    public GPersonaDto findOnePersonaById(Integer personaId);
    public List<GPersonaDto> findAllPersonas();
}
