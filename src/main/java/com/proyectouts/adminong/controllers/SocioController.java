package com.proyectouts.adminong.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectouts.adminong.config.SocioBancoCuotaDTORequest;
import com.proyectouts.adminong.dto.SocioDTOBancoCuota;
import com.proyectouts.adminong.services.SocioService;

@RestController
@RequestMapping("/socio")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("/")
    public List<SocioDTOBancoCuota> findAll(){
        return socioService.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody SocioBancoCuotaDTORequest request){
        socioService.save(request.getSocioDTO(), request.getBancoDTO(), request.getCuotaDTO());
    }

    
}
