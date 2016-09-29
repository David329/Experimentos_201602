<%@page import="com.sisalmint.entidades.Admin"%>
<!DOCTYPE html>
<html lang="en">
    <head>  
        <!-- Added by HTTrack -->
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <!-- /Added by HTTrack -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SISALMINT</title>

        <link href="${pageContext.request.contextPath}/Content/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Content/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Content/css/components.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Content/css/colors.css" rel="stylesheet" type="text/css"/>
        <script src="Content/js/plugins/loaders/pace.min.js" type="text/javascript"></script>
        <script src="Content/js/core/libraries/jquery.min.js" type="text/javascript"></script>
        <script src="Content/js/core/libraries/bootstrap.min.js" type="text/javascript"></script>
        <script src="Content/js/plugins/loaders/blockui.min.js" type="text/javascript"></script>
        <script src="Content/js/core/app.js" type="text/javascript"></script>

        <style>
            #imgLogo {
                width: 100px;
            }
            .pace.pace-active {
                display: none;
            }
        </style>
    </head>

    <body>

        <!-- Page container -->
        <div class="page-container login-container">

            <!-- Page content -->
            <div class="page-content">

                <!-- Main content -->
                <div class="content-wrapper">

                    <% String mensajito= request.getAttribute("mimensajito")==null?"":request.getAttribute("mimensajito").toString();%>
                    <div class="panel panel-body login-form">
                        <div class="text-center">
                            <h3 class="content-group">SISALMINT</h3>
                            <h5 class="content-group">Inicio de sesión<small class="display-block">Ingresa tus credenciales</small></h5>
                        </div>

                        <form id="miForm" name="miForm" action="ServletLogin" method="POST" novalidate="novalidate">
                            <div class="form-group has-feedback has-feedback-left">
                                <input class="form-control" placeholder="Usuario" type="text" id="user" name="user" data-error="#errNm1">
                                <div class="form-control-feedback">
                                    <i class="icon-user text-muted"></i>
                                </div>
                            </div>

                            <div class="form-group has-feedback has-feedback-left">
                                <input class="form-control" placeholder="Password" type="password" id="password" name="password" data-error="#errNm2">
                                <div class="form-control-feedback">
                                    <i class="icon-lock2 text-muted"></i>
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Ingresar<i class="icon-circle-right2 position-right"></i></button>
                            </div>
                        </form> 
                        <h3><%=mensajito%></h3>
                    </div>
                    <!-- /simple login form -->

                </div>
                <!-- /main content -->

            </div>
            <!-- /page content -->

        </div>
        <!-- /page container -->

    </body>
</html>







