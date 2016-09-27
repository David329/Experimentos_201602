/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servicios;

import com.sisalmint.entidades.Admin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author DavidZilva
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicioAdminTest {

    private static final ServicioAdmin SERVICIO_ADMIN = new ServicioAdmin();
    private static Admin admin;

    public ServicioAdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Se ejecuta al inicio de la clase");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Se ejecuta despues de la clase");
    }

    @Before
    public void setUp() {
        System.out.println("Se ejecuta antes del metodo");
    }

    @After
    public void tearDown() {
        System.out.println("Se ejecuta al despues del metodo");
    }

    /**
     * Test of insertar method, of class ServicioAdmin.
     */
    @org.junit.Test
    public void a_testLogeo() throws Exception {
        System.out.println("insertar");
        try {
            admin = new Admin();
            admin.setUsuario("a");
            admin.setPassw("a");
            boolean logeo = SERVICIO_ADMIN.validarLoginAdministrador(admin);
            assertTrue(logeo);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocurrion un error: " + e.getMessage());
        }
    }

}
