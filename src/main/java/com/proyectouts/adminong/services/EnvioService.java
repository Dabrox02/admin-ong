package com.proyectouts.adminong.services;

import com.proyectouts.adminong.dto.EnvioDTO;

public interface EnvioService {
    
    EnvioDTO save(EnvioDTO envioDTOCargaRefugio);

    void deleteById(Long id);

    EnvioDTO findById(Long id);
}
