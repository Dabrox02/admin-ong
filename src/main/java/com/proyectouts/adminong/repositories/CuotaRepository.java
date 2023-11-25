package com.proyectouts.adminong.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.CuotaEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

public interface CuotaRepository extends CrudRepository<CuotaEntity, Long>{
    List<CuotaEntity> findBySocio(SocioEntity socio);
}
