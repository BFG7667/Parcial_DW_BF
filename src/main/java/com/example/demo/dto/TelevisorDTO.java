package com.example.demo.dto;

import java.time.LocalDate;

public class TelevisorDTO {

    private Long id;
    private String marca = "";
    private double tamanoPantalla = -1D;
    private String resolucion = "";
    private String descripcion = "";
    private String funcionesAdicionales = "";
    private double precio = -1D;
    private String descripcionGarantia = "";
    private LocalDate fechaCreacion = null;

    public TelevisorDTO() {
    }

    public TelevisorDTO(Long id, String marca, double tamanoPantalla, String resolucion, String descripcion, String funcionesAdicionales, double precio, String descripcionGarantia, LocalDate fechaCreacion) {
        this.id = id;
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

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
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
