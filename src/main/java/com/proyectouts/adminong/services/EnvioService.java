package com.proyectouts.adminong.services;

import com.proyectouts.adminong.dto.EnvioDTO;
import com.proyectouts.adminong.dto.EnvioDTOFull;

public interface EnvioService {
    
    EnvioDTO save(EnvioDTO envioDTOCargaRefugio);

    void deleteById(Long idEnvio);

    EnvioDTOFull findById(Long idEnvio);
}
