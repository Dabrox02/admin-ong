package com.proyectouts.adminong.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectouts.adminong.dto.EnvioDTO;
import com.proyectouts.adminong.services.EnvioService;

@RestController
@RequestMapping("/envio")
public class EnvioController {
    
    @Autowired
    private EnvioService envioService;


    @PostMapping("/")
    public EnvioDTO save(@RequestBody EnvioDTO envioDTO){
        return envioService.save(envioDTO);
    }


}
