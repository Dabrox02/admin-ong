package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.SocioDTO;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

@Component
public class SocioDTOConverter {

    @Autowired
    private ModelMapper dbm;
    
    public SocioDTO convertToDTO(SocioEntity socioEntity) {
        return dbm.map(socioEntity, SocioDTO.class);
    }

    public SocioEntity convertToEntity(SocioDTO socioDTO) {
        return dbm.map(socioDTO, SocioEntity.class);
    }
}
