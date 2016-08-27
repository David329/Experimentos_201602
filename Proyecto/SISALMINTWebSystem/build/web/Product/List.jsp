<%-- 
    Document   : List
    Created on : 27/08/2016, 04:45:31 PM
    Author     : David
--%>

<%@page import="com.sisalmint.entity.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletListProduct" method="POST" name="miForm">
            <body>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>Nombre del Producto</td>
                            <td><input type="text" name="productname"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Buscar"></td>
                        </tr>
                    </tbody>
                </table>
            </body>
        </form>


        <% List<Products> lista = (List) request.getAttribute("ListProduct"); %>
        <table border="1">
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>UnitPrice</th>
                    <th>UnitsInStock</th>
                    <th>Status</th>
                    <th>RegDate</th>
                    <th>CategoryID</th>
                </tr>
            </thead>
            <tbody>
                <% for (Products p : lista) {%>
                <tr>
                    <td><a href="ServletActualiza?cod=<%=p.getProductID()%>"><%=p.getProductID()%></a></td>
                    <td><%=p.getProductName()%></td>
                    <td><%=p.getUnitPrice()%></td>
                    <td><%=p.getUnitsInStock()%></td>
                    <td><%=p.getStatus()%></td>
                    <td><%=p.getRegDate()%></td>
                    <td><%=p.getCategoryID()%></td>
                    <td><a href="ServletEliminar?cod=<%=p.getProductID()%>">Elimnar</a></td>
                </tr>                
                <%}%>
            </tbody>
        </table>
        <a href="Principal.jsp">Regresar</a>
    </body>
</body>
</html>
