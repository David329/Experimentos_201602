/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.service;

import com.sisalmint.dao.ProductsDAO;
import com.sisalmint.entity.Products;

/**
 *
 * @author David
 */
public class ServiceProducts {

    public void addProduct(Products objProduct) {
        ProductsDAO objProductDAO = new ProductsDAO();
        objProductDAO.addProduct(objProduct);
    }

    public void editProduct(Products objProduct) {
        ProductsDAO objProductDAO = new ProductsDAO();
        objProductDAO.editProduct(objProduct);
    }

    public void deleteProduct(Products objProduct) {
        ProductsDAO objProductDAO = new ProductsDAO();
        objProductDAO.deleteProduct(objProduct);
    }

    public Products getProductById(String ProductID) {
        ProductsDAO objProductDAO = new ProductsDAO();
        return objProductDAO.getProductById(ProductID);
    }
}
