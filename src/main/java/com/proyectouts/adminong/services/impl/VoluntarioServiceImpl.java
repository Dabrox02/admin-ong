package com.proyectouts.adminong.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.proyectouts.adminong.config.VoluntarioDTOConverter;
import com.proyectouts.adminong.dto.VoluntarioDTO;
import com.proyectouts.adminong.repositories.VoluntarioRepository;
import com.proyectouts.adminong.repositories.entities.VoluntarioEntity;
import com.proyectouts.adminong.services.VoluntarioService;

import jakarta.transaction.Transactional;

@Service
public class VoluntarioServiceImpl implements VoluntarioService{

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private VoluntarioDTOConverter voluntarioDTOConverter;

    @Override
    public void save(VoluntarioDTO voluntarioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }
    


}
