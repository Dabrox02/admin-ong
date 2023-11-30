package com.proyectouts.adminong.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
