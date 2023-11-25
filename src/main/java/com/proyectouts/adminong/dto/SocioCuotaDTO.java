package com.proyectouts.adminong.dto;

import java.util.List;

import lombok.Data;

@Data
public class SocioCuotaDTO {
    
    private String tipoCuota;
    private List<SocioDTO> socios;

}
