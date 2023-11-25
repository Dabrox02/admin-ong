package com.proyectouts.adminong.repositories.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sede")
public class SedeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciudad;
    private String pais;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_voluntario_jefe", nullable = true)
    private VoluntarioEntity voluntarioJefe;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_organizacion")
    private OrganizacionEntity organizacion;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name="sede_envio",
        joinColumns=@JoinColumn(name="id_sede"),
        inverseJoinColumns=@JoinColumn(name="id_envio")
    )
    private Set<EnvioEntity> envios;
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<SocioEntity> socios;
}
