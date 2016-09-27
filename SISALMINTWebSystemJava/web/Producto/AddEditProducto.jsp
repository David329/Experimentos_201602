<%@page import="com.sisalmint.entidades.Tipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sisalmint.entidades.Producto"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SISALMINT</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/Content/Template/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/Content/Template/css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/Content/Template/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <% Producto objproduct = (Producto) request.getAttribute("objproduct");%>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="LstProducto.jsp">SISALMINT</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Usuario <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href=".../index.html"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesión</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="LstProducto.jsp"><i class="fa fa-fw fa-dashboard"></i> Productos</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">
                                Agregar/Modificar Producto
                            </h3>
                        </div>
                    </div>
                    <div class="x_content">
                        <% List<Tipo> listaT = (List) request.getAttribute("LstTipo") == null ? new ArrayList<Tipo>() : (List) request.getAttribute("LstTipo");%>

                        <form class="form-horizontal form-label-left" action="ServletAddEditProduct?editar=<%=objproduct == null ? "0" : "1"%>" novalidate method="post">
                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="codigo">
                                    Código: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getCodigo()%>" <%=objproduct == null ? "" : "readonly"%> id="codigo" name="codigo" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre">
                                    Nombre: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getNombre()%>" id="nombre" name="nombre" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="marca">
                                    Marca: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getMarca()%>" id="marca" name="marca" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="modelo">
                                    Modelo: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getModelo()%>" id="modelo" name="modelo" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="fechaingreso">
                                    Fecha de Ingreso: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getFechaIngreso()%>" id="fechaingreso" name="fechaingreso" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="distribuidor">
                                    Distribuidor: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getDistribuidor()%>" id="distribuidor" name="distribuidor" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="precio">
                                    Precio de Compra: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getPrecioCompra()%>" id="precio" name="precio" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cantidad">
                                    Cantidad: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="<%=objproduct == null ? "" : objproduct.getCantidadIngresada()%>" id="cantidad" name="cantidad" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="falla">
                                    Falla de Fábrica: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="falla" name="falla" type="radio" value="0" checked="true"> No
                                    <input id="falla" name="falla" type="radio" value="1"> Sí
                                </div>
                            </div>			

                            <div class="item form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tipo">
                                    Tipo: <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select id="tipo" name="tipo" class="form-control col-md-7 col-xs-12">
                                        <% for (Tipo t : listaT) {%>
                                        <option value=<%=t.getTipoId()%>><%=t.getNombre()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-md-offset-3">
                                    <button id="enviar" type="submit" class="btn btn-success"><i class="fa fa-save"></i> Procesar</button>
                                    <a class="btn btn-primary" href="LstProducto.jsp"><i class="fa fa-close"></i> Cancelar</a>
                                </div>
                            </div>						
                        </form>
                        <br/>
                        <h2><%=request.getAttribute("mimensaje") == null ? "" : request.getAttribute("mimensaje").toString()%></h2>
                        <br/>
                        <a class="btn btn-danger" href="ServletListProduct">Regresar</a>   
                    </div>       
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/Content/Template/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${pageContext.request.contextPath}/Content/Template/js/bootstrap.min.js"></script>

    </body>

</html>
