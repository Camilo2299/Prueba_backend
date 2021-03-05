package com.accenture.prueba.controllers;

import java.util.ArrayList;

import com.accenture.prueba.models.ProductoModel;
import com.accenture.prueba.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController{
    @Autowired

    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos(){

        return productoService.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardaProducto(@RequestBody ProductoModel producto){

        return this.productoService.guardarProducto(producto);

    }
    
    @DeleteMapping( path = "/{idProducto}")
    public String eliminarPorId(@PathVariable("idProducto") Long idProducto){
        boolean ok = this.productoService.eliminarProducto(idProducto);
        if (ok){
            return "Se eliminó el producto con id " + idProducto;
        }else{
            return "No pudo producto el usuario con id" + idProducto;
        }
    }
    
}