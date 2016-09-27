/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servicios;

import com.sisalmint.dao.TipoDAO;
import com.sisalmint.entidades.Tipo;
import java.util.List;

/**
 *
 * @author David
 */
public class ServicioTipo {

    public void addTipo(Tipo objTipo) {
        TipoDAO objTipoDAO = new TipoDAO();
        objTipoDAO.addTipo(objTipo);
    }

    public void editTipo(Tipo objTipo) {
        TipoDAO objTipoDAO = new TipoDAO();
        objTipoDAO.editTipo(objTipo);
    }

    public void deleteTipo(Tipo objTipo) {
        TipoDAO objTipoDAO = new TipoDAO();
        objTipoDAO.deleteTipo(objTipo);
    }

    public Tipo getTipoById(String TipoID) {
        TipoDAO objTipoDAO = new TipoDAO();
        return objTipoDAO.getTipoById(TipoID);
    }

    public List<Tipo> getTipos() {
        TipoDAO objTipoDAO = new TipoDAO();
        return objTipoDAO.getTipos();
    }
}
