/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.dao;

import com.sisalmint.bd.AccesoDB;
import com.sisalmint.entidades.Producto;
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
public class ProductoDAO {

    public void addProduct(Producto objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Producto WHERE Codigo = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getCodigo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return;
            }

            query = new StringBuilder();
            query.append("INSERT INTO Producto(Codigo,Nombre,Marca,Modelo,FechaIngreso,Distribuidor,PrecioCompra,CantidadIngresada,FallaFabrica,Estado,TipoId) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getCodigo());
            ps.setString(2, objProduct.getNombre());
            ps.setString(3, objProduct.getMarca());
            ps.setString(4, objProduct.getModelo());
            ps.setDate(5, objProduct.getFechaIngreso());
            ps.setString(6, objProduct.getDistribuidor());
            ps.setBigDecimal(7, objProduct.getPrecioCompra());
            ps.setInt(8, objProduct.getCantidadIngresada());
            ps.setString(9, objProduct.getFallaFabrica());
            ps.setString(10, "ACT");
            ps.setInt(11, objProduct.getTipoID());
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

    public void editProduct(Producto objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Producto SET Nombre = ?,Marca=?,Modelo = ?,FechaIngreso = ?,Distribuidor=?,PrecioCompra=?,CantidadIngresada=?,FallaFabrica=?,Estado=?,TipoId=? WHERE Codigo = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objProduct.getNombre());
            ps.setString(2, objProduct.getMarca());
            ps.setString(3, objProduct.getModelo());
            ps.setDate(4, objProduct.getFechaIngreso());
            ps.setString(5, objProduct.getDistribuidor());
            ps.setBigDecimal(6, objProduct.getPrecioCompra());
            ps.setInt(7, objProduct.getCantidadIngresada());
            ps.setString(8, objProduct.getFallaFabrica());
            ps.setString(9, "ACT");
            ps.setInt(10, objProduct.getTipoID());
            ps.setString(11, objProduct.getCodigo());

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

    public void deleteProduct(Producto objProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Producto SET Estado= ? WHERE Codigo = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, "INA");
            ps.setString(2, objProduct.getCodigo());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("Producto no existe!");
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

    public Producto getProductById(String _idProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT Codigo,Nombre,Marca,Modelo,FechaIngreso,Distribuidor,PrecioCompra,CantidadIngresada,FallaFabrica,Estado,TipoId FROM Producto WHERE Codigo= ? and Estado=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idProduct);
            ps.setString(2, "ACT");
            ResultSet rs = ps.executeQuery();

            rs.next();
            Producto objProduct = new Producto();
            objProduct.setCodigo(rs.getString("Codigo"));
            objProduct.setNombre(rs.getString("Nombre"));
            objProduct.setMarca(rs.getString("Marca"));
            objProduct.setModelo(rs.getString("Modelo"));
            objProduct.setFechaIngreso(rs.getDate("FechaIngreso"));
            objProduct.setDistribuidor(rs.getString("Distribuidor"));
            objProduct.setPrecioCompra(rs.getBigDecimal("PrecioCompra"));
            objProduct.setCantidadIngresada(rs.getInt("CantidadIngresada"));
            objProduct.setFallaFabrica(rs.getString("FallaFabrica"));
            objProduct.setEstado(rs.getString("Estado"));
            objProduct.setTipoID(rs.getInt("TipoId"));
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

    public Producto getProductByName(String _NameProduct) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT Codigo,Nombre,Marca,Modelo,FechaIngreso,Distribuidor,PrecioCompra,CantidadIngresada,FallaFabrica,Estado,TipoId FROM Producto WHERE Nombre= ? and Estado=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _NameProduct);
            ps.setString(2, "ACT");
            ResultSet rs = ps.executeQuery();

            rs.next();
            Producto objProduct = new Producto();
            objProduct.setCodigo(rs.getString("Codigo"));
            objProduct.setNombre(rs.getString("Nombre"));
            objProduct.setMarca(rs.getString("Marca"));
            objProduct.setModelo(rs.getString("Modelo"));
            objProduct.setFechaIngreso(rs.getDate("FechaIngreso"));
            objProduct.setDistribuidor(rs.getString("Distribuidor"));
            objProduct.setPrecioCompra(rs.getBigDecimal("PrecioCompra"));
            objProduct.setCantidadIngresada(rs.getInt("CantidadIngresada"));
            objProduct.setFallaFabrica(rs.getString("FallaFabrica"));
            objProduct.setEstado(rs.getString("Estado"));
            objProduct.setTipoID(rs.getInt("TipoId"));
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

    public List<Producto> getProducts() {
        Connection cn = null;
        try {
            List<Producto> lstproducts = new ArrayList<>();
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Producto WHERE Estado=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, "ACT");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto a = new Producto();
                a.setCodigo(rs.getString("Codigo"));
                a.setNombre(rs.getString("Nombre"));
                a.setMarca(rs.getString("Marca"));
                a.setModelo(rs.getString("Modelo"));
                a.setFechaIngreso(rs.getDate("FechaIngreso"));
                a.setDistribuidor(rs.getString("Distribuidor"));
                a.setPrecioCompra(rs.getBigDecimal("PrecioCompra"));
                a.setCantidadIngresada(rs.getInt("CantidadIngresada"));
                a.setFallaFabrica(rs.getString("FallaFabrica"));
                a.setEstado(rs.getString("Estado"));
                a.setTipoID(rs.getInt("TipoId"));

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
