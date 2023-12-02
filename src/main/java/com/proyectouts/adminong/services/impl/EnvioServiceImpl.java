package com.proyectouts.adminong.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectouts.adminong.config.CargaDTOConverter;
import com.proyectouts.adminong.config.EnvioDTOConverter;
import com.proyectouts.adminong.dto.CargaDTO;
import com.proyectouts.adminong.dto.EnvioDTO;
import com.proyectouts.adminong.dto.EnvioDTOFull;
import com.proyectouts.adminong.repositories.CargaRepository;
import com.proyectouts.adminong.repositories.EnvioRepository;
import com.proyectouts.adminong.repositories.RefugioRepository;
import com.proyectouts.adminong.repositories.SedeRepository;
import com.proyectouts.adminong.repositories.entities.CargaEntity;
import com.proyectouts.adminong.repositories.entities.EnvioEntity;
import com.proyectouts.adminong.repositories.entities.RefugioEntity;
import com.proyectouts.adminong.repositories.entities.SedeEntity;
import com.proyectouts.adminong.services.EnvioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EnvioServiceImpl implements EnvioService{

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private RefugioRepository refugioRepository;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private EnvioDTOConverter envioDTOConverter;

    @Autowired
    private CargaDTOConverter cargaDTOConverter;

    @Override
    @Transactional
    public EnvioDTO save(EnvioDTO envioDTO) {
        EnvioEntity envioEntity = envioDTOConverter.convertToEntity(envioDTO);
        
        if (envioEntity.getFechaSalida() == null) {
            throw new IllegalArgumentException("La fecha no puede ser nulo o vacío");
        }

        if (envioDTO.getIdRefugio() != null) {
            RefugioEntity refugioEntity = refugioRepository.findById(envioDTO.getIdRefugio())
                    .orElseThrow(() -> new EntityNotFoundException("Refugio no encontrado con ID: " + envioDTO.getIdRefugio()));
            envioEntity.setRefugio(refugioEntity);
        }

        if (envioDTO.getSedes() != null && !envioDTO.getSedes().isEmpty()) {
            for (Long sedeId : envioDTO.getSedes()) {
                SedeEntity sedeEntity = sedeRepository.findById(sedeId)
                        .orElseThrow(() -> new EntityNotFoundException("Sede no encontrada con ID: " + sedeId));
                envioEntity.getSedes().add(sedeEntity);
            }
        }

        EnvioEntity envioGuardado = envioRepository.save(envioEntity);

        List<CargaEntity> cargaEntities = new ArrayList<>();
        if (envioDTO.getCargas() != null) {
            int i = 0;
            for (CargaDTO cargaDTO : envioDTO.getCargas()) {
                CargaEntity cargaEntity = cargaDTOConverter.convertToEntity(cargaDTO);
                cargaEntity.setEnvio(envioGuardado); // Asocia la carga con el envío
                cargaEntities.add(cargaEntity);
                envioDTO.getCargas().get(i).setIdEnvio(envioGuardado.getId());
                i++;
            }
        }

        cargaRepository.saveAll(cargaEntities);
        envioDTO.setId(envioGuardado.getId());
        return envioDTO;
    }

    @Override
    public void deleteById(Long idEnvio) {
        envioRepository.deleteById(idEnvio);
    }

    @Override
    public EnvioDTOFull findById(Long idEnvio) {
        EnvioEntity envioEntity = envioRepository.findById(idEnvio).orElse(null);
        if(envioEntity != null){
            EnvioDTOFull envioDTOFull = envioDTOConverter.convertToDTOFull(envioEntity);
            List<Long> sedes = envioRepository.findSedesByIdEnvio(envioDTOFull.getId());
            if(!sedes.isEmpty()){
                envioDTOFull.setSedes(sedes);
            }
            return envioDTOFull;
        }
        return null;
    }
}
