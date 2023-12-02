package com.proyectouts.adminong.repositories.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "envio")
public class EnvioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaSalida;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_refugio", nullable = true)
    private RefugioEntity refugio;

    @ManyToMany()
    @JoinTable(
        name = "sede_envio",
        joinColumns = {@JoinColumn(name = "id_envio")},
        inverseJoinColumns = {@JoinColumn(name = "id_sede")}
    )
    private Set<SedeEntity> sedes;
}
