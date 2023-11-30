package com.proyectouts.adminong.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cuota")
public class CuotaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fechaPago;
    private String tipoCuota;
    private double valorCuota;

    @JoinColumn(name = "id_socio")
    @ManyToOne()
    private SocioEntity socio;
}