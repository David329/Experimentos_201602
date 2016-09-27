/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servicios;

import com.sisalmint.entidades.Producto;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
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
public class ServicioProductoTest {

    private static final ServicioProducto SERVICIO_PRODUCTO = new ServicioProducto();
    private static Producto producto;

    public ServicioProductoTest() {
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
     * Test of insertar method, of class Producto.
     */
    @org.junit.Test
    public void a_testInsertar() throws Exception {
        System.out.println("insertar");
        try {
            producto = new Producto();
            producto.setCodigo("PC77");
            producto.setTipoID(1);
            producto.setNombre("Lacteos");
            producto.setCantidadIngresada(3);
            producto.setDistribuidor("distri");
            producto.setFallaFabrica("0");
            producto.setFechaIngreso(Date.valueOf("2016-08-20"));
            producto.setMarca("Marcaaa");
            producto.setModelo("modd");
            producto.setPrecioCompra(new BigDecimal("23"));
            SERVICIO_PRODUCTO.addProduct(producto);
            assertTrue(!"0".equals(producto.getCodigo()));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocurrion un error: "+ e.getMessage());
        }
    }
    
    /**
     * Test of actualizar method, of class Producto.
     */
    @org.junit.Test
    public void b_testActualizar() throws Exception {
        System.out.println("actualizar");
        try {
            producto.setNombre("Menestras");
            SERVICIO_PRODUCTO.editProduct(producto);
            assertTrue(producto.getNombre().equals("Menestras"));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocurrion un error: "+ e.getMessage());
        }
    }
    
    /**
     * Test of eliminar method, of class Producto.
     */
    @org.junit.Test
    public void e_testEliminar() throws Exception {
        System.out.println("eliminar");
        try {
            SERVICIO_PRODUCTO.deleteProduct(producto);
            assertTrue(true);
        } catch (Exception e){
            e.printStackTrace();
         fail("Ocurrio un error: "+ e.getMessage());
        }
    }
    
    /**
     * Test of obtener method, of class Producto.
     */
    @org.junit.Test
    public void c_testObtener() throws Exception {
        System.out.println("obtener");
        try {
            Producto productoBuscado=SERVICIO_PRODUCTO.getProductById(producto.getCodigo());
            assertNotNull(productoBuscado);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocurrion un error: "+ e.getMessage());
        }
    }
    
    /**
     * Test of listar method, of class Producto.
     */
    @org.junit.Test
    public void d_testListar() throws Exception {
        System.out.println("listar");
        try {
            List<Producto> lista = SERVICIO_PRODUCTO.getProducts();
            assertTrue(lista.size()>0);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Ocurrio un error: "+ e.getMessage());
        }
    }
}
