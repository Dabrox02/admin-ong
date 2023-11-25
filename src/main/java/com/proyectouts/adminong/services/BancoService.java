package com.proyectouts.adminong.services;

import java.util.List;

import com.proyectouts.adminong.dto.BancoDTO;
import com.proyectouts.adminong.repositories.entities.BancoEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

public interface BancoService {
    
    void save(BancoDTO banco);

    List<BancoEntity> findBancosBySocio(SocioEntity socio);

}
