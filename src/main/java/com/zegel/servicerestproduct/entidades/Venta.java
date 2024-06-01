package com.zegel.servicerestproduct.entidades;

import jakarta.persistence.*;

@Entity
@Table(name= "TP_VENTAS")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroVenta;
    private String cliente;
    private String fechaVenta;
    private String producto;
    private String usuario;

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(Long nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
