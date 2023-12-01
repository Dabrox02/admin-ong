package com.proyectouts.adminong.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectouts.adminong.dto.VoluntarioDTO;
import com.proyectouts.adminong.services.VoluntarioService;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping("/")
    public List<VoluntarioDTO> findAll(){
        return voluntarioService.findAll();
    }

    @GetMapping("/id/{idVoluntario}")
    public VoluntarioDTO findVoluntarioById(@PathVariable Long idVoluntario){
        return voluntarioService.findById(idVoluntario);
    }

    @PostMapping("/")
    public void save(@RequestBody VoluntarioDTO voluntarioDTO){
        voluntarioService.save(voluntarioDTO);
    }
    
    @DeleteMapping("/id/{idVoluntario}")
    public void deleteVoluntarioById(@PathVariable Long idVoluntario){
        voluntarioService.deleteById(idVoluntario);
    }

}
