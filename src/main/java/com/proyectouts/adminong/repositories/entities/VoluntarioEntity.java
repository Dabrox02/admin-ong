package com.proyectouts.adminong.repositories.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "voluntario")
@EqualsAndHashCode(callSuper=false)
public class VoluntarioEntity extends PersonaEntity{
    private String disponibilidad;
    private String profesion;
    private String tipoVoluntario;
    @JoinColumn(name = "id_sede")
    @ManyToOne
    private SedeEntity sede;
    @ManyToMany(mappedBy = "voluntarios")
    private Set<CargaEntity> cargas;
}
