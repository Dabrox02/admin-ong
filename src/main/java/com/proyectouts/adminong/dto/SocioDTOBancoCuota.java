package com.proyectouts.adminong.dto;

import java.util.List;

import lombok.Data;

@Data
public class SocioDTOBancoCuota {
    
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private SedeDTO sede;
    private List<BancoDTO> bancos;
    private List<CuotaDTO> cuotas;

}
