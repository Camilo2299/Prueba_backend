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
        long valorSubtotal = detallePedido.getSubtotal();
        detallePedido.setSubtotal(valorSubtotal + valorTotal);
        long horaMax = detallePedido.getPedidoHora() + 5;

        if ((valorTotal >= (detallePedido.getSubtotal() - valorTotal))
                && (((hora <= horaMax && hora >= detallePedido.getPedidoHora())
                        || ((detallePedido.getPedidoHora() + 5) - 24 <= 4)
                                && (((detallePedido.getPedidoHora() + 5) - 24) >= 0)))) {
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
        }

    }

    @DeleteMapping(path = "/{idDetallePedido}")
    public String eliminarPorId(@PathVariable("idDetallePedido") Long idDetallePedido,
            @RequestBody DetallePedidoModel detallePedido1) {

        LocalDateTime locaDate = LocalDateTime.now();
        long hora = locaDate.getHour();
        long horaMax = ((detallePedido1.getPedidoHora() + 12) - 24);
        long recargo = ((detallePedido1.getDetallePedidoValor() * 10) / 100);

        if (((hora <= horaMax && hora >= detallePedido1.getPedidoHora())))
                // || ((detallePedido1.getPedidoHora() + 12) - 24 <= 11)
                //         && (((detallePedido1.getPedidoHora() + 12) - 24) >= -12))) 
        {
            boolean ok = this.detallePedidoService.eliminarDetallePedido(idDetallePedido);
            if (ok) {
                return "Se eliminó el pedido sin recargo con id " + idDetallePedido;
            } else {
                return "No pudo eliminar el pedido con id" + idDetallePedido;
            }
        }
        boolean ok = this.detallePedidoService.eliminarDetallePedido(idDetallePedido);
        if (ok) {
            return "Se eliminó el pedido con recargo del 10% con id " + idDetallePedido + " Valor a pagar: " + recargo;
        } else {
            return "No pudo eliminar el pedido con id" + idDetallePedido;
        }
    }

}
