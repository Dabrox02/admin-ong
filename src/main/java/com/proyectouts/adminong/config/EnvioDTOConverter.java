package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.proyectouts.adminong.dto.EnvioDTO;
import com.proyectouts.adminong.repositories.entities.EnvioEntity;

@Component
public class EnvioDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public EnvioDTO convertToDTO(EnvioEntity envioEntity) {
        return dbm.map(envioEntity, EnvioDTO.class);
    }

    public EnvioEntity convertToEntity(EnvioDTO envioDTO) {
        return dbm.map(envioDTO, EnvioEntity.class);
    }
    
}
