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

import com.proyectouts.adminong.dto.SedeDTO;
import com.proyectouts.adminong.services.SedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/")
    public List<SedeDTO> findAll(){
        return sedeService.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody SedeDTO sedeDTO){
        sedeService.save(sedeDTO);
    }

    @DeleteMapping("/{idSede}")
    public void deleteById(@PathVariable Long idSede){
        sedeService.deleteById(idSede);        
    }
    
}
