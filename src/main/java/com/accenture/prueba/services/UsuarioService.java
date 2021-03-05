package com.accenture.prueba.services;

import java.util.ArrayList;

import com.accenture.prueba.models.UsuarioModel;
import com.accenture.prueba.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();

    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){

        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long idUsuario) {
        try{
            usuarioRepository.deleteById(idUsuario);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    

}