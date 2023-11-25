package com.proyectouts.adminong.services;

import java.util.List;

import com.proyectouts.adminong.dto.BancoDTO;
import com.proyectouts.adminong.dto.CuotaDTO;
import com.proyectouts.adminong.dto.SocioCuotaDTO;
import com.proyectouts.adminong.dto.SocioDTO;
import com.proyectouts.adminong.dto.SocioDTOBancoCuota;

public interface SocioService {
 
    void save(SocioDTO socio, BancoDTO banco, CuotaDTO cuota);

    List<SocioDTOBancoCuota> findAll();

    SocioCuotaDTO findSociosByCuota(String tipoCuota);
}
