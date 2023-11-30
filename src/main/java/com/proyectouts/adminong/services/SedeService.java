package com.proyectouts.adminong.services;

import java.util.List;

import com.proyectouts.adminong.dto.SedeDTO;
import com.proyectouts.adminong.repositories.entities.SedeEntity;

public interface SedeService {

    void save(SedeDTO sede);

    List<SedeDTO> findAll();

    void deleteById(Long idSede);

    SedeDTO findById(Long id);

    SedeEntity updateById(SedeDTO sedeDTO);
    
}
