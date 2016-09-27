/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.entidades;

/**
 *
 * @author David
 */
public class Tipo {
    private int TipoId;
    private String Nombre;
    private String Estado;

    public int getTipoId() {
        return TipoId;
    }

    public void setTipoId(int TipoId) {
        this.TipoId = TipoId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
