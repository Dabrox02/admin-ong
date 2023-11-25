package com.proyectouts.adminong.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectouts.adminong.repositories.entities.SedeEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;
import java.util.List;


public interface SocioRepository extends CrudRepository<SocioEntity, Long>{

    List<SocioEntity> findBySede(SedeEntity sede);

    @Query(value = "SELECT s.* FROM socio s JOIN cuota c ON s.id = c.id_socio WHERE c.tipo_cuota = ?1", nativeQuery = true)
    List<SocioEntity> findSociosByTipoCuota(String tipoCuota);
}
