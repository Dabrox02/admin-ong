package com.proyectouts.adminong.repositories.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "voluntario")
public class VoluntarioEntity extends PersonaEntity{
    private String disponibilidad;
    private String profesion;
    private String tipoVoluntario;

    @ManyToOne()
    @JoinColumn(name = "id_sede")
    private SedeEntity sede;

    @ManyToMany(mappedBy = "voluntarios", cascade = CascadeType.ALL)
    private Set<CargaEntity> cargas;
}
