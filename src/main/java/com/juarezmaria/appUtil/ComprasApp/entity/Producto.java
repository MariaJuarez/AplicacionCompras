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
    private String nombreProducto;

    @NotNull
    @Column(name = "Precio")
    private Double precioProducto;

    @NotNull
    @Column(name = "Cantidad")
    private Double cantidadCompraProducto;

    @NotBlank
    @Column(name = "Mes")
    private String mesCompraProducto;

    @NotBlank
    @Column(name = "FechaCompra")
    private String fechaCompletaCompraProducto;

    @NotBlank
    @Column(name = "FechaAgote")
    private String fechaCompletaAgoteProducto;

    @NotBlank
    @Column(name = "LugarCompra")
    private String lugarCompraProduto;

    public Producto() {
    }

    public Producto(Integer id, String nombreProducto, Double precioProducto, Double cantidadCompraProducto, String mesCompraProducto, String fechaCompletaCompraProducto, String fechaCompletaAgoteProducto, String lugarCompraProduto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadCompraProducto = cantidadCompraProducto;
        this.mesCompraProducto = mesCompraProducto;
        this.fechaCompletaCompraProducto = fechaCompletaCompraProducto;
        this.fechaCompletaAgoteProducto = fechaCompletaAgoteProducto;
        this.lugarCompraProduto = lugarCompraProduto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Double getCantidadCompraProducto() {
        return cantidadCompraProducto;
    }

    public void setCantidadCompraProducto(Double cantidadCompraProducto) {
        this.cantidadCompraProducto = cantidadCompraProducto;
    }

    public String getMesCompraProducto() {
        return mesCompraProducto;
    }

    public void setMesCompraProducto(String mesCompraProducto) {
        this.mesCompraProducto = mesCompraProducto;
    }

    public String getFechaCompletaCompraProducto() {
        return fechaCompletaCompraProducto;
    }

    public void setFechaCompletaCompraProducto(String fechaCompletaCompraProducto) {
        this.fechaCompletaCompraProducto = fechaCompletaCompraProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCompletaAgoteProducto() {
        return fechaCompletaAgoteProducto;
    }

    public void setFechaCompletaAgoteProducto(String fechaCompletaAgoteProducto) {
        this.fechaCompletaAgoteProducto = fechaCompletaAgoteProducto;
    }

    public String getLugarCompraProduto() {
        return lugarCompraProduto;
    }

    public void setLugarCompraProduto(String lugarCompraProduto) {
        this.lugarCompraProduto = lugarCompraProduto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", cantidadCompraProducto=" + cantidadCompraProducto +
                ", mesCompraProducto='" + mesCompraProducto + '\'' +
                ", fechaCompletaCompraProducto='" + fechaCompletaCompraProducto + '\'' +
                ", fechaCompletaAgoteProducto='" + fechaCompletaAgoteProducto + '\'' +
                ", lugarCompraProduto='" + lugarCompraProduto + '\'' +
                '}';
    }
}
