package com.proyectouts.adminong.dto;

import lombok.Data;

@Data
public class VoluntarioDTO {
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String disponibilidad;
    private String profesion;
    private String tipoVoluntario;
    private Long sedeId;
}
