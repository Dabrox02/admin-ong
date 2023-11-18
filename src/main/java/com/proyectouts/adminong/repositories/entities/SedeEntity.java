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
@Table(name = "sede")
public class SedeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreDirector;
    private String ciudad;
    private String pais;
    @JoinColumn(name = "id_organizacion")
    @ManyToOne
    private OrganizacionEntity organizacion;
}
