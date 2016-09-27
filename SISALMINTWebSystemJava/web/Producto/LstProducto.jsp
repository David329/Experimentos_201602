<%@page import="java.util.ArrayList"%>
<%@page import="com.sisalmint.entidades.Producto"%>
<%@page import="java.util.List"%>
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
                    <a class="navbar-brand" href="ServletListProduct">SISALMINT</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Usuario <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="index.html"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesión</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="ServletListProduct"><i class="fa fa-fw fa-dashboard"></i> Productos</a>
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
                                Productos
                            </h3>
                        </div>
                    </div>            

                    <div class="col-md-4 col-sm-4 col-xs-12 form-group pull-right top_search">
                        <form action="ServletListProduct" method="POST" name="miForm">
                            <div class="input-group">						
                                <input type="text" class="form-control" name="productname" placeholder="Texto a buscar">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                                </span>
                            </div>
                        </form>
                    </div>

                    <% List<Producto> lista = (List) request.getAttribute("ListProduct") == null ? new ArrayList<Producto>() : (List) request.getAttribute("ListProduct");%>
                    <div class="col-md-4 col-sm-4 col-xs-12 form-group pull-left">
                        <a href="ServletFindProduct" class="btn btn-primary"><i class="fa fa-plus"></i> Agregar </a>
                    </div>
                    <div class="col-lg-12">
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Código</th>
                                        <th>Nombre</th>
                                        <th>Marca</th>
                                        <th>Modelo</th>
                                        <th>Tipo</th>
                                        <th>Precio</th>
                                        <th>Fecha de Ingreso</th>
                                        <th>Cantidad</th>
                                        <th>Fallo de Fábrica</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Producto p : lista) {%>
                                    <tr>
                                        <td><a class="btn btn-link btn-xs" href="ServletFindProduct?productid=<%=p.getCodigo()%>"> <i class="fa fa-edit"></i><%=p.getCodigo()%></a></td>
                                        <td><%=p.getNombre()%></td>
                                        <td><%=p.getMarca()%></td>
                                        <td><%=p.getModelo()%></td>
                                        <td><%=p.getTipoID()%></td>
                                        <td><%=p.getPrecioCompra()%></td>
                                        <td><%=p.getFechaIngreso()%></td>
                                        <td><%=p.getCantidadIngresada()%></td>
                                        <td><%=p.getFallaFabrica()%></td>
                                        <td>
                                            <a class="btn btn-link btn-xs" href="ServletDetalleProducto?productid=<%=p.getCodigo()%>"> <i class="fa fa-info-circle"></i> Detalles</a> | <a class="btn btn-link btn-xs" href="ServletDeleteProduct?productid=<%=p.getCodigo()%>"> <i class="fa fa-remove"></i> Eliminar</a>
                                        </td>
                                    </tr>                
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
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