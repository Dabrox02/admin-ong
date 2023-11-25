package com.proyectouts.adminong.repositories.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "socio")
public class SocioEntity extends PersonaEntity {
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sede")
    private SedeEntity sede;
}
