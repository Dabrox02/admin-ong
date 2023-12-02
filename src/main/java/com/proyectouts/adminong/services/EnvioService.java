package com.proyectouts.adminong.services;

import com.proyectouts.adminong.dto.EnvioDTO;

public interface EnvioService {
    
    EnvioDTO save(EnvioDTO envioDTOCargaRefugio);

    void deleteById(Long idEnvio);

    EnvioDTO findById(Long idEnvio);
}
