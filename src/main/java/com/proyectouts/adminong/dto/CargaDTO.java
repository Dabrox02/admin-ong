package com.proyectouts.adminong.dto;

import lombok.Data;

@Data
public class CargaDTO {
    
    private Long idEnvio;
    private String tipoCarga;
    private String descripcion;
    private int cantidad;
    private String unidadMedida;

}
