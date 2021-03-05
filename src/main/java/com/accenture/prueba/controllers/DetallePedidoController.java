package com.accenture.prueba.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.accenture.prueba.models.DetallePedidoModel;
import com.accenture.prueba.services.DetallePedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
public class DetallePedidoController {
    @Autowired

    DetallePedidoService detallePedidoService;

    @GetMapping()
    public ArrayList<DetallePedidoModel> obtenerDetallePedido() {

        return detallePedidoService.obtenerDetallePedido();
    }

    @PostMapping()
    public void guardarDetallePedidoModel(@RequestBody DetallePedidoModel detallePedido) {

        LocalDateTime locaDate = LocalDateTime.now();
        long hora = locaDate.getHour();
        long valorProduct = detallePedido.getProducto().getPrecioProducto();
        long cant = (detallePedido.getDetallePedidoCantidad());
        long valorTotal = valorProduct * cant;
        long horaMax=detallePedido.getPedidoHora()+5;
        
        if 
        ((valorTotal>=detallePedido.getSubtotal())
        && 
        (((hora<=horaMax&&hora>=detallePedido.getPedidoHora())
        ||((detallePedido.getPedidoHora()+5)-24<=4) && (((detallePedido.getPedidoHora()+5)-24)>=0)))
        ) 
        {
            System.out.println("Entro a la facturacion");
            long valorDomicilio = detallePedido.getDomicilioValor().getValorDomicilio();
            long valorPedido = (valorTotal + valorDomicilio);
            long ivaPedido = 0;

            if (valorTotal >= 100000) {

                valorPedido = (valorPedido - valorDomicilio);

            }

            if (valorTotal >= 70000) {

                ivaPedido = (valorTotal * 19 / 100);

            }

            detallePedido.setDetallePedidoValor(valorPedido);
            detallePedido.setIvaPedido(ivaPedido);
            detallePedidoService.guardarDetallePedido(detallePedido);
            detallePedido.setSubtotal(valorTotal);
        } 

    }

    @DeleteMapping(path = "/{idDetallePedido}")
    public String eliminarPorId(@PathVariable("idDetallePedido") Long idDetallePedido) {
        boolean ok = this.detallePedidoService.eliminarDetallePedido(idDetallePedido);
        if (ok) {
            return "Se eliminó el pedido con id " + idDetallePedido;
        } else {
            return "No pudo eliminar el pedido con id" + idDetallePedido;
        }
    }

}
