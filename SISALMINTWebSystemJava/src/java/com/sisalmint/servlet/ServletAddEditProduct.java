/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servlet;

import com.sisalmint.entidades.Producto;
import com.sisalmint.servicios.ServicioProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "ServletAddEditProduct", urlPatterns = {"/ServletAddEditProduct"})
public class ServletAddEditProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServicioProducto sp = new ServicioProducto();
        String editar = request.getParameter("editar");
        String mimensaje = "";

        Producto obj = sp.getProductById(request.getParameter("codigo"));

        Producto product = new Producto();
        product.setCodigo(request.getParameter("codigo"));
        product.setNombre(request.getParameter("nombre"));
        product.setMarca(request.getParameter("marca"));
        product.setModelo(request.getParameter("modelo"));
        product.setFechaIngreso(Date.valueOf(request.getParameter("fechaingreso")));
        product.setDistribuidor(request.getParameter("distribuidor"));
        product.setPrecioCompra(new BigDecimal(request.getParameter("precio")));
        product.setCantidadIngresada(Integer.parseInt(request.getParameter("cantidad")));
        product.setFallaFabrica(request.getParameter("falla"));
        product.setTipoID(Integer.parseInt(request.getParameter("tipo")));

        if ("1".equals(editar)) {
            sp.editProduct(product);
            mimensaje = "Éxito! El producto se actualizó correctamente.";
            request.setAttribute("mimensaje", mimensaje);
            request.getRequestDispatcher("Producto/AddEditProducto.jsp").forward(request, response);
        } else {
            sp.addProduct(product);
            mimensaje = "Éxito! El producto se agregó correctamente.";
        }

        if (obj != null) {
            mimensaje = "Error! El código de producto ya existe.";
            request.setAttribute("mimensaje", mimensaje);
        } else {
            request.setAttribute("mimensaje", mimensaje);
        }
        request.getRequestDispatcher("Producto/AddEditProducto.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
