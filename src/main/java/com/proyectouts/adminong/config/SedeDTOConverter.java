package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.SedeDTO;
import com.proyectouts.adminong.repositories.entities.SedeEntity;

@Component
public class SedeDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public SedeDTO convertToDTO(SedeEntity sede){
        SedeDTO sedeDTO = dbm.map(sede, SedeDTO.class);
        if(sede.getVoluntarioJefe() != null){
            sedeDTO.setVoluntarioJefeId(sede.getVoluntarioJefe().getId());
        }
        sedeDTO.setOrganizacionId(sede.getOrganizacion().getId());
        return sedeDTO;
    }

    public SedeEntity convertToEntity(SedeDTO sedeDTO) {
        return dbm.map(sedeDTO, SedeEntity.class);
    }

}
