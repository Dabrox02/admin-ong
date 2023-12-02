package com.proyectouts.adminong.dto;

import java.util.List;

import lombok.Data;

@Data
public class EnvioDTOFull {
    
    private Long id;
    private String fechaSalida;
    private RefugioDTO refugio;
    private List<CargaDTO> cargas;
    private List<Long> sedes;

}
