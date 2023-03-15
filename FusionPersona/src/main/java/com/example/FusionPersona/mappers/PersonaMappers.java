package com.example.FusionPersona.mappers;

import com.example.FusionPersona.dto.personaDto.GPersonaDto;
import com.example.FusionPersona.entities.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonaMappers {
    PersonaMappers INSTANCE = Mappers.getMapper( PersonaMappers.class );

    @Mapping(source = "personaId", target = "personaIdDto")
    @Mapping(source = "personaName", target = "personaNameDto")
    @Mapping(source = "personaImg", target = "personaImgDto")
    GPersonaDto PersonaEntityToPersonaDto(PersonaEntity persona);

}
