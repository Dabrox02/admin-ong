package com.proyectouts.adminong.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.EnvioEntity;

public interface EnvioRepository extends CrudRepository<EnvioEntity, Long>{
    
    @Query(value = "SELECT ID_SEDE FROM SEDE_ENVIO WHERE ID_ENVIO = ?1", nativeQuery = true)
    List<Long> findSedesByIdEnvio(Long idEnvio);

}
