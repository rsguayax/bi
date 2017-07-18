<%-- 
    Document   : header
    Created on : 20-abr-2015, 23:26:28
    Author     : TAWSBC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Banco de Ideas</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/img/utpl.ico" type="image/png">

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/primeui-1.0-min.js"></script>
        
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap.min-3.3.4.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/recursos/css/primeui-1.0-min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/theme.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/jquery-ui.css" rel="stylesheet" />
        
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/util.js"></script>

        <style>
            .search{
                width:100%; 
                height:32px;
                border-radius:21px; 
                font-size:12px;
                padding:7px 27px 6px 12px;  
                background-color:#F5F8FA;
            }

            .subtitle{
                color: #0084B4;
            }

            .form-control {
                padding-right: 30px;
            }

            .form-control + .glyphicon {
                position: absolute;
                right: 0;
                padding: 22px 27px;
            }

        </style>
        <script>
            $(document).ready(function () {
                $('#span_esperar').hide();

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
//                            data: {cadena: request.query},
                            dataType: "json",
                            contentType: "application/json",
                            context: this,
                            success: function (data) {
                                $('#span_esperar').hide();
                                response.call(this, $.map(data, function (item) {
                                    return{
                                        label: item.nombre,
                                        value: item.id
                                    };
                                }));
                            },
                            error: function (request, status, error) {
                                $('#span_esperar').hide();
//                                alert('No fue posible obtener la busqueda.');
                            }
                        });
                    },
                    select: function (event, ui) {
//                        $('#mdl_modal').modal('show');
                        obtenerDetalle(ui.data('value'), 'divVisualizar');
                    }
                });
            });

            function mueveReloj() {
                momentoActual = new Date()
                hora = momentoActual.getHours()
                minuto = momentoActual.getMinutes()
                segundo = momentoActual.getSeconds()
                horaImprimible = hora + " : " + minuto + " : " + segundo
                $('#reloj').html(formatearFechaConDiaYMes(momentoActual) + ' - ' + horaImprimible);
                setTimeout("mueveReloj()", 1000)
            }
            momentoActual = new Date();
            $('#reloj').html(formatearFechaConDiaYMes(momentoActual));

            function obtenerDetalle(idIdea) {
                var idea = callWS('${pageContext.request.contextPath}/idea/buscarporid.htm', 'GET', 'JSON', {id: parseInt(idIdea)});
                $('#mdl_body').text('');
                var html =
//                        '<span class="pull-right"><small><strong class="bg-primary" style="border-radius:21px; padding: 0px 5px 0px 5px;"><em>' + idea.nombre + '</em></strong></small></span></div>' +
                        '<table id="tblNodeInfo" class="table table-bordered" width="100%"> ' +
                        '<tbody> ' +
                        '<tr>' +
                        '<td colspan="2">' +
                        '<label class="label label-default">' + idea.convocatoria.nombre + '</label>' +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td colspan="2">' +
                        '<a href="${pageContext.request.contextPath}/recursos/img/' + idea.imagen + '" target="_blank" style="float:left;"> <img   height = "50px" width = "100px" src="' + '${pageContext.request.contextPath}/recursos/img/' + idea.imagen + '" > </a>' +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td colspan="2" >' +
                        '<label>' + idea.nombre + '</label>' +
                        '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Descripción: </td>' +
                        '<td width="70%">' + idea.descripcion + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Objetivo </td>' +
                        '<td width="70%">' + idea.objetivo + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Mercado potencial </td>' +
                        '<td width="70%">' + idea.mercadoPotencial + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Palabras clave </td>' +
                        '<td width="70%"> <label class="bg-badge">' + idea.kw + '</label> </td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Lugar </td>' +
                        '<td width="70%">' + idea.lugar + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Tipo </td>' +
                        '<td width="70%">' + idea.itemCatalogoByTipo.nombre + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Estado </td>' +
                        '<td width="70%">' + idea.itemCatalogoByEstado.nombre + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary"> Área </td>' +
                        '<td width="70%">' + idea.itemCatalogoByArea.nombre + '</td>' +
                        '</tr>' +
                        '</tbody>' +
                        '</table>';
                $('#mdl_body').append(html);
                $('#mdl_modal').modal();
            }
        </script>
    </head>
    <body>
        <div class="container" style="background-color: #FFF; "> 
            <br>
            <c:if test="${nombre == null}"> 
                <form:form action="/bancoideas/login/auth.htm" modelAttribute="login" method="POST">  
                    <div class="row">
                        <div class="col-md-4">
                            <span class="glyphicon glyphicon-bold"></span>
                            <span class="glyphicon glyphicon-italic"></span>
                            <label class="">Banco de Ideas UTPL</label>
                            <span class="glyphicon glyphicon-grain"></span>
                        </div>
                        <div class="col-md-8 pull-right">
                            <span class="glyphicon glyphicon-user"></span>
                            <form:input type="text" path="username" autocomplete="true" placeholder="usuario" required="" style="width: 33%;" autofocus="autofocus"/>
                            <form:errors path="username" cssClass="error" />
                            <span class="glyphicon glyphicon-lock"></span>
                            <form:input type="password" path="password" placeholder="contraseña" required="" style="width: 33%;"/>
                            <form:errors path="password" cssClass="error" />
                            <span style="width: 33%;"> <button class="btn-sm btn-link">ingresar</button> </span>
                            <a href="/bancoideas"> <span class="glyphicon glyphicon-home"></span> </a>
                        </div>
                    </div>
                    <c:if test="${!empty mensaje}">
                        <div class="alert alert-danger alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            ${mensaje}
                        </div>
                    </c:if>
                </form:form>
            </c:if>
            <c:if test="${nombre != null}"> 
                <div class="row"> 
                    <div class="col-md-4">
                        <span class="glyphicon glyphicon-bold"></span>
                        <span class="glyphicon glyphicon-italic"></span>
                        <label class="">Banco de Ideas UTPL</label>
                        <span class="glyphicon glyphicon-grain"></span>
                    </div>
                    <div class="col-md-8">
                        <span class="pull-right">
                            <a href="/bancoideas" class=""> <span class="glyphicon glyphicon-home"></span> </a>
                            <span class=""><em>${nombre}</em> </span>
                            <a href="/bancoideas/login/logout.htm" class=""><span class="round button dark menu-logoff image-left"></span><strong> ( Salir ) </strong></a>
                        </span>
                    </div>
                </div>
            </c:if>

            <div class="row">
                <div class="col-md-12" style="padding-top: 10px;">
                    <input id="busqueda" name="busqueda" class="search thumbnail form-control" type="search" value="" type="text"  placeholder="Búsqueda de ideas" />
                    <span class="glyphicon glyphicon-search">
                        <span id="span_esperar" style="margin-top: -10px;"> 
                            <img src="${pageContext.request.contextPath}/recursos/img/circulo.gif" width="25px" style="padding-top: -20px;"/> 
                        </span>
                    </span>
                </div>
            </div>
            <!--<hr style="margin-top: -15px;">-->
            <c:if test="${!empty nombre}">  
                <c:if test="${!empty menu}">
                    <div class="row  pull-right" id="div_menu"> 
                        <div class="col-md-12">
                            <c:forEach items="${menu}" var="m">
                                <div class="btn-group" style="padding-top: 10px;">
                                    <a></a>
                                    <a id="dLabel" data-target="#" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                                        <span class="${m.titulo.icono}" aria-hidden="true"></span> ${m.titulo.nombre}
                                        <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                        <c:forEach items="${m.items}" var="it">
                                            <li> <a href="${it.url}"> <span class="${it.icono}" aria-hidden="true"></span> ${it.nombre} </a> </li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
            </c:if>
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
                                <div id="mdl_footer"></div>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>