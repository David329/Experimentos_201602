/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servicios;

import com.sisalmint.dao.AdminDAO;
import com.sisalmint.entidades.Admin;

/**
 *
 * @author David
 */
public class ServicioAdmin {

    public boolean validarLoginAdministrador(Admin objAdmin) {
        AdminDAO administradorDAO = new AdminDAO();
        return administradorDAO.validarLoginAdmin(objAdmin);
    }
}
