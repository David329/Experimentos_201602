/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.entidades;
import java.sql.Date;
import java.math.BigDecimal;

/**
 *
 * @author David
 */
public class Producto {
    private String Codigo;
    private String Nombre;
    private String Marca;
    private String Modelo;
    private Date FechaIngreso;
    private String Distribuidor;
    private BigDecimal PrecioCompra;
    private int CantidadIngresada;
    private String FallaFabrica;
    private String Estado;
    private int TipoID;

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getDistribuidor() {
        return Distribuidor;
    }

    public void setDistribuidor(String Distribuidor) {
        this.Distribuidor = Distribuidor;
    }

    public BigDecimal getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(BigDecimal PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public int getCantidadIngresada() {
        return CantidadIngresada;
    }

    public void setCantidadIngresada(int CantidadIngresada) {
        this.CantidadIngresada = CantidadIngresada;
    }

    public String getFallaFabrica() {
        return FallaFabrica;
    }

    public void setFallaFabrica(String FallaFabrica) {
        this.FallaFabrica = FallaFabrica;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getTipoID() {
        return TipoID;
    }

    public void setTipoID(int TipoID) {
        this.TipoID = TipoID;
    }
    
}
