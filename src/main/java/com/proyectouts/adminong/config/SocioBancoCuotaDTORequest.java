package com.proyectouts.adminong.config;

import com.proyectouts.adminong.dto.BancoDTO;
import com.proyectouts.adminong.dto.CuotaDTO;
import com.proyectouts.adminong.dto.SocioDTO;

import lombok.Data;

@Data
public class SocioBancoCuotaDTORequest {
    
    private SocioDTO socioDTO;
    private BancoDTO bancoDTO;
    private CuotaDTO cuotaDTO;
    
}
