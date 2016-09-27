/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servicios;

import com.sisalmint.dao.ProductoDAO;
import com.sisalmint.entidades.Producto;
import java.util.List;

/**
 *
 * @author David
 */
public class ServicioProducto {

    public void addProduct(Producto objProduct) {
        ProductoDAO objProductDAO = new ProductoDAO();
        objProductDAO.addProduct(objProduct);
    }

    public void editProduct(Producto objProduct) {
        ProductoDAO objProductDAO = new ProductoDAO();
        objProductDAO.editProduct(objProduct);
    }

    public void deleteProduct(Producto objProduct) {
        ProductoDAO objProductDAO = new ProductoDAO();
        objProductDAO.deleteProduct(objProduct);
    }

    public Producto getProductById(String ProductID) {
        ProductoDAO objProductDAO = new ProductoDAO();
        return objProductDAO.getProductById(ProductID);
    }
    
    public Producto getProductByName(String ProductName) {
        ProductoDAO objProductDAO = new ProductoDAO();
        return objProductDAO.getProductByName(ProductName);
    }
    
    public List<Producto> getProducts(){
        ProductoDAO objProductDAO = new ProductoDAO();
        return objProductDAO.getProducts();
    }
}
