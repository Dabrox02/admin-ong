package com.proyectouts.adminong.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectouts.adminong.dto.BancoDTO;
import com.proyectouts.adminong.repositories.entities.BancoEntity;

@Component
public class BancoDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public BancoDTO convertToDTO(BancoEntity bancoEntity) {
        return dbm.map(bancoEntity, BancoDTO.class);
    }

    public BancoEntity convertToEntity(BancoDTO bancoDTO) {
        return dbm.map(bancoDTO, BancoEntity.class);
    }

}
