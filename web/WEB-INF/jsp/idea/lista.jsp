<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ideas</title>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap.min-3.3.4.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
    <header>
        <jsp:include page="../inicio/header.jsp" />
    </header>
    <div class="container">
        <c:if test = "${nombre == null}">
            <a href="javascript:history.back(1)"><span class="glyphicon glyphicon-menu-left"></span>Volver Atrás</a>
            <br><br>
        </c:if>
        <c:if test = "${nombre != null}">
            <a class="btn-sm btn-success" href="idea/index.htm?us=${us}"> <span class="glyphicon glyphicon-plus"></span> Nueva Idea </a>
            <br><br>
        </c:if>

        <c:if test = "${ideas != null}">
            <div class="row">
                <c:forEach items="${ideas}" var="idea">
                    <div class="col-md-4">
                        <div class="thumbnail" style="min-height: 250px; max-height: 250px; position:relative;">
                            <div class="bg-primary" style="height: 18px; padding-left: 10px; font-size: 12px; ">
                                <label>${idea.nombre}</label> 
                            </div>
                            <table>
                                <tr>
                                    <td> <div style="min-height: 90px;"> <img src="${pageContext.request.contextPath}/recursos/img/${idea.imagen}" style="width: 100%; " /> </div> </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div style="float: left; padding-leftt: 10px; margin-top: 10px;" class="pull-left" >
                                            <label class="label label-default">${idea.itemCatalogoByEstado.nombre}</label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td> <p style="padding-left: 5px;">${fn:substring(idea.descripcion, 0, 120)}</p> </td>
                                </tr>
                            </table>
                            <div style="position:absolute;bottom:5px;right:10px;">
                                <div style="float: right; padding-right: 10px;" >
                                    <a title="detalle" class="btn-sm btn-primary" onclick="obtenerDetalle(${idea.id})" style="cursor:pointer;"> <span class="glyphicon glyphicon-search"></span></a>
                                    <!--mientras la idea no sea evaluada se podrá eliminar-->
                                    <c:if test = "${idea.itemCatalogoByEstado.id == 7}">
                                        <a title="editar" class="btn-sm btn-info" href="${pageContext.request.contextPath}/idea/index.htm?us=${us}&id_idea=${idea.id}"> <span class="glyphicon glyphicon-edit"></span>  </a>  
                                        <a title="eliminar" class="btn-sm btn-danger" style="cursor:pointer;" onclick="confirmar(${idea.id},${idea.usuario.id});"><span class="glyphicon glyphicon-remove" ></span></a>
                                        </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
    <script>
        notificar('glyphicon glyphicon-user', 'Login', 'Ingreso satisfactorio', 'pastel-info');

        function confirmar(id, us) {
            var tbl = '<form action="eliminar.htm" method="POST">' +
                    '<input type="hidden" id="us" name="us" value="' + us + '">' +
                    '<input type="hidden" id="id_idea" name="id_idea" value="' + id + '">' +
                    '<button class="btn btn-danger"> <span class="glyphicon glyphicon-remove"> eliminar</span></button>' +
                    '</form>';
            $('#mdl_body').html(tbl);
            $('#mdl_label').html('Confirme que desea eliminar el registro seleccionado');
            $('#mdl_modal').modal('show');
        }
    </script>
</body>
</html>
