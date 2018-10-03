<%-- 
    Document   : index
    Created on : 04-ene-2017, 9:39:59
    Author     : RSGUAYAX
--%>

<%@include file="/WEB-INF/jsp/includes.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">     
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/img/utpl.ico" type="image/png">

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/pace.js"></script>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/theme_login.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/font-awesome.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/animate.css" rel="stylesheet"/>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:700,400|Open+Sans+Condensed:300' rel='stylesheet' type='text/css'/>
        <link href="${pageContext.request.contextPath}/recursos/css/theme-loading-bar.css" rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>

        <title>Ideas</title>
    </head>

    <body>
        <!--SECCIÓN DE CARRUSEL-->
        <div class="container" id="container" style="display:none;">
            <header>
                <!-- Main comapny header -->
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <a class="navbar-brand top-navbar-brand" style="margin-top: -10px;" href="http://www.utpl.edu.ec" target="_blank"><img src="recursos/img/utpl.png" style="width: 150px;"/> </a>
                        </div>
                        <ul class="nav navbar-nav navbar-right bigger-130 hidden-xs">
                            <li><a href="#" target="_blank"><i class="fa fa-google"></i></a></li>
                            <li><a href="#" target="_blank"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                        </ul>
                        <h3 class="center-block text-center">Banco de Ideas UTPL</h3>
                    </div>
                </nav>
            </header>
            <section id="form">
                <div class="container"> 
                    <div style="float: left; width: 200px; font-size: 20px;" class="panel-heading">
                        <table class="table table-condensed table-hover table-bordered" style="">
                            <tr href="#" style="cursor: pointer;">
                                <td>
                                    <a class="label label-warning" style="width: 200px;"> <span class="glyphicon glyphicon-tag"></span>  <span class="badge"> <span style="font-size: 30;">450</span> </span>Ideas de Emprendimiento </a><br/>
                                </td>
                            </tr>
                            <tr href="#" style="cursor: pointer;">
                                <td>
                                    <a class="label label-info" style="width: 200px;"> <span class="glyphicon glyphicon-user"></span>  <span class="badge"> <span style="font-size: 30;">300</span> </span>Innovadores </a><br/>
                                </td>
                            </tr>
                            <tr href="#" style="cursor: pointer;">
                                <td>
                                    <a class="label label-success" style="width: 200px;"> <span class="glyphicon glyphicon-eye-open"></span>  <span class="badge"> <span style="font-size: 30;">25</span> </span>Evaluadores </a><br/>
                                </td>
                            </tr>
                            <tr href="#" style="cursor: pointer;">
                                <td>
                                    <a class="label label-default" style="width: 200px;"> <span class="glyphicon glyphicon-usd"></span>  <span class="badge"> <span style="font-size: 30;">0</span> </span>Patrocinadores </a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                        <div class="panel white-alpha-90" >
                            <div class="panel-heading">
                                <div class="pull-left"><img src="recursos/img/user-profile.png" class="img-circle" alt="User Image" style="width: 50px; padding-top: -5px;"/> </div>
                                <div class="panel-title text-center"><h2>Ingreso al  <span class="text-primary">Sistema</span></h2></div>
                            </div>     
                            <div class="panel-body" >
                                <!--<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>-->
                                <span class="glyphicon glyphicon-info-sign"></span>&nbsp;Utilice sus credenciales del correo institucional.
                                <br/><br/>
                                <form id="loginform" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/auth.htm}" method="post">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" autocomplete="true" required="required" placeholder="username" autofocus="autofocus" />                                        
                                    </div>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password" />
                                    </div>
                                    <div class="input-group col-xs-12 text-center login-action">
                                        <div class="checkbox">
                                            <label>
                                                <button type="submit" class="btn btn-primary btn-sm btn-block" id="login" name="login"><i class="glyphicon glyphicon-log-in"></i> Ingresar</button>
                                                <!--<span id="btn-login"><a href="#" class="btn btn-success">Login  </a></span>-->
                                            </label>
                                        </div>
                                    </div>
                                    <c:if test="${not empty mensaje}">
                                        <script>
                                            notificar('glyphicon glyphicon-user', 'Login', 'Ingreso incorrecto', 'pastel-danger');
                                        </script>
                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <p style="font-size: 12px; padding-right: 15px;">${mensaje}</p>
                                        </div>
                                    </c:if>
                                </form>     
                            </div>                     
                        </div>  
                    </div>
                </div>
            </section>

            <!--SECCIÓN BUSCADOR--> 
            <section id="buscador">
                <c:if test="${empty nueva}">
                    <div class="" style="width:99%;padding:0px 60px;">
                        <span style="color: white;">Búsqueda de Ideas de Emprendimiento</span>
                        <input onclick="busqueda_enter();" id="busqueda" name="busqueda" style="width:100%;" autofocus="autofocus" placeholder="Ingrese parte de nombre de idea"/>
                        <span id="span_esperar" style="margin-top: -10px;display: none;"> 
                            <img src="recursos/img/rueda.gif" width="25px" style="padding-top: -20px;"/> 
                        </span>
                    </div>
                </c:if>
            </section>
            <footer>
                <nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
                    <div class="container text-center">
                        <div class="footer-content">
                            <p>Copyright 2017 Banco de Ideas. All rights reserved. <a href="http://www.utpl.edu.ec" target="_blank">UTPL</a></p>
                            <!--Haven't registered yet? <a href="register.html" class="btn btn-primary"> Register Here </a>-->
                        </div>
                    </div><!-- /.container-fluid -->
                </nav>
            </footer>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-1.11.2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.backstretch.min.js"></script>
        <script src="https://use.fontawesome.com/a4a5de964a.js"></script>

        <script>
                                            Pace.on('hide', function () {
                                                $("#container").fadeIn('5000');
                                                $.backstretch([
                                                    "/bancoideas/recursos/img/principal0.jpg",
                                                    "/bancoideas/recursos/img/principal1.jpg"
                                                ], {duration: 1000, fade: 5000});
                                            });
        </script>
    </body>
</html>