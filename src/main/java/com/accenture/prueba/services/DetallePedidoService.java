package com.accenture.prueba.services;

import java.util.ArrayList;

import com.accenture.prueba.models.DetallePedidoModel;
import com.accenture.prueba.repositories.DetallePedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoService {
    @Autowired

    DetallePedidoRepository detallePedidoRepository;

    public  ArrayList<DetallePedidoModel> obtenerDetallePedido(){

        return (ArrayList<DetallePedidoModel>) detallePedidoRepository.findAll();


    }

    public DetallePedidoModel guardarDetallePedido(DetallePedidoModel detallePedido){

        return detallePedidoRepository.save(detallePedido);

    }

    public boolean eliminarDetallePedido(Long idDetallePedido) {
        try{
            detallePedidoRepository.deleteById(idDetallePedido);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
