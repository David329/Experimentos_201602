/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.servlet;

import com.sisalmint.entity.Products;
import com.sisalmint.service.ServiceProducts;
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
        ServiceProducts sp = new ServiceProducts();
        String editar = request.getParameter("editar");

        String as = request.getParameter("RegDate");
        String bdate = request.getParameter("RegDate").replace("/", "-");

        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String reformattedStr = myFormat.format(fromUser.parse(inputString));
        
        Date date = parseDate("19/05/2009", "dd/MM/yyyy");

        Products product = new Products();
        product.setProductID(request.getParameter("productid"));
        product.setProductName(request.getParameter("productname"));
        product.setUnitPrice(new BigDecimal(request.getParameter("unitprice")));
        product.setUnitsInStock(Integer.parseInt(request.getParameter("unitsinstock")));
        product.setStatus(request.getParameter("status"));
        product.setRegDate(Date.valueOf(bdate));
        product.setCategoryID(Integer.parseInt(request.getParameter("categoryid")));

        if ("1".equals(editar)) {
            sp.editProduct(product);
        } else {
            sp.addProduct(product);
        }

        request.getRequestDispatcher("Principal.jsp").forward(request, response);
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
