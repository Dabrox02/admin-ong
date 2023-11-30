package com.proyectouts.adminong.repositories.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "socio")
public class SocioEntity extends PersonaEntity {

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "id_sede")
    private SedeEntity sede;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BancoEntity> bancos;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CuotaEntity> cuotas;
}
