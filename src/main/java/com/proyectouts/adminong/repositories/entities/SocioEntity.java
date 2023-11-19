package com.proyectouts.adminong.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "socio")
public class SocioEntity extends PersonaEntity {
    @JoinColumn(name = "id_sede")
    @ManyToOne
    private SedeEntity sede;
}
