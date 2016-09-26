/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.service;

import com.sisalmint.dao.AdminDAO;
import com.sisalmint.entity.Admin;

/**
 *
 * @author David
 */
public class ServiceAdmin {

    public boolean validarLoginAdministrador(Admin objAdmin) {
        AdminDAO administradorDAO = new AdminDAO();
        return administradorDAO.validarLoginAdmin(objAdmin);
    }
}
