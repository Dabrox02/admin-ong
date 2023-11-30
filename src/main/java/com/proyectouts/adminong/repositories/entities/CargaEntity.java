package com.proyectouts.adminong.repositories.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carga")
public class CargaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoCarga;
    private String descripcion;
    @Column(nullable = true)
    private int cantidad;
    @Column(nullable = true)
    private String unidadMedida;
    
    @ManyToOne()
    @JoinColumn(name = "id_envio")
    private EnvioEntity envio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "mision",
        joinColumns = {@JoinColumn(name = "id_voluntario")},
        inverseJoinColumns = {@JoinColumn(name = "id_carga")}
    )
    private Set<VoluntarioEntity> voluntarios;
}
