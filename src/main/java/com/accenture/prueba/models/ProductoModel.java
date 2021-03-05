package com.accenture.prueba.models;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id", nullable = false, unique = true)
    private Long idProducto;

    @Column(name = "producto_nombre", nullable = false, unique = false)
    private String nombreProducto;

    @Column(name = "producto_precio", nullable = false, unique = false)
    private Long precioProducto;

    @Column(name = "producto_descripcion", nullable = true, unique = false)
    private String descripcionProducto;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Long precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public ProductoModel() {
    }

    public ProductoModel(Long idProducto, String nombreProducto, Long precioProducto, String descripcionProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
    }
    
}
