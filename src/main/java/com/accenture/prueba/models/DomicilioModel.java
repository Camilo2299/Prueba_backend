package com.accenture.prueba.models;


import javax.persistence.*;


@Entity
@Table(name="domicilio")
public class DomicilioModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="domicilio_id",nullable = false,unique = true)
    private Long idDomicilio;

    @Column(name="domicilio_barrio",nullable = false,unique = true)
    private String barrioDomicilio;

    @Column(name="domicilio_valor",nullable = false,unique=false)
    private Long valorDomicilio;

    public Long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getBarrioDomicilio() {
        return barrioDomicilio;
    }

    public void setBarrioDomicilio(String barrioDomicilio) {
        this.barrioDomicilio = barrioDomicilio;
    }

    public Long getValorDomicilio() {
        return valorDomicilio;
    }

    public void setValorDomicilio(Long valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }

    public DomicilioModel() {
    }

    public DomicilioModel(Long idDomicilio, String barrioDomicilio, Long valorDomicilio) {
        this.idDomicilio = idDomicilio;
        this.barrioDomicilio = barrioDomicilio;
        this.valorDomicilio = valorDomicilio;
    }

    
    

    
    

        
    
}
