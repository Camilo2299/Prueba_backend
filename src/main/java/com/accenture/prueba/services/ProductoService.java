package com.accenture.prueba.services;

import java.util.ArrayList;

import com.accenture.prueba.models.ProductoModel;
import com.accenture.prueba.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productRepository;

    public ArrayList<ProductoModel> obtenerProductos() {

        return (ArrayList<ProductoModel>) productRepository.findAll();

    }

    public ProductoModel guardarProducto(ProductoModel producto) {

        return productRepository.save(producto);

    }
    public boolean eliminarProducto(Long idProducto) {
        try{
            productRepository.deleteById(idProducto);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
