package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.SocioDTOBancoCuota;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

@Component
public class SocioDTOBancoCuotaConverter {
 
    @Autowired
    private ModelMapper dbm;
    
    public SocioDTOBancoCuota convertToDTO(SocioEntity socioEntity) {
        return dbm.map(socioEntity, SocioDTOBancoCuota.class);
    }

    public SocioEntity convertToEntity(SocioDTOBancoCuota socioDTOBancoCuota) {
        return dbm.map(socioDTOBancoCuota, SocioEntity.class);
    }
}
