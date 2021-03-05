package com.accenture.prueba.services;

import java.util.ArrayList;

import com.accenture.prueba.models.DomicilioModel;
import com.accenture.prueba.repositories.DomicilioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;

    public ArrayList<DomicilioModel> obtenerDomicilio() {

        return (ArrayList<DomicilioModel>) domicilioRepository.findAll();

    }

    public DomicilioModel guardarDomicilio(DomicilioModel domicilio){

        return domicilioRepository.save(domicilio);

    }
    public boolean eliminarDomicilio(Long idDomicilio) {
        try{
            domicilioRepository.deleteById(idDomicilio);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
