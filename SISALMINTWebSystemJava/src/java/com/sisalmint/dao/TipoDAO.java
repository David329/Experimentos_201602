/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.dao;

import com.sisalmint.bd.AccesoDB;
import com.sisalmint.entidades.Tipo;
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
public class TipoDAO {

    public void addTipo(Tipo objTipo) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Tipo WHERE TipoId = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setInt(1, objTipo.getTipoId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new SQLException("El codigo del tipo ya existe");
            }

            query = new StringBuilder();
            query.append("INSERT INTO Tipo(Nombre,Estado) VALUES(?, ?)");
            ps = cn.prepareStatement(query.toString());
            ps.setString(1, objTipo.getNombre());
            ps.setString(2, objTipo.getEstado());
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

    public void editTipo(Tipo objTipo) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Tipo SET Nombre = ?,Estado = ? WHERE TipoId = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, objTipo.getNombre());
            ps.setString(2, objTipo.getEstado());
            ps.setInt(3, objTipo.getTipoId());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("Tipo no existe!");
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

    public void deleteTipo(Tipo objTipo) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("UPDATE Tipo SET Estado = ? WHERE TipoId = ?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, "INA");
            ps.setInt(2, objTipo.getTipoId());
            int realizado = ps.executeUpdate();
            if (realizado == 0) {
                throw new SQLException("Tipo no existe!");
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

    public Tipo getTipoById(String _idTipo) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT TipoId,Nombre,Estado FROM Tipo WHERE TipoId=? and Estado=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, _idTipo);
            ps.setString(2, "ACT");
            ResultSet rs = ps.executeQuery();

            Tipo objTipo = new Tipo();
            objTipo.setTipoId(rs.getInt("TipoId"));
            objTipo.setNombre(rs.getString("Nombre"));
            objTipo.setEstado(rs.getString("Estado"));
            return objTipo;
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

    public List<Tipo> getTipos() {
        Connection cn = null;
        try {
            List<Tipo> lsttipos = new ArrayList<>();
            cn = AccesoDB.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM Tipo WHERE Estado=?");
            PreparedStatement ps = cn.prepareStatement(query.toString());
            ps.setString(1, "ACT");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tipo a = new Tipo();
                a.setTipoId(rs.getInt("TipoId"));
                a.setNombre(rs.getString("Nombre"));
                a.setEstado(rs.getString("Estado"));

                lsttipos.add(a);
            }
            return lsttipos;
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
