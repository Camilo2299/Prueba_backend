package com.accenture.prueba.models;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detallle_pedido")
public class DetallePedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_pedido_id")
    private Long idDetallePedido;

    @ManyToOne
    // (optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name = "detalle_pedido_producto_id", referencedColumnName = "producto_id", updatable = false, insertable = false, nullable = true)
    // @JsonIgnore
    private ProductoModel producto;

    @ManyToOne
    // (optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name = "pedido_usuario_id", referencedColumnName =
    // "usuario_id",updatable = false, insertable = false, nullable = true)
    // @JsonIgnore
    private UsuarioModel usuario;

    @ManyToOne
    // (optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name = "pedido_domicilio_id", referencedColumnName =
    // "domicilio_id", updatable = false, insertable = false, nullable = false)
    // @JsonIgnore
    private DomicilioModel domicilioValor;


    @Column(name = "detalle_pedido_cantidad")
    private Long detallePedidoCantidad;

    @Column(name = "detalle_pedido_valor")
    private Long detallePedidoValor;

    @Column(name = "pedido_hora")
    private Long pedidoHora;

    @Column(name = "pedido_iva")
    private Long ivaPedido;

    @Column(name="subtotal")
    private Long subtotal;


    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }


    public Long getDetallePedidoCantidad() {
        return detallePedidoCantidad;
    }

    public void setDetallePedidoCantidad(Long detallePedidoCantidad) {
        this.detallePedidoCantidad = detallePedidoCantidad;
    }

    public Long getDetallePedidoValor() {
        return detallePedidoValor;
    }

    public void setDetallePedidoValor(Long detallePedidoValor) {
        this.detallePedidoValor = detallePedidoValor;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public DomicilioModel getDomicilioValor() {
        return domicilioValor;
    }

    public void setDomicilioValor(DomicilioModel domicilioValor) {
        this.domicilioValor = domicilioValor;
    }

    public Long getPedidoHora() {
        return pedidoHora;
    }

    public void setPedidoHora(Long pedidoHora) {
        this.pedidoHora = pedidoHora;
    }

    public Long getIvaPedido() {
        return ivaPedido;
    }

    public void setIvaPedido(Long ivaPedido) {
        this.ivaPedido = ivaPedido;
    }


    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }

    public DetallePedidoModel() {}

    public DetallePedidoModel(Long idDetallePedido, ProductoModel producto, UsuarioModel usuario,
            DomicilioModel domicilioValor, Long detallePedidoCantidad, Long detallePedidoValor, Long pedidoHora,
            Long ivaPedido, Long subtotal) {
        this.idDetallePedido = idDetallePedido;
        this.producto = producto;
        this.usuario = usuario;
        this.domicilioValor = domicilioValor;
        this.detallePedidoCantidad = detallePedidoCantidad;
        this.detallePedidoValor = detallePedidoValor;
        this.pedidoHora = pedidoHora;
        this.ivaPedido = ivaPedido;
        this.subtotal = subtotal;
    }

        

    



    
}
