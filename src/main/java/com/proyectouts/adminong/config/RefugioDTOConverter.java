package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.RefugioDTO;
import com.proyectouts.adminong.repositories.entities.RefugioEntity;

@Component
public class RefugioDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public RefugioDTO convertToDTO(RefugioEntity refugioEntity) {
        return dbm.map(refugioEntity, RefugioDTO.class);
    }

    public RefugioEntity convertToEntity(RefugioDTO refugioDTO) {
        return dbm.map(refugioDTO, RefugioEntity.class);
    }

}
