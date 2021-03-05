package com.accenture.prueba.controllers;

import java.util.ArrayList;

import com.accenture.prueba.models.UsuarioModel;
import com.accenture.prueba.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import javax.persistence.*;


@RestController
@RequestMapping("/usuario")

public class UsuarioController{

    @Autowired
    
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return usuarioService.obtenerUsuarios();       

    }
    
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        
        return this.usuarioService.guardarUsuario(usuario);

    }
    @DeleteMapping( path = "/{idUsuario}")
    public String eliminarPorId(@PathVariable("idUsuario") Long idUsuario){
        boolean ok = this.usuarioService.eliminarUsuario(idUsuario);
        if (ok){
            return "Se eliminó el producto con id " + idUsuario;
        }else{
            return "No pudo producto el usuario con id" + idUsuario;
        }
    }



    



}