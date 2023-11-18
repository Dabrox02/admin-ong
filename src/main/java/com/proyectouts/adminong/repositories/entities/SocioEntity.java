package com.proyectouts.adminong.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "socio")
public class SocioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String dni;
    private String nombres;
    private String apellidos;
    @Column(unique = true)
    private String telefono;
    @Column(unique = true)
    private String email;
    @JoinColumn(name = "id_sede")
    @ManyToOne
    private SedeEntity sede;
}