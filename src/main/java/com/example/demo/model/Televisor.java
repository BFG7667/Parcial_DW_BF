package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "televisores")
public class Televisor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;
    private double tamanoPantalla;
    private Resolucion resolucion;
    private String descripcion;
    private String funcionesAdicionales;
    private double precio;
    private String descripcionGarantia;
    private LocalDate fechaCreacion;
    

    // CONSTRUCTORES

    public Televisor() {
    }

    public Televisor(String marca, double tamanoPantalla, Resolucion resolucion, String descripcion, String funcionesAdicionales, double precio, String descripcionGarantia, LocalDate fechaCreacion) {
        this.marca = marca;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
        this.descripcion = descripcion;
        this.funcionesAdicionales = funcionesAdicionales;
        this.precio = precio;
        this.descripcionGarantia = descripcionGarantia;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncionesAdicionales() {
        return funcionesAdicionales;
    }

    public void setFuncionesAdicionales(String funcionesAdicionales) {
        this.funcionesAdicionales = funcionesAdicionales;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcionGarantia() {
        return descripcionGarantia;
    }

    public void setDescripcionGarantia(String descripcionGarantia) {
        this.descripcionGarantia = descripcionGarantia;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
