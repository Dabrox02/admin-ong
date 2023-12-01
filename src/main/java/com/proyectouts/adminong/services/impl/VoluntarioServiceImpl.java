package com.proyectouts.adminong.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.proyectouts.adminong.config.VoluntarioDTOConverter;
import com.proyectouts.adminong.dto.VoluntarioDTO;
import com.proyectouts.adminong.repositories.SedeRepository;
import com.proyectouts.adminong.repositories.VoluntarioRepository;
import com.proyectouts.adminong.repositories.entities.SedeEntity;
import com.proyectouts.adminong.repositories.entities.VoluntarioEntity;
import com.proyectouts.adminong.services.VoluntarioService;

import jakarta.transaction.Transactional;

@Service
public class VoluntarioServiceImpl implements VoluntarioService{

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private VoluntarioDTOConverter voluntarioDTOConverter;

    @Override
    public void save(VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntarioEntity = voluntarioDTOConverter.convertToEntity(voluntarioDTO);
        if (voluntarioEntity.getNombres() == null || voluntarioEntity.getNombres().isEmpty()) {
            throw new IllegalArgumentException("El nombre del socio no puede ser nulo o vacío");
        }
        
        if (voluntarioEntity.getApellidos() == null || voluntarioEntity.getApellidos().isEmpty()) {
            throw new IllegalArgumentException("El apellido del socio no puede ser nulo o vacío");
        }
        
        if (voluntarioEntity.getEmail() == null || voluntarioEntity.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del socio no puede ser nulo o vacío");
        }
        
        if (voluntarioEntity.getTelefono() == null || voluntarioEntity.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del socio no puede ser nulo o vacío");
        }

        if (voluntarioEntity.getDisponibilidad() == null 
        || voluntarioEntity.getDisponibilidad().isEmpty() 
        || (!voluntarioEntity.getDisponibilidad().equalsIgnoreCase("si")
        && !voluntarioEntity.getDisponibilidad().equalsIgnoreCase("no"))) {
            throw new IllegalArgumentException("Disponibilidad debe ser si o no: " + voluntarioEntity.getDisponibilidad());
        }

        if (voluntarioEntity.getTipoVoluntario() == null 
        || voluntarioEntity.getTipoVoluntario().isEmpty() 
        || (!voluntarioEntity.getTipoVoluntario().equalsIgnoreCase("administrativo")
        && !voluntarioEntity.getTipoVoluntario().equalsIgnoreCase("sanitario"))) {
            throw new IllegalArgumentException("Tipo Voluntario debe ser sanitario o administrativo");
        }

        SedeEntity sedeEntity = sedeRepository.findById(voluntarioDTO.getSedeId()).orElse(null);
        if(sedeEntity == null){
            throw new IllegalArgumentException("Sede no existente");
        }

        voluntarioEntity.setSede(sedeEntity);
        voluntarioRepository.save(voluntarioEntity);
    }

    @Override
    public List<VoluntarioDTO> findAll() {
        List<VoluntarioEntity> voluntarioEntities = (List<VoluntarioEntity>) voluntarioRepository.findAll();
        return voluntarioEntities.stream().map(voluntario->voluntarioDTOConverter.convertToDTO(voluntario)).toList();
    }

    @Override
    public VoluntarioDTO findById(Long idVoluntario) {
        VoluntarioEntity voluntarioEntity;
        try {
            voluntarioEntity = voluntarioRepository.findById(idVoluntario).orElseThrow(() -> new NotFoundException());
            return voluntarioDTOConverter.convertToDTO(voluntarioEntity);
        } catch (NotFoundException e) {
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long idVoluntario) {
        VoluntarioEntity voluntarioEntity = voluntarioRepository.findById(idVoluntario).orElse(null);
        if(voluntarioEntity != null){
            voluntarioRepository.deleteJefeWithSede(voluntarioEntity.getId());
            voluntarioRepository.deleteById(idVoluntario);
        }
    }

    @Override
    public VoluntarioDTO updateById(VoluntarioDTO voluntarioDTO) {
        try {
            VoluntarioEntity voluntarioEntity = voluntarioRepository.findById(voluntarioDTO.getId()).orElseThrow(() -> new NotFoundException());
            voluntarioEntity.setDni(voluntarioDTO.getDni() != null ? voluntarioDTO.getDni() : voluntarioEntity.getDni());
            voluntarioEntity.setNombres(voluntarioDTO.getNombres() != null ? voluntarioDTO.getNombres() : voluntarioEntity.getNombres());
            voluntarioEntity.setApellidos(voluntarioDTO.getApellidos() != null ? voluntarioDTO.getApellidos() : voluntarioEntity.getApellidos());
            voluntarioEntity.setEmail(voluntarioDTO.getEmail() != null ? voluntarioDTO.getEmail() : voluntarioEntity.getEmail());
            voluntarioEntity.setTelefono(voluntarioDTO.getTelefono() != null ? voluntarioDTO.getTelefono() : voluntarioEntity.getTelefono());
            voluntarioEntity.setProfesion(voluntarioDTO.getProfesion() != null ? voluntarioDTO.getProfesion() : voluntarioEntity.getProfesion());
            
            if  (voluntarioDTO.getDisponibilidad() != null) {
                if(!voluntarioDTO.getDisponibilidad().equalsIgnoreCase("si")
                && !voluntarioDTO.getDisponibilidad().equalsIgnoreCase("no")){
                    throw new IllegalArgumentException("Disponibilidad debe ser si o no: " + voluntarioDTO.getDisponibilidad());
                }else{
                    voluntarioEntity.setDisponibilidad(voluntarioDTO.getDisponibilidad() != null ? voluntarioDTO.getDisponibilidad() : voluntarioEntity.getDisponibilidad());
                }
            }

            if (voluntarioDTO.getTipoVoluntario() != null) {
                if(!voluntarioDTO.getTipoVoluntario().equalsIgnoreCase("administrativo")
                    && !voluntarioDTO.getTipoVoluntario().equalsIgnoreCase("sanitario")){
                    throw new IllegalArgumentException("Tipo Voluntario debe ser sanitario o administrativo");
                }else{
                    voluntarioEntity.setTipoVoluntario(voluntarioDTO.getTipoVoluntario() != null ? voluntarioDTO.getTipoVoluntario() : voluntarioEntity.getTipoVoluntario());
                }
            }
            
            if(voluntarioDTO.getSedeId() != null){
                SedeEntity sedeExistente = sedeRepository.findById(voluntarioDTO.getSedeId()).orElseThrow(() -> new NotFoundException());
                voluntarioEntity.setSede(sedeExistente);
            }
            VoluntarioEntity voluntarioActualizado = voluntarioRepository.save(voluntarioEntity);
            VoluntarioDTO voluntarioReturn = voluntarioDTOConverter.convertToDTO(voluntarioActualizado);
            return voluntarioReturn;
        } catch (NotFoundException e) {
        }
        return null;
    }

    @Override
    public List<VoluntarioDTO> findVoluntarioBySede(Long idSede) {
        List<VoluntarioEntity> voluntarioEntities = voluntarioRepository.findByIdSede(idSede);
        List<VoluntarioDTO> voluntarioDTOs = voluntarioEntities.stream()
        .map(voluntario -> voluntarioDTOConverter.convertToDTO(voluntario))
        .toList();
        return voluntarioDTOs;
    }

    @Override
    public List<VoluntarioDTO> findVoluntarioByProfesion(String profesion) {
        List<VoluntarioEntity> voluntarioEntities = voluntarioRepository.findByProfesion(profesion);
        List<VoluntarioDTO> voluntarioDTOs = voluntarioEntities.stream()
        .map(voluntario -> voluntarioDTOConverter.convertToDTO(voluntario))
        .toList();
        return voluntarioDTOs;
    }
}
