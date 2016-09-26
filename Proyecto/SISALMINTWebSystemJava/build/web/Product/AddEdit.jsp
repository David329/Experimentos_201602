<%-- 
    Document   : AddEdit
    Created on : 27/08/2016, 04:43:44 PM
    Author     : David
--%>

<%@page import="com.sisalmint.entity.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#regdate").datepicker({
                    dateFormat: 'yy-mm-dd'
                });
            });
        </script>
    </head>
    <body>
        <% Products objproduct = (Products) request.getAttribute("objproduct");%>
        <form action="ServletAddEditProduct?editar=<%=objproduct == null ? "0" : "1"%>" method="POST" id="miForm" name="miForm" novalidate="novalidate">
            <table border="1">
                <tbody>
                    <tr>
                        <td>ProductID</td><td><input value="<%=objproduct == null ? "" : objproduct.getProductID()%>" <%=objproduct == null ? "" : "readonly"%> id="productid" type="text" name="productid" data-error="#errNm1"></td>
                    </tr>
                    <tr>
                        <td>ProductName</td><td><input value="<%=objproduct == null ? "" : objproduct.getProductName()%>" id="productname" type="text" name="productname" data-error="#errNm2"></td>
                    </tr>
                    <tr>
                        <td>UnitPrice</td><td><input value="<%=objproduct == null ? "" : objproduct.getUnitPrice()%>" id="unitprice" type="text" name="unitprice" data-error="#errNm3"></td>
                    </tr>
                    <tr>
                        <td>UnitsInStock</td><td><input value="<%=objproduct == null ? "" : objproduct.getUnitsInStock()%>" id="unitsinstock" type="text" name="unitsinstock" data-error="#errNm4"></td>
                    </tr>
                    <tr>
                        <td>Status</td><td><input value="<%=objproduct == null ? "" : objproduct.getStatus()%>" id="status" type="text" name="status" data-error="#errNm5"></td>
                    </tr>
                    <tr>
                        <td>RegDate</td><td><input value="<%=objproduct == null ? "" : objproduct.getRegDate()%>" id="regdate" type="text" name="regdate" data-error="#errNm6"></td>
                    </tr>
                    <tr>
                        <td>CategoryID</td><td><input value="<%=objproduct == null ? "" : objproduct.getCategoryID()%>" id="categoryid" type="text" name="categoryid" data-error="#errNm7"></td>
                    </tr>
                    <tr>
                        <td><input id="idRegistrar" name="idRegistrar" type="submit" value="Registrar"></td>
                        <td><input type="reset" value="Cancelar"></td>
                    </tr>
                </tbody>
            </table>
            <a href="Principal.jsp">Regresar</a>            
        </form>
    </body>
</html>
