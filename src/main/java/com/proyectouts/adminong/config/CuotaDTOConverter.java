package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.CuotaDTO;
import com.proyectouts.adminong.repositories.entities.CuotaEntity;

@Component
public class CuotaDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public CuotaDTO convertToDTO(CuotaEntity cuotaEntity) {
        return dbm.map(cuotaEntity, CuotaDTO.class);
    }

    public CuotaEntity convertToEntity(CuotaDTO cuotaDTO) {
        return dbm.map(cuotaDTO, CuotaEntity.class);
    }
    
}
