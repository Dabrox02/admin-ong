package com.proyectouts.adminong.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.VoluntarioEntity;

public interface VoluntarioRepository extends CrudRepository<VoluntarioEntity, Long>{
    
    @Modifying
    @Query(value = "UPDATE SEDE SET ID_VOLUNTARIO_JEFE = NULL WHERE ID_VOLUNTARIO_JEFE = ?1", nativeQuery = true)
    void deleteJefeWithSede(Long idVoluntario);

}
