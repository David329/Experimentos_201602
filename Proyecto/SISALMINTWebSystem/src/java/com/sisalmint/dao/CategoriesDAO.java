/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.dao;

import com.sisalmint.bd.AccesoDB;
import com.sisalmint.entity.Categories;
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
public class CategoriesDAO {

    public void addCategory(Categories objCategory) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Categories WHERE CategoryID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setInt(1, objCategory.getCategoryID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new SQLException("El codigo de la categoria ya existe");
            }

            query = new StringBuilder();
            query.append("INSERT INTO Categories(CategoryName) VALUES(?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCategory.getCategoryName());
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

    public void editCategory(Categories objCategory) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objCategory.getCategoryName());
            ps.setInt(2, objCategory.getCategoryID());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("Categoria no existe!");
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

    public void deleteCategory(Categories objCategory) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM Categories WHERE CategoryID = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setInt(1, objCategory.getCategoryID());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("Categoria no existe!");
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

    public Categories getCategoryById(String _idCategory) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT CategoryID,CategoryName,Status FROM Categories WHERE CategoryID=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idCategory);
            ResultSet rs = ps.executeQuery();

            Categories objCategory = new Categories();
            objCategory.setCategoryID(rs.getInt("CategoryID"));
            objCategory.setCategoryName(rs.getString("CategoryName"));
            return objCategory;
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

    public List<Categories> getCategories() {
        Connection cn = null;
        try {
            List<Categories> lstcategories = new ArrayList<>();
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Categories");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories a = new Categories();
                a.setCategoryID(rs.getInt("CategoryID"));
                a.setCategoryName(rs.getString("CategoryName"));

                lstcategories.add(a);
            }
            return lstcategories;
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
