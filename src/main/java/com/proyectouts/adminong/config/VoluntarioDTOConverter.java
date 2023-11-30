package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.VoluntarioDTO;
import com.proyectouts.adminong.repositories.entities.VoluntarioEntity;

@Component
public class VoluntarioDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public VoluntarioDTO convertToDTO(VoluntarioEntity voluntarioEntity){
        return dbm.map(voluntarioEntity, VoluntarioDTO.class);
    }

    public VoluntarioEntity convertToEntity(VoluntarioDTO voluntarioDTO){
        return dbm.map(voluntarioDTO, VoluntarioEntity.class);
    }
}
