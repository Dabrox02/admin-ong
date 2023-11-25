package com.proyectouts.adminong.services;

import java.util.List;

import com.proyectouts.adminong.dto.CuotaDTO;
import com.proyectouts.adminong.repositories.entities.CuotaEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;

public interface CuotaService {
    void save(CuotaDTO cuota);

    List<CuotaEntity> findCuotasBySocio(SocioEntity socio);

}
