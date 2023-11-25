package com.proyectouts.adminong.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectouts.adminong.config.BancoDTOConverter;
import com.proyectouts.adminong.dto.BancoDTO;
import com.proyectouts.adminong.repositories.BancoRepository;
import com.proyectouts.adminong.repositories.SocioRepository;
import com.proyectouts.adminong.repositories.entities.BancoEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;
import com.proyectouts.adminong.services.BancoService;

@Service
public class BancoServiceImpl implements BancoService{

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private BancoDTOConverter bancoDTOConverter;

    @Override
    public void save(BancoDTO bancoDTO ) {
        BancoEntity bancoEntity = bancoDTOConverter.convertToEntity(bancoDTO);
        if (bancoEntity.getNombreBanco() == null || bancoEntity.getNombreBanco().isEmpty()) {
            throw new IllegalArgumentException("El nombre del banco no puede ser nulo o vacío");
        }
        SocioEntity socioEntity = socioRepository.findById(bancoDTO.getSocioId()).orElse(null);
        bancoEntity.setSocio(socioEntity);
        bancoRepository.save(bancoEntity);
    }

    @Override
    public List<BancoEntity> findBancosBySocio(SocioEntity socio) {
        List<BancoEntity> bancos = bancoRepository.findBySocio(socio);
        return bancos;
    }
    
}
