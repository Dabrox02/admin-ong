package com.proyectouts.adminong.repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.BancoEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

import java.util.List;


public interface BancoRepository extends CrudRepository<BancoEntity, Long> {
    List<BancoEntity> findBySocio(SocioEntity socio);
}
