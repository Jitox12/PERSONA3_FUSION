package com.example.FusionPersona.mappers;

import com.example.FusionPersona.dto.fusionPersonaDto.GFusionPersonaDto;
import com.example.FusionPersona.entities.FusionPersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FusionPersonaMappers {
    FusionPersonaMappers INSTANCE = Mappers.getMapper( FusionPersonaMappers.class );

    @Mapping(source = "persona", target = "persona")
    @Mapping(source = "fusionId", target = "fusionIdDto")
    @Mapping(source = "fusionR", target = "fusionRDto")
    GFusionPersonaDto fusionPersonaEntityToFusionPersonaDto(FusionPersonaEntity fusionPersona);
}