<%-- 
    Document   : index
    Created on : 23-ene-2017, 12:15:51
    Author     : TAWSBC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-1.11.2.js"></script>

        <link href="${pageContext.request.contextPath}/recursos/css/jquery-ui.css" rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/moment.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/twix.js"></script>

        <link href="https://code.jquery.com/ui/jquery-ui-git.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/primeui-1.0-min.css" rel="stylesheet"/>
        <script type="text/javascript" src="http:////code.jquery.com/jquery-1.12.3.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-ui.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/primeui-1.0-min.js"></script>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap.min-3.3.4.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/recursos/js/bootstrap.min.js"></script>


        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/util.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input id="busqueda" name="busqueda" class="search form-control" type="search" value="" type="text"  placeholder="Búsqueda de ideas publicadas" style="width: 200%;" />
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
//                $('#mdl_modal').text('');
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
                $('#mdl_modal').modal('show');
            }
        </script>
    </body>
</html>
