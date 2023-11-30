package com.proyectouts.adminong.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.SedeEntity;

public interface SedeRepository extends CrudRepository<SedeEntity, Long>{

    @Modifying
    @Query(value = "DELETE FROM sede_envio WHERE id_sede = ?1", nativeQuery = true)
    void deleteAllEnvios(Long idEnvioEliminar);

}
