package com.proyectouts.adminong.services;

import java.util.List;

import com.proyectouts.adminong.dto.SedeDTO;

public interface SedeService {

    void save(SedeDTO sede);

    List<SedeDTO> findAll();

    void deleteById(Long idSede);

    SedeDTO findById(Long id);

    SedeDTO updateById(SedeDTO sedeDTO);
    
}
