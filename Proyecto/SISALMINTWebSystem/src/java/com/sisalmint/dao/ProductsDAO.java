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
            query.append("INSERT INTO Products(ProductID,ProductName,UnitPrice,UnitsInStock,Status,RegDate,CategoryID) VALUES(?,?,?,?,?,?,?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductID());
            ps.setString(2, objProduct.getProductName());
            ps.setBigDecimal(3, objProduct.getUnitPrice());
            ps.setInt(4, objProduct.getUnitsInStock());
            ps.setString(5, objProduct.getStatus());
            ps.setDate(6, objProduct.getRegDate());
            ps.setInt(7, objProduct.getCategoryID());
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
            query.append("UPDATE Products SET ProductName = ?,UnitPrice = ?,UnitsInStock=?,Status = ?,RegDate = ?,CategoryID=? WHERE ProductID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getProductName());
            ps.setBigDecimal(2, objProduct.getUnitPrice());
            ps.setInt(3, objProduct.getUnitsInStock());
            ps.setString(4, objProduct.getStatus());
            ps.setDate(5, objProduct.getRegDate());
            ps.setInt(6, objProduct.getCategoryID());
            ps.setString(7, objProduct.getProductID());
            int realizado = ps.executeUpdate();
            cn.commit();
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
//        Connection cn = null;
//        try {
//            cn = AccesoDB.getConnection();
//            StringBuilder query = new StringBuilder();
//            query.append("UPDATE Categories SET Status = ? WHERE CategoryID = ?");
//            PreparedStatement ps = cn.prepareStatement(query.toString());
//            ps.setString(1, objCategory.getCategoryName());
//            ps.setString(2, objCategory.getStatus());
//            ps.setInt(3, objCategory.getCategoryID());
//            int realizado = ps.executeUpdate();
//            cn.commit();
//            if (realizado == 0) {
//                throw new SQLException("Categoria no existe!");
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex.getMessage());
//        } catch (Exception e) {
//            throw new RuntimeException("No se tiene acceso al servidor");
//        } finally {
//            try {
//                if (cn != null) {
//                    cn.close();
//                }
//            } catch (Exception ex) {
//            }
//        }
    }

    public Products getProductById(String _idProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT ProductID,ProductName,UnitPrice,UnitsInStock,Status,RegDate,CategoryID FROM Products WHERE ProductID= ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProduct);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            Products objProduct = new Products();
            objProduct.setProductID(rs.getString("ProductID"));
            objProduct.setProductName(rs.getString("ProductName"));
            objProduct.setUnitPrice(rs.getBigDecimal("UnitPrice"));
            objProduct.setUnitsInStock(rs.getInt("UnitsInStock"));
            objProduct.setStatus(rs.getString("Status"));
            objProduct.setRegDate(rs.getDate("RegDate"));
            objProduct.setCategoryID(rs.getInt("CategoryID"));
            return objProduct;
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
                a.setUnitPrice(rs.getBigDecimal("UnitPrice"));
                a.setUnitsInStock(rs.getInt("UnitsInStock"));
                a.setStatus(rs.getString("Status"));
                a.setRegDate(rs.getDate("RegDate"));
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
