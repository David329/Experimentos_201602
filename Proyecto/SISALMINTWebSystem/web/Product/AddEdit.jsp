<%-- 
    Document   : AddEdit
    Created on : 27/08/2016, 04:43:44 PM
    Author     : David
--%>

<%@page import="com.sisalmint.entity.Categories"%>
<%@page import="java.util.List"%>
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
        <% List<Categories> lstc = (List<Categories>) request.getAttribute("lstcategories");%>
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
                        <td>Brand</td><td><input value="<%=objproduct == null ? "" : objproduct.getBrand()%>" id="brand" type="text" name="brand" data-error="#errNm3"></td>
                    </tr>
                    <tr>
                        <td>Model</td><td><input value="<%=objproduct == null ? "" : objproduct.getModel()%>" id="model" type="text" name="model" data-error="#errNm4"></td>
                    </tr>
                    <tr>
                        <td>Registration Date</td><td><input value="<%=objproduct == null ? "" : objproduct.getRegDate()%>" id="regdate" type="text" name="regdate" data-error="#errNm5"></td>
                    </tr>
                    <tr>
                        <td>Supplier</td><td><input value="<%=objproduct == null ? "" : objproduct.getSupplier()%>" id="supplier" type="text" name="supplier" data-error="#errNm6"></td>
                    </tr>                    
                    <tr>
                        <td>UnitPrice</td><td><input value="<%=objproduct == null ? "" : objproduct.getUnitPrice()%>" id="unitprice" type="text" name="unitprice" data-error="#errNm7"></td>
                    </tr>
                    <tr>
                        <td>UnitsInStock</td><td><input value="<%=objproduct == null ? "" : objproduct.getUnitsInStock()%>" id="unitsinstock" type="text" name="unitsinstock" data-error="#errNm8"></td>
                    </tr>  
                    <tr>
                        <td>CategoryID</td>
                        <td>
                            <select name="categoryid">
                                <%for (Categories c : lstc) {%>
                                <option value=<%=c.getCategoryID()%>><%=c.getCategoryName()%></option>
                                <%}%>
                            </select>
                        </td>
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
