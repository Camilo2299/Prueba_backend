package com.accenture.prueba.controllers;

import java.util.ArrayList;

import com.accenture.prueba.models.DomicilioModel;
import com.accenture.prueba.services.DomicilioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {
    @Autowired
    DomicilioService domicilioService;

    @GetMapping()
    public ArrayList<DomicilioModel> obtenerDomicilio(){

        return this.domicilioService.obtenerDomicilio();
    }

    @PostMapping()
    public DomicilioModel guardaDomicilio(@RequestBody DomicilioModel domicilio){

        return this.domicilioService.guardarDomicilio(domicilio);

    }
    
    @DeleteMapping( path = "/{idDomicilio}")
    public String eliminarPorId(@PathVariable("idDomicilio") Long idDomicilio){
        boolean ok = this.domicilioService.eliminarDomicilio(idDomicilio);
        if (ok){
            return "Se eliminó el producto con id " + idDomicilio;
        }else{
            return "No pudo producto el usuario con id" + idDomicilio;
        }
    }

}
