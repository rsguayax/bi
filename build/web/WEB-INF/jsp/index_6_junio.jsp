<%-- 
    Document   : index
    Created on : 04-ene-2017, 9:39:59
    Author     : TAWSBC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/img/utpl.ico" type="image/png">

        <title>Ideas</title>

        <!-- jQuery 2.2.3 -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>
        <!--<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap3-typeahead.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/bootstrap-tagsinput.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap-tagsinput.css" rel="stylesheet"/>

        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
        <!--<script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-1.11.2.js"></script>-->

        <!--<script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/primeui-1.0-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap.min.js"></script>

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/flat/blue.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

        <link href="${pageContext.request.contextPath}/recursos/css/primeui-1.0-min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/jquery-ui.css" rel="stylesheet" />

        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/notify/animate.css" type="text/css" />
        <script src="${pageContext.request.contextPath}/notify/bootstrap-notify.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/util.js" type="text/javascript"></script>


        <style>
            .search{
                width:100%; 
                height:32px;
                border-radius:21px; 
                font-size:12px;
                padding:7px 27px 6px 12px;  
                padding-top: 10px;
                background-color:#F5F8FA;
            }

            .subtitle{
                color: #0084B4;
            }

            /*body{margin:40px;}*/
            .btn-circle {
                width: 30px;
                height: 30px;
                text-align: center;
                padding: 6px 0;
                font-size: 12px;
                line-height: 1.428571429;
                border-radius: 15px;
            }
            .btn-circle.btn-lg {
                width: 50px;
                height: 50px;
                padding: 10px 16px;
                font-size: 18px;
                line-height: 1.33;
                border-radius: 25px;
            }
            .btn-circle.btn-xl {
                width: 70px;
                height: 70px;
                padding: 10px 16px;
                font-size: 24px;
                line-height: 1.33;
                border-radius: 35px;
            }

            .bloque{
                height: 150px;
                max-height: 150px;
                /*margin: -5px -5px -5px -5px;*/
            }
        </style>
        <style>
            @import url(http://fonts.googleapis.com/css?family=Old+Standard+TT:400,700);
            [data-notify="container"][class*="alert-pastel-"] {
                background-color: rgb(255, 255, 238);
                border-width: 0px;
                border-left: 15px solid rgb(255, 240, 106);
                border-radius: 0px;
                box-shadow: 0px 0px 5px rgba(51, 51, 51, 0.3);
                font-family: 'Old Standard TT', serif;
                letter-spacing: 1px;
            }
            [data-notify="container"].alert-pastel-info {
                border-left-color: rgb(255, 179, 40);
            }
            [data-notify="container"].alert-pastel-danger {
                border-left-color: rgb(255, 103, 76);
            }
            [data-notify="container"][class*="alert-pastel-"] > [data-notify="title"] {
                color: rgb(80, 80, 57);
                display: block;
                font-weight: 700;
                margin-bottom: 5px;
            }
            [data-notify="container"][class*="alert-pastel-"] > [data-notify="message"] {
                font-weight: 400;
            }
        </style>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">  <!-- -->
        <header class="main-header">
            <!-- Logo -->
            <a href="#" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>I</b>dea</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Ideas</b></span>
            </a>
            <nav class="navbar navbar-static-top">
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">

                </a>
                <small class="pull-left">
                    <div class="form-group has-feedback">
                        <input id="busqueda" name="busqueda" class="search form-control" type="search" value="" type="text"  placeholder="Búsqueda de ideas publicadas" style="width: 200%;" />
                    </div>
                </small>
            </nav>
        </header>

        <!--<div class="wrapper">
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left">
                        <img src="${pageContext.request.contextPath}/recursos/img/utpl.png" alt="" />
                    </div>
                </div>
                <br><br>
                <div style="padding-left: 10px; padding-right: 10px;">
                    <p class="text-justify">Es un sistema para emprendedores a través del cual podrá inscribir su idea de negocio 
                        que a su vez le permitirá contactar con inversionistas que impulsarán el desarrollo
                        de su iniciativa
                    </p>
                    <br>
                    <label>Ingrese sus credenciales</label>
                    <div class="alert " role="alert">
                        <span class="glyphicon glyphicon-info-sign"></span>(credenciales del EVA ) si es usuario UTPL
                    </div>
                    <form:form action="/bancoideas/auth.htm" modelAttribute="login" method="POST">  
                        <form:input type="text" path="username" autocomplete="true" placeholder="usuario" required="" style="width: 100%; margin-bottom:10px;" autofocus="autofocus"/>
                        <form:input type="password" path="password" placeholder="contraseña" required="" style="width: 100%; margin-bottom:10px;" />
                        <button class="btn btn-sm btn-primary btn-block" style="margin-bottom:10px;">Ingresar <span class="glyphicon glyphicon-log-in"></span> </button> 
                        <c:if test="${mensaje != null}">
                            <br><br>
                            <div class="alert alert-danger alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <p style="font-size: 12px; padding-right: 15px;">${mensaje}</p>
                            </div>
                        </c:if>
                    </form:form>  
                    <!--                    <div class="social-auth-links text-center">
                                            <p>- O -</p>
                                            <span class="btn btn-block btn-social btn-google btn-flat fa fa-facebook"></span>
                                            <div>
                                                <a href="#" class="btn btn-circle btn-facebook fa fa-facebook"> </a>
                                                <a href="#" class="btn btn-circle btn-twitter fa fa-twitter"> </a>
                                                <a href="#" class="btn btn-circle btn-google fa fa-google-plus"> </a>
                                            </div>
                                        </div>
                                        <a href="#">Olvido su contraseña?</a><br>-->
                    <label class="label label-info" > <a href="#"  data-toggle="modal" data-target="#mdl_register" style="color: black;">Registrarse !.</a> </label>
                </div>
            </section>
            <!-- /.sidebar -->
        </aside>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Banco de Ideas
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                    <!--<li class="active">Dashboard</li>-->
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <!-- Small boxes (Stat box) -->
                <div class="row thumbnail">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-blue-active">
                            <div class="inner">
                                <h3>${count_convocatorias}</h3>
                                <p>Convocatorias</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-ios-pricetag-outline"></i>
                            </div>
                            <a href="#" class="small-box-footer" onclick="cargar_items('convocatoria');">ver más <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>

                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                            <div class="inner">
                                <h3>3</h3>
                                <p>Emprendedores</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                            <a href="#" class="small-box-footer" onclick="cargar_items('emprendedor');">ver más <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-green">
                            <div class="inner">
                                <h3>1</h3>
                                <p>Evaluadores</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                            <a href="#" class="small-box-footer" onclick="cargar_items('evaluador');">ver más <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                            <div class="inner">
                                <h3>1</h3>
                                <p>Patrocinadores</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                            <a href="#" class="small-box-footer" onclick="cargar_items('patrocinador');">ver más <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div id="div_resultados" class="row" style="overflow:scroll; height: 500px;">
                    <c:if test = "${convocatorias != null}">
                        <c:forEach items="${convocatorias}" var="item">
                            <div class="col-md-4 thumbnail bloque" style="background-color:  #ecf0f5;">
                                <div  style="padding-left: 5px; background-color: #e0ebeb;"><span class="label" style="color:steelblue;font-size: 13px;">${item.nombre}</span></div>
                                <div class="col-md-6">
                                    <img src="${item.imagen}" style="width: 150px; max-height: 100px;"/>
                                </div>
                                <div class="col-md-6">
                                    ${item.descripcion}
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </section>

            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.0
            </div>
            <strong>Copyright &copy; 2017 <a href="http://www.utpl.edu.ec">Universidad Técnica Particular de Loja</a>.</strong> All rights reserved.
        </footer>

        <!-- /.control-sidebar -->
        <!-- Add the sidebar's background. This div must be placed
             immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
        <!--</div>-->
        <!-- ./wrapper -->

        <!-- jQuery UI 1.11.4 -->
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/dist/js/app.min.js"></script>

        <!-- Modal -->
        <div class="modal fade" id="mdl_register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="register-box">
                            <div class="register-logo">
                                <a href="#"><b>Banco de </b>Ideas</a>
                            </div>

                            <div class="register-box-body">
                                <p class="login-box-msg">Registro de usuarios</p>

                                <form action="nuevousuario.htm" method="post">
                                    <div class="form-group has-feedback">
                                        <input type="text" id="nombres" name="nombres" class="form-control" placeholder="Nombres Completos" required>
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="email" id="email" name="email" class="form-control" placeholder="Email" required>
                                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="text" id="usr" name="usr" class="form-control" placeholder="usuario" required>
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" placeholder="Repetir password" required>
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-8">
                                            <div class="checkbox icheck">
                                                <label>
                                                    <input type="checkbox" id="chk_acepta" onchange="if (document.getElementById('chk_acepta').checked) {
                                        $('#btnNuevo').attr('disabled', false)
                                    } else {
                                        $('#btnNuevo').attr('disabled', true)
                                    }"> Acepto los <a href="#">términos</a>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <button id="btnNuevo" type="submit" class="btn btn-primary btn-block btn-flat" disabled="true">Registrarse</button>
                                        </div>
                                    </div>
                                </form>

                                <!--                                <div class="social-auth-links text-center">
                                                                    <p>- O -</p>
                                                                    <span class="btn btn-block btn-social btn-google btn-flat fa fa-facebook"></span>
                                                                    <div>
                                                                        <a href="#" class="btn btn-circle btn-facebook fa fa-facebook"> </a>
                                                                        <a href="#" class="btn btn-circle btn-twitter fa fa-twitter"> </a>
                                                                        <a href="#" class="btn btn-circle btn-google fa fa-google-plus"> </a>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="mdl_modal" tabindex="1" role="dialog" aria-labelledby="mdl_label" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div style="float: left;">
                        <strong><span class="modal-title" id="mdl_label"></span></strong> 
                    </div>
                </div>
                <div class="modal-body">
                    <div class="row" id="mdl_body" style="padding-left: 40px; padding-right: 40px;"> </div>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <center>
                            <div id="mdl_footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"> <span class="glyphicon glyphicon-remove"></span> cerrar</button>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        var newuser = false;
        var src = String(window.location.href).split('?')[1];
        if (src != undefined) {
            var vrs = src.split('&');
            for (var x = 0, c = vrs.length; x < c; x++) {
                var parametro = String(vrs[x]).split('=');
                if (parametro[0] == 'action') {
                    newuser = true;
                }
            }
        }
        if (!newuser)
            notificar('glyphicon glyphicon-star-empty', 'Bienvenido', 'Banco de Ideas UTPL','pastel-info');
        else
            notificar('glyphicon glyphicon-user', 'Usuario Creado','satisfactoriamente','pastel-success');

        $(document).ready(function () {
            $('#busqueda').puiautocomplete({
                effect: 'fade',
                effectSpeed: 'fast',
                minQueryLength: 3,
                completeSource: function (request, response) {
                    $('#span_esperar').show();
                    $.ajax({
                        type: "GET",
                        url: '${pageContext.request.contextPath}/idea/buscar.htm',
                        //                            url:'sgtt/tema/buscar.htm',
                        data: {cadena: request.query},
                        dataType: "json",
                        contentType: "application/json",
                        context: this,
                        success: function (data) {
                            //                                $('#span_esperar').hide();
                            response.call(this, $.map(data, function (item) {
                                return{
                                    label: item.nombre,
                                    value: item.id
                                };
                            }));
                        },
                        error: function (request, status, error) {
                            //                                $('#span_esperar').hide();
                            //                                alert('No fue posible obtener la busqueda.');
                        }
                    });
                },
                select: function (event, ui) {
                    //                        $('#mdl_modal').modal('show');
                    //                        alert(ui.data('value'));
                    obtenerDetalle(ui.data('value'), 'divVisualizar');
                }
            });
        });

        function obtenerDetalle(idIdea) {
            var idea = callWS('${pageContext.request.contextPath}/idea/buscarporid.htm', 'GET', 'JSON', {id_idea: parseInt(idIdea)});
            $('#mdl_body').text('');
            var html =
                    //                        '<span class="pull-right"><small><strong class="bg-primary" style="border-radius:21px; padding: 0px 5px 0px 5px;"><em>' + idea.nombre + '</em></strong></small></span></div>' +
                    '<table id="tblNodeInfo" class="table table-bordered" style="width:100%;"> ' +
                    '<tbody> ' +
                    '<tr>' +
                    '<td colspan="2">' +
                    '<label class="label label-default" style="float:right;">' + idea.convocatoria.nombre + '</label>' +
                    '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td colspan="2">' +
                    '<a href="${pageContext.request.contextPath}/recursos/img/' + idea.imagen + '" target="_blank" style="float:left;"> <img   height = "50px" width = "100px" src="' + '${pageContext.request.contextPath}/recursos/img/' + idea.imagen + '" > </a>' +
                    '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td colspan="2" align="center">' +
                    '<label><strong style="text-transform:uppercase;">' + idea.nombre + '</strong></label>' +
                    '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td class="bg-primary" style="background-color:#003F72; color:white;"> Descripción: </td>' +
                    '<td width="70%"> ' + idea.descripcion + '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td class="bg-primary" style="background-color:#003F72; color:white;"> Tipo </td>' +
                    '<td width="70%">' + idea.itemCatalogoByTipo.nombre + '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td class="bg-primary" style="background-color:#003F72; color:white;"> Estado </td>' +
                    '<td width="70%">' + idea.itemCatalogoByEstado.nombre + '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td class="bg-primary" style="background-color:#003F72; color:white;"> Clasificación CIIU </td>' +
                    '<td width="70%">' + idea.itemCatalogoByArea.nombre + '</td>' +
                    '</tr>';
            if (idea.facebook != '' || idea.youtube != '' || idea.twitter != '') {
                html += '<tr>' +
                        '<td colspan="2"> <strong>* MEDIA</strong> </td>' +
                        '</tr>';
            }
            if (idea.facebook != '') {
                html += '<tr>' +
                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> link facebook </td>' +
                        '<td width="70%"><a href="' + idea.facebook + '" target="_blank">' + idea.facebook + '</a></td>' +
                        '</tr>';
            }
            if (idea.youtube != '') {
                html += '<tr>' +
                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> link youtube </td>' +
                        '<td width="70%">' + idea.youtube + '</td>' +
                        '</tr>';
            }
            if (idea.twitter != '') {
                html += '<tr>' +
                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> link twitter</td>' +
                        '<td width="70%">' + idea.twitter + '</td>' +
                        '</tr>';
            }
            '</tbody>' +
                    '</table>';
            $('#mdl_body').append(html);
//            $('#mdl_modal').modal('show');
            $('#mdl_modal').show('show');
        }

        function cargar_items(op) {
            $('#div_resultados').text('');
            var salida = '';
            if (op == 'convocatoria') {
                var data = callWS('convocatorias.htm', 'GET', 'JSON', {});
                $.each(data, function (i, item) {
                    salida += '<div class="col-md-4 thumbnail bloque" style="background-color:  #ecf0f5;">' +
                            '      <div  style="padding-left: 5px; background-color: #e0ebeb;"><span class="label" style="color:steelblue;font-size: 13px;">' + item.nombre + '</span></div>' +
                            '      <div class="col-md-6">' +
                            '          <img src="' + item.imagen + '" style="width: 150px; max-height: 100px;"/>' +
                            '      </div>' +
                            '      <div class="col-md-6">' +
                            item.descripcion +
                            '      </div>' +
                            '  </div>';
                });
            } else if (op == 'emprendedor') {
                var data = callWS('emprendedores.htm', 'GET', 'JSON', {});
                $.each(data, function (i, item) {
                    salida += '<div class="col-md-4 thumbnail bloque" style="background-color:  #ecf0f5;">' +
                            '          <img src="recursos/img/user-profile.png" style="width: 50px; max-height: 50px;"/>' +
                            '      <div  style="padding-left: 5px; background-color: #e0ebeb;"><span class="label" style="color:steelblue;font-size: 13px;">' + item.usuario.nombre + '</span></div>' +
                            '       <label class="label label-default">correo: </label>' + item.usuario.correo +
                            '       </br><label class="label label-default">registrado: </label>' + item.usuario.register +
                            '  </div>';
                });
            } else if (op == 'evaluador') {
                var data = callWS('evaluadores.htm', 'GET', 'JSON', {});
                $.each(data, function (i, item) {
                    salida += '<div class="col-md-4 thumbnail bloque" style="background-color:  #ecf0f5;">' +
                            '          <img src="recursos/img/user-profile.png" style="width: 50px; max-height: 50px;"/>' +
                            '      <div  style="padding-left: 5px; background-color: #e0ebeb;"><span class="label" style="color:steelblue;font-size: 13px;">' + item.usuario.nombre + '</span></div>' +
                            '       <label class="label label-default">correo: </label>' + item.usuario.correo +
                            '       </br><label class="label label-default">registrado: </label>' + item.usuario.register +
                            '  </div>';
                });
            } else if (op == 'patrocinador') {
                var data = callWS('patrocinadores.htm', 'GET', 'JSON', {});
                $.each(data, function (i, item) {
                    salida += '<div class="col-md-4 thumbnail bloque" style="background-color:  #ecf0f5;">' +
                            '          <img src="recursos/img/user-profile.png" style="width: 50px; max-height: 50px;"/>' +
                            '      <div  style="padding-left: 5px; background-color: #e0ebeb;"><span class="label" style="color:steelblue;font-size: 13px;">' + item.usuario.nombre + '</span></div>' +
                            '       <label class="label label-default">correo: </label>' + item.usuario.correo +
                            '       </br><label class="label label-default">registrado: </label>' + item.usuario.register +
                            '  </div>';
                });
            }
            $('#div_resultados').html(salida);

        }
    </script>
</body>
</html>

