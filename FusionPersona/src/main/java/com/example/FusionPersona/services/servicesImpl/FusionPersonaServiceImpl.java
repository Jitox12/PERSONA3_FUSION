package com.example.FusionPersona.services.servicesImpl;

import com.example.FusionPersona.dao.FusionPersonaDao;
import com.example.FusionPersona.dto.fusionPersonaDto.CFusionPersonaDto;
import com.example.FusionPersona.services.FusionPersonaService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FusionPersonaServiceImpl implements FusionPersonaService {

    private final FusionPersonaDao fusionPersonaDao;

    public FusionPersonaServiceImpl(FusionPersonaDao fusionPersonaDao) {
        this.fusionPersonaDao = fusionPersonaDao;
    }

    @Override
    public void createFusionPersona(List<CFusionPersonaDto> fusionPersonaDtoList) {
        try {
            fusionPersonaDao.createFusionPersona(fusionPersonaDtoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
