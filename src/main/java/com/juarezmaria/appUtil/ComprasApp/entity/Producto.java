package com.juarezmaria.appUtil.ComprasApp.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Uso el @NotBlank en lugar de @NotEmpty ya que NotEmpty
     * puede soportar un caracter en blanco,
     * mientras que NotBlank valida que no este vacio ni en blanco.
     **/

    @NotBlank
    @Column(name = "Nombre")
    private String nombre;

    @NotNull
    @Column(name = "Precio")
    private Double precio;

    @NotNull
    @Column(name = "Cantidad")
    private Double cantidad;

    @NotBlank
    @Column(name = "Fecha")
    private String fecha;

    @NotBlank
    @Column(name = "Lugar")
    private String lugar;

    public Producto() {
    }

    public Producto(Integer id,String nombre, Double precio, Double cantidad, String fecha, String lugar) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecioProducto(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
