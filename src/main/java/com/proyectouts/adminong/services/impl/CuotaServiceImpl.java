package com.proyectouts.adminong.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectouts.adminong.config.CuotaDTOConverter;
import com.proyectouts.adminong.dto.CuotaDTO;
import com.proyectouts.adminong.repositories.CuotaRepository;
import com.proyectouts.adminong.repositories.SocioRepository;
import com.proyectouts.adminong.repositories.entities.CuotaEntity;
import com.proyectouts.adminong.repositories.entities.SocioEntity;
import com.proyectouts.adminong.services.CuotaService;

@Service
public class CuotaServiceImpl implements CuotaService {

    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private CuotaDTOConverter cuotaDTOConverter;

    @Override
    public void save(CuotaDTO cuotaDTO) {
        try {
            CuotaEntity cuotaEntity = cuotaDTOConverter.convertToEntity(cuotaDTO);
            if (cuotaEntity.getFechaPago() == null || cuotaEntity.getFechaPago().isEmpty()) {
                throw new IllegalArgumentException("La fecha de pago de la cuotaEntity no puede ser nula o vacía");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false); // No permite fechas inválidas
            dateFormat.parse(cuotaEntity.getFechaPago());

            if(!cuotaEntity.getTipoCuota().equalsIgnoreCase("minima") && !cuotaEntity.getTipoCuota().equalsIgnoreCase("media") && !cuotaEntity.getTipoCuota().equalsIgnoreCase("maxima")) {
                throw new IllegalArgumentException("El tipo de cuota no es valido");
            } 
            
            if(cuotaEntity.getTipoCuota().equalsIgnoreCase("minima")){
                cuotaEntity.setValorCuota(10);
            } 
            if(cuotaEntity.getTipoCuota().equalsIgnoreCase("media")){
                cuotaEntity.setValorCuota(20);
            } 
            if(cuotaEntity.getTipoCuota().equalsIgnoreCase("maxima")){
                cuotaEntity.setValorCuota(30);
            }

            SocioEntity socioEntity = socioRepository.findById(cuotaDTO.getSocioId()).orElse(null);
            cuotaEntity.setSocio(socioEntity);
            cuotaRepository.save(cuotaEntity);
        } catch (ParseException e) {
            throw new IllegalArgumentException("La fecha de pago de la cuota no es una fecha válida");
        }
    }

    @Override
    public List<CuotaEntity> findCuotasBySocio(SocioEntity socio) {
        List<CuotaEntity> cuotas = cuotaRepository.findBySocio(socio);
        return cuotas;
    }

}
