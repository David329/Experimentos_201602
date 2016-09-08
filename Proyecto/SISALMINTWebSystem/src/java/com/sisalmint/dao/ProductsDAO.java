/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.dao;

import com.sisalmint.bd.AccesoDB;
import com.sisalmint.entity.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ProductsDAO {

    public void addProduct(Products objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Products WHERE ProductID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new SQLException("El codigo del producto ya existe");
            }

            query = new StringBuilder();
            query.append("INSERT INTO Products(ProductID,ProductName,Brand,Model,RegDate,Supplier,UnitPrice,UnitsInStock,CategoryID) VALUES(?,?,?,?,?,?,?,?,?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductID());
            ps.setString(2, objProduct.getProductName());
            ps.setString(3, objProduct.getBrand());
            ps.setString(4, objProduct.getModel());
            ps.setDate(5, objProduct.getRegDate());
            ps.setString(6, objProduct.getSupplier());
            ps.setBigDecimal(7, objProduct.getUnitPrice());
            ps.setInt(8, objProduct.getUnitsInStock());
            ps.setInt(9, objProduct.getCategoryID());
            ps.executeUpdate();
            cn.commit();

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public void editProduct(Products objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Products SET ProductName = ?,Brand=?,Model=?,RegDate = ?,Supplier=?,UnitPrice = ?,UnitsInStock=?,CategoryID=? WHERE ProductID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductName());
            ps.setString(2, objProduct.getBrand());
            ps.setString(3, objProduct.getModel());
            ps.setDate(4, objProduct.getRegDate());
            ps.setString(5, objProduct.getSupplier());
            ps.setBigDecimal(6, objProduct.getUnitPrice());
            ps.setInt(7, objProduct.getUnitsInStock());
            ps.setInt(8, objProduct.getCategoryID());
            ps.setString(9, objProduct.getProductID());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("producto no existe!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public void deleteProduct(Products objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM Products WHERE ProductID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductID());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("producto no existe!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public Products getProductById(String _idProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT ProductID,ProductName,Brand,Model,RegDate,Supplier,UnitPrice,UnitsInStock,CategoryID FROM Products WHERE ProductID= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProduct);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Products objProduct = new Products();
            objProduct.setProductID(rs.getString("ProductID"));
            objProduct.setProductName(rs.getString("ProductName"));
            objProduct.setBrand(rs.getString("Brand"));
            objProduct.setModel(rs.getString("Model"));
            objProduct.setRegDate(rs.getDate("RegDate"));
            objProduct.setSupplier(rs.getString("Supplier"));
            objProduct.setUnitPrice(rs.getBigDecimal("UnitPrice"));
            objProduct.setUnitsInStock(rs.getInt("UnitsInStock"));
            objProduct.setCategoryID(rs.getInt("CategoryID"));
            return objProduct;
        } catch (SQLException ex) {
            return null;
            //   throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public List<Products> getProducts() {
        Connection cn = null;
        try {
            List<Products> lstproducts = new ArrayList<>();
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Products");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Products a = new Products();
                a.setProductID(rs.getString("ProductID"));
                a.setProductName(rs.getString("ProductName"));
                a.setBrand(rs.getString("Brand"));
                a.setModel(rs.getString("Model"));
                a.setRegDate(rs.getDate("RegDate"));
                a.setSupplier(rs.getString("Supplier"));
                a.setUnitPrice(rs.getBigDecimal("UnitPrice"));
                a.setUnitsInStock(rs.getInt("UnitsInStock"));
                a.setCategoryID(rs.getInt("CategoryID"));

                lstproducts.add(a);
            }
            return lstproducts;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("No se tiene acceso al servidor");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
            }
        }
    }
}
