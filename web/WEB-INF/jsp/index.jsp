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
        
        <title>Ideas</title>

        <style>
            .favorito {
                color:green;
            }
            .otro{}

            .des{
                cursor:pointer;
            }
            .activo {
                color: green;
            }
        </style>

        <!-- jQuery 3.2.1 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap.min.js"></script>
        <script>
            $.ajax({
                url: 'http://serendipity.utpl.edu.ec/slider-v1/slider?id=10&tipo=responsive',
                type: "get",
                dataType: "json",
                success: function (msg) {
                    document.getElementById("div_carrusel").innerHTML = msg;
                },
                error: function (textStatus) {
                    alert("Error leyendo datos."+textStatus);
                }
            });
        </script>
       
    </head>

    <body>

        <jsp:include page="navbar.jsp"/>
        <!--SECCIÓN DE CARRUSEL-->
        <div class="row">
            <div id="div_carrusel" class="col-md-12"></div>
        </div>
        <!--SECCIÓN DE PATROCINADORES-->  
        <c:if test="${empty nueva}">
            <div id="div_patrocinadores" class="" style="height: 100px;padding:10px;">
                <div class="col-md-6 text-center">
                    <a style="cursor:pointer;" href="http://utpl.edu.ec/" target="_blank"> <img src="${pageContext.request.contextPath}/recursos/img/utpl.png" width="100px;"/> </a> &nbsp;&nbsp;&nbsp;
                    <a style="cursor:pointer;" href="http://smartland.utpl.edu.ec" target="_blank"> <img src="${pageContext.request.contextPath}/recursos/img/smartland.png" width="100px;"/> </a> &nbsp;&nbsp;&nbsp;
                </div>
                <div class="col-md-6">
                    <p>
                        Un sistema para emprendedores a través del cual podrá inscribir su idea de negocio que a su vez le permitirá 
                        contactar con inversionistas que impulsarán el desarrollo de su iniciativa 
                    </p>
                </div>
            </div>
        </c:if>
        <!--SECCIÓN BUSCADOR--> 
        <c:if test="${empty nueva}">
            <div class="" style="width:99%;padding:0px 60px;">
                <input class="easyui-searchbox" data-options="prompt:'Search of resources...',menu:'#types',searcher:busqueda_enter" id="busqueda" name="busqueda" style="width:100%;" autofocus="autofocus">
                <span id="span_esperar" style="margin-top: -10px;display: none;"> 
                    <img src="recursos/img/rueda.gif" width="25px" style="padding-top: -20px;"/> 
                </span>
            </div>
            <div id="types">
                <c:if test="${!empty nombre}">
                    <div data-options="name:'all',iconCls:'icon-ok'">Mis ideas</div>
                </c:if>
                <div data-options="name:'all',iconCls:'icon-ok'">Todas</div>
            </div>
        </c:if>
        <!--SECCIÓN DE CONTENIDO-->
        <div class="easyui-layout" style="height:800px;">
            <c:if test="${empty nueva}">
                <div data-options="region:'north', border:false" >
                    <div id="span_total">

                            <div class="col-md-3">
                                <span style="padding:10px 60px;">Results Found <span class="badge" id="total"></span> </span>
                            </div>
                            <div class="col-md-3">
                                <div class="row" id="download"> </div>
                            </div>
                            <div class="col-md-5 text-right">
                                <div id="pp" class="easyui-pagination" data-options="total:0"></div>
                                <span id="span_page"></span>
                            </div>

                    </div>
                </div>
            </c:if>

            <!--            <div data-options="region:'east',split:true,hideCollapsedContent:false,collapsed:true" title="Twitter" style="width:20%;">
                        </div>-->

            <!--            <div data-options="region:'west',split:true,hideCollapsedContent:false,collapsed:true" title="Ideas filtering" style="width:30%;">
                            <div style="margin:20px 0;">
                                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="collapseAll()">CollapseAll</a>
                                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="expandAll()">ExpandAll</a>
                            </div>
                            <div class="easyui-panel" style="padding:5px">
                                <ul id="tt" class="easyui-tree" 
                                    data-options="url:'idea/items.htm',
                                    method:'get',animate:true,idField: 'id',treeField: 'text',
                                    lines:true,
                                    formatter:function(node){
                                    var s = node.text;
                                    s += '&nbsp;<span style=\'color:blue\'>(' + node.contador + ')</span>';
                                    return s;
                                    },
                                    onClick:function(node){
                                    var ids = callWS('get_ids.htm','GET','JSON',{id:node.id});
                                    id_tag = ids.join();
                                    nombre_tag = node.text;
                                    buscar(true, page, rows, 'results', true);
                                    }
                                    "></ul>
                            </div>
                        </div>-->
            <div data-options="region:'center',title:'Ideas',iconCls:'icon-ok'" style="height:1000px;">

                <div class="" id="results" style="padding: 5px;">
                    <c:if test="${nueva == 'true' && opcion == '1'}">
                        <form:form action="guardar.htm" modelAttribute="idea"  method="POST" enctype="multipart/form-data">
                            <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                            <input type="hidden" id="id_us" name="id_us" value="${us}">
                            <input type="hidden" id="opcion" name="opcion" value="1">
                            <input type="hidden" id="tipo_adjunto" name="tipo_adjunto" >

                            <div class="thumbnail">
                                <p  style="padding-left: 10px; "><span class="badge">1</span> <strong>Datos Generales</strong></p>  
                                <table class="table" style="width: 100%;">
                                    <tr>
                                        <td style="width: 15%;"> <label for="conv">Grupo</label> </td>
                                        <td style="width: 85%;" colspan="3"> 
                                            <select id="conv" name="conv" class="bg-info" style="size:50px;" required>
                                                <option value="" selected>---</option>
                                                <c:forEach items="${convocatorias}" var="item">
                                                    <c:if test = "${item.id == idea.convocatoria.id}">
                                                        <option value="${item.id}" selected="selected">${item.nombre}</option>
                                                    </c:if>
                                                    <c:if test = "${item.id != idea.convocatoria.id}">
                                                        <option value="${item.id}">${item.nombre}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select> *
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> <label for="nombre">Título</label> </td>
                                        <td style="width: 85%;" colspan="3"> <input type="text" id="nombre" name="nombre" value="${idea.nombre}" style="width: 98%;" required> *</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> <label>Imagen identificativa</label> </td>
                                        <td style="width: 35%;" colspan="3"> 
                                            <input type="file" name="imagen" id="imagen" path="imagen"/>
                                            <c:if test = "${!empty idea.imagen}">
                                                <div>
                                                    <a style="cursor:pointer" onclick="eliminar_archivo(this,${idea.id}, '${idea.imagen}', 1);"><span class="glyphicon glyphicon-remove"></span></a> <a href="${pageContext.request.contextPath}/bancoideas/${idea.imagen}" target="_blank">${idea.imagen}</a>
                                                </div>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> <label for="descripcion">Descripción</label> </td>
                                        <td style="width: 85%;" colspan="3"> <input type="text" id="descripcion" name="descripcion" value="${idea.descripcion}" style="width: 98%;" required> *</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> <label for="lugar">Lugar de origen de la idea</label> </td>
                                        <td style="width: 85%;" colspan="3"> <input type="text" id="lugar" name="lugar" value="${idea.lugar}" style="width: 98%;" required> *</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> <label for="kw">Palabras clave</label> </td>
                                        <td style="width: 85%;" colspan="3"> <input type="text" id="kw" name="kw" value="${idea.kw}" data-role="tagsinput" placeholder="Ingrese palabras clave" style="width: 100% !important;" required> *</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 15%;"> 
                                            <label>Adjuntos</label> 
                                            <select id="cmb_adjunto" onChange="$('#tipo_adjunto').val($('#cmb_adjunto').val())">
                                                <c:forEach items="${tipos_adjuntos}" var="item">
                                                    <option value="${item.id}">${item.nombre}</option>
                                                </c:forEach>
                                            </select> 
                                            <a id="Agregar" style="cursor:pointer;" class="btn btn-xs btn-info" onclick="nuevo_elemento($('#cmb_adjunto').val());">Nuevo <span class="glyphicon glyphicon-plus"></span></a>
                                        </td>
                                        <td style="width: 85%;" colspan="3"> 
                                            <table id="fileTable" class="table table-striped table-condensed">
                                                <tr>
                                                    <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Archivo: </label> </td>
                                                    <td style="width: 85%;"> <input type="file" name="adjuntos[0]" /> </td>
                                                </tr>
                                            </table>

                                            <table id="youtubeTable" class="table table-striped table-condensed">
                                                <tr>
                                                    <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Youtube: </label> </td>
                                                    <td style="width: 85%;"> <input type="url" id="youtube" name="youtube[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.youtube.com"> </td>
                                                </tr>
                                            </table>
                                            <table id="twitterTable" class="table table-striped table-condensed">
                                                <tr>
                                                    <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Twitter: </label> </td>
                                                    <td style="width: 85%;"> <input type="url" id="twitter" name="twitter[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.twitter.com"> </td>
                                                </tr>
                                            </table>
                                            <table id="facebookTable" class="table table-striped table-condensed">
                                                <tr>
                                                    <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Facebook:</label> </td>
                                                    <td style="width: 85%;"> <input type="url" id="facebook" name="facebook[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.facebook.com"> </td>
                                                </tr>
                                            </table>

                                            <c:forEach items="${adjuntos}" var="adjunto" varStatus="cont">
                                                <div>
                                                    <c:if test="${adjunto.itemCatalogo.id == 43}" >
                                                        [ ${cont.index} ] : <a style="cursor:pointer" onclick="eliminar_archivo(this,${adjunto.id}, '${adjunto.nombre}', 2)"><span class="glyphicon glyphicon-remove"></span></a> <a href="${pageContext.request.contextPath}/bancoideas/${adjunto.nombre}" target="_blank">${adjunto.nombre}</a>
                                                        </c:if>
                                                        <c:if test="${adjunto.itemCatalogo.id != 43}" >
                                                        [ ${cont.index} ] :  <span><a href="${adjunto.nombre}" target="_blank"> ${adjunto.nombre}</span>
                                                    </c:if>
                                                </div>
                                                <br>
                                            </c:forEach>

                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <br>
                            <div align="center">
                                <button id="btn_guardar" class="btn btn-primary" type="submit"> <span class="glyphicon glyphicon-ok"></span> Guardar</button><br><br>
                            </div>
                        </form:form> 
                    </c:if>

                    <!--para listar ideas del usuario--> 
                    <c:if test = "${ideas != null}">

                            <c:forEach items="${ideas}" var="idea">
                                <div class="col-md-4">
                                    <div class="thumbnail" style="min-height: 250px; max-height: 250px; position:relative;">
                                        <div class="bg-primary" style="height: 18px; padding-left: 10px; font-size: 12px; ">
                                            <label>${idea.nombre}</label> 
                                        </div>
                                        <table>
                                            <tr>
                                                <td> <div style="min-height: 90px;"> <img src="${pageContext.request.contextPath}/bancoideas/${idea.imagen}" style="width: 100%; height: 150px;" /> </div> </td>
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
                                                    <a title="editar" class="btn-sm btn-info" href="${pageContext.request.contextPath}/idea_index.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}"> <span class="glyphicon glyphicon-pencil"></span>  </a>  
                                                    <a title="eliminar" class="btn-sm btn-danger" style="cursor:pointer;" onclick="confirmar(${idea.id},${idea.usuario.id});"><span class="glyphicon glyphicon-remove" ></span></a>
                                                    </c:if>
                                                    <c:if test = "${idea.itemCatalogoByEstado.id == 7 && evaluador == true}">
                                                    <a title="evaluar" class="btn-sm btn-success" style="cursor:pointer;" onclick="confirmar_evaluar(${idea.id},${idea.usuario.id});"> <span class="glyphicon glyphicon-ok"></span>  </a>  
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        <script>
                            generarPaginacion(${fn:length(ideas)}, 1, 10);
                        </script>
                    </c:if>

                    <c:if test="${nueva == 'true' && opcion == '2'}">
                        <!--<a class="btn btn-primary pull-right" href="listar.htm"> <span class="glyphicon glyphicon-list"></span> Listar Ideas </a>-->
                        <div class="" >
                            <div class="col-md-4">
                                <table class="table table-striped table-bordered table-condensed">
                                    <tr>
                                        <td> 
                                            <c:if test = "${idea.id == null}">
                                                <a href="idea_index.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">1</span> Información de la Idea</a> 
                                            </c:if>
                                            <c:if test = "${idea.id != null}">
                                                <a href="idea_index.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">1</span> Información de la Idea <span class="glyphicon glyphicon-ok pull-right"></span> </a> 
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <c:if test = "${idea.id == null}">
                                                <a href="participante.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:not-allowed;pointer-events: none;"> <span class="badge">2</span>  Participantes</a> 
                                            </c:if>
                                            <c:if test = "${idea.id != null}">
                                                <c:if test = "${fn:length(participantes) == 0}">
                                                    <a href="participante.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">2</span>  Participantes</a> 
                                                </c:if>
                                                <c:if test = "${fn:length(participantes) > 0}">
                                                    <a href="participante.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">2</span>  Participantes <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                                    </c:if>
                                                </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> 
                                            <c:if test = "${idea.id == null}">
                                                <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:not-allowed;pointer-events: none;"> <span class="badge">3</span> Estado de la idea</a> 
                                            </c:if>
                                            <c:if test = "${idea.id != null}">
                                                <c:if test = "${idea.itemCatalogoByEstadoGestacion == null}">
                                                    <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">3</span> Estado de la idea</a> 
                                                </c:if>
                                                <c:if test = "${idea.itemCatalogoByEstadoGestacion != null}">
                                                    <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"> <span class="badge">3</span> Estado de la idea <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                                    </c:if>
                                                </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> 
                                            <c:if test = "${idea.id == null}">
                                                <a href="publicar.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:not-allowed;pointer-events: none;"><span class="badge">4</span> Finalizar</a> 
                                            </c:if>
                                            <c:if test = "${idea.id != null}">
                                                <c:if test = "${idea.publicar == false}">
                                                    <a href="publicar.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;"><span class="badge">4</span> Finalizar</a> 
                                                </c:if>
                                                <c:if test = "${idea.publicar == true}">
                                                    <a href="publicar.htm?us=${us}&id_idea=${idea.id}&nueva=true&opcion=${idea.tipoIdea}" style="cursor:pointer;" ><span class="badge">4</span> Finalizar <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                                    </c:if>
                                                </c:if>
                                        </td>
                                    </tr>
                                </table>
                            </div>

                            <div class="col-md-7">
                                <c:if test = "${fase == 'idea'}">
                                    <form:form action="guardar.htm" modelAttribute="idea"  method="POST" enctype="multipart/form-data">
                                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                                        <input type="hidden" id="id_us" name="id_us" value="${us}">
                                        <input type="hidden" id="opcion" name="opcion" value="2">
                                        <input type="hidden" id="tipo_adjunto" name="tipo_adjunto" >

                                        <div class="thumbnail">
                                            <p style="padding-left: 10px;"><span class="badge">1</span> <strong>Datos Generales</strong></p>  
                                            <table class="table">
                                                <tr>
                                                    <td style="width: 15%;"> <label for="conv">Grupo</label> </td>
                                                    <td style="width: 85%;" colspan="3"> 
                                                        <select id="conv" name="conv" class="bg-info" style="size:50px;" required>
                                                            <option value="" selected>---</option>
                                                            <c:forEach items="${convocatorias}" var="item">
                                                                <c:if test = "${item.id == idea.convocatoria.id}">
                                                                    <option value="${item.id}" selected="selected">${item.nombre}</option>
                                                                </c:if>
                                                                <c:if test = "${item.id != idea.convocatoria.id}">
                                                                    <option value="${item.id}">${item.nombre}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select> *
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="nombre">Título</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="nombre" name="nombre" value="${idea.nombre}" style="width: 98%;" required> *</td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="tipo">Tipo de idea</label> </td>
                                                    <td style="width: 35%;"> 
                                                        <select id="tipo" name="tipo" class="bg-info" style="size:50px;" required>
                                                            <option value="" selected>---</option>
                                                            <c:forEach items="${tipos}" var="item">
                                                                <c:if test = "${item.id == idea.itemCatalogoByTipo.id}">
                                                                    <option selected value="${item.id}">${item.nombre}</option>
                                                                </c:if>
                                                                <c:if test = "${item.id != idea.itemCatalogoByTipo.id}">
                                                                    <option value="${item.id}">${item.nombre}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select> *
                                                    </td>
                                                    <td style="width: 15%;"> <label>Imagen identificativa</label> </td>
                                                    <td style="width: 35%;"> 
                                                        <input type="file" name="imagen" id="imagen" path="imagen"/>
                                                        <c:if test = "${!empty idea.imagen}">
                                                            <div>
                                                                <a style="cursor:pointer" onclick="eliminar_archivo(this,${idea.id}, '${idea.imagen}', 1);"><span class="glyphicon glyphicon-remove"></span></a> <a href="${pageContext.request.contextPath}/bancoideas/${idea.imagen}" target="_blank">${idea.imagen}</a>
                                                            </div>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="descripcion">Descripción</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="descripcion" name="descripcion" value="${idea.descripcion}" style="width: 98%;" required> *</td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="objetivo">Objetivo</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="objetivo" name="objetivo" value="${idea.objetivo}" style="width: 98%;" required> *</td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="mercado">Mercado Potencial</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="mercado" name="mercado" value="${idea.mercadoPotencial}" style="width: 98%;" > </td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="lugar">Lugar de origen de la idea</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="lugar" name="lugar" value="${idea.lugar}" style="width: 98%;" required> *</td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="kw">Palabras clave</label> </td>
                                                    <td style="width: 85%;" colspan="3"> <input type="text" id="kw" name="kw" value="${idea.kw}" data-role="tagsinput" placeholder="Ingrese palabras clave" style="width: 100% !important;" required> *</td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> <label for="ciiu">Clasificación CIIU</label> </td>
                                                    <td style="width: 85%;" colspan="3"> 
                                                        <input id="ciiu" name="ciiu" value='${idea.ciiu.nombre}'
                                                               class="easyui-tagbox" label="" style="width:100%" data-options="
                                                               url: '${pageContext.request.contextPath}/listitem.htm',
                                                               method: 'get',
                                                               value: '${idea.ciiu.id}',
                                                               valueField: 'id',
                                                               textField: 'nombre',
                                                               limitToList: true,
                                                               hasDownArrow: true,
                                                               multiple: false, 
                                                               maximumSelectionSize: 1,
                                                               prompt: 'Seleccione una clasificación'
                                                               " />
                                                        <!--<input id="ciiu" name="ciiu" type="text" class="form-control" style="width: 100% !important;" data-role="tagsinput" value="" placeholder="Ingrese categoría ciiu" />-->
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="width: 15%;"> 
                                                        <label>Adjuntos</label> 
                                                        <select id="cmb_adjunto" onChange="$('#tipo_adjunto').val($('#cmb_adjunto').val())">
                                                            <c:forEach items="${tipos_adjuntos}" var="item">
                                                                <option value="${item.id}">${item.nombre}</option>
                                                            </c:forEach>
                                                        </select> 
                                                        <a id="Agregar" style="cursor:pointer;" class="btn btn-xs btn-info" onclick="nuevo_elemento($('#cmb_adjunto').val());"><span class="glyphicon glyphicon-plus"></span></a>
                                                    </td>
                                                    <td style="width: 85%;" colspan="3"> 
                                                        <table id="fileTable" class="table table-striped table-condensed">
                                                            <tr>
                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Archivo: </label> </td>
                                                                <td style="width: 85%;"> <input type="file" name="adjuntos[0]" /> </td>
                                                            </tr>
                                                        </table>

                                                        <table id="youtubeTable" class="table table-striped table-condensed">
                                                            <tr>
                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Youtube: </label> </td>
                                                                <td style="width: 85%;"> <input type="url" id="youtube" name="youtube[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.youtube.com"> </td>
                                                            </tr>
                                                        </table>

                                                        <table id="twitterTable" class="table table-striped table-condensed">
                                                            <tr>
                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Twitter: </label> </td>
                                                                <td style="width: 85%;"> <input type="url" id="twitter" name="twitter[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.twitter.com"> </td>
                                                            </tr>
                                                        </table>

                                                        <table id="facebookTable" class="table table-striped table-condensed">
                                                            <tr>
                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Facebook:</label> </td>
                                                                <td style="width: 85%;"> <input type="url" id="facebook" name="facebook[0]" style="width: 100%; margin-top: -5px;" placeholder="http://www.facebook.com"> </td>
                                                            </tr>
                                                        </table>

                                                        <c:forEach items="${adjuntos}" var="adjunto" varStatus="cont">
                                                            <div>
                                                                <c:if test="${adjunto.itemCatalogo.id == 43}" >
                                                                    [ ${cont.index} ] : <a style="cursor:pointer" onclick="eliminar_archivo(this,${adjunto.id}, '${adjunto.nombre}', 2)"><span class="glyphicon glyphicon-remove"></span></a> <a href="${pageContext.request.contextPath}/bancoideas/${adjunto.nombre}" target="_blank">${adjunto.nombre}</a>
                                                                    </c:if>
                                                                    <c:if test="${adjunto.itemCatalogo.id != 43}" >
                                                                    [ ${cont.index} ] :  <span><a href="${adjunto.nombre}" target="_blank"> ${adjunto.nombre}</span>
                                                                </c:if>
                                                            </div>
                                                            <br>
                                                        </c:forEach>

                                                    </td>

                                                </tr>
                                            </table>
                                            <!--                                            <label class="label label-success" style="margin-left: 10px; padding-left: 10px;">Social media</label>  
                                                                                        <br><br>
                                                                                        <table class="table">
                                                                                            <tr>
                                                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Link facebook</label> </td>
                                                                                                <td style="width: 85%;"> <input type="text" id="facebook" name="facebook" value="${idea.facebook}" style="width: 100%; margin-top: -5px;" placeholder="http://www.facebook.com"> </td>
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Link twitter</label> </td>
                                                                                                <td style="width: 85%;"> <input type="text" id="twitter" name="twitter" value="${idea.twitter}" style="width: 100%; margin-top: -5px;" placeholder="http://www.twitter.com"> </td>
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">Link youtube</label> </td>
                                                                                                <td style="width: 85%;"> <input type="text" id="youtube" name="youtube" value="${idea.youtube}" style="width: 100%; margin-top: -5px;" placeholder="http://www.youtube.com"> </td>
                                                                                            </tr>
                                                                                        </table>-->
                                        </div>
                                        <br>
                                        <div align="center">
                                            <button id="btn_guardar" class="btn btn-primary" type="submit"> <span class="glyphicon glyphicon-ok"></span> Guardar</button><br><br>
                                        </div>
                                    </form:form> 
                                </c:if>

                                <c:if test = "${fase == 'participante'}">
                                    <p style="padding-left: 10px;"><span class="badge">2 </span> <strong>Miembros integrantes de la idea</strong></p>  
                                    <form action="agregarParticipante.htm" method="POST">
                                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                                        <table class="table" style="width: 100%;">
                                            <tr>
                                                <td colspan="2"> 
                                                    Buscar por:
                                                    <input type="radio" name="participante" value="id"> Identificación
                                                    <input type="radio" name="participante" value="us"> Username
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td colspan="2"> 
                                                    <input type="valorBusqueda" name="valorBusqueda" type="text">
                                                    <button type="button" class="btn btn-primary" onclick="getInfoPersona(valorBusqueda.value, participante.value);"> <span class="glyphicon glyphicon-search"></span> buscar</button>
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td colspan="2">
                                                    <div id="div_participante">
                                                        Nombre: <span id="span_nombre"></span>
                                                        <input type="hidden" id="pnombre" name="pnombre">
                                                        <input type="hidden" id="pidentificacion" name="pidentificacion" >
                                                    </div>
                                                </td> 
                                            </tr> 
                                            <tr>
                                                <td style="width: 15%;"> <label for="funcion">Función:</label> </td>
                                                <td style="width: 85%;"> 
                                                    <select id="funcion" name="funcion" class="bg-info" style="size:50px;" required>
                                                        <c:forEach items="${funcion}" var="item">
                                                            <option value="${item.id}">${item.nombre}</option>
                                                        </c:forEach>
                                                        <option value="" selected>---</option>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                        <button class="btn btn-primary" id="btn_agregar"> <span class="glyphicon glyphicon-plus"></span> Agregar</button>
                                        <script>
                                            document.getElementById("btn_agregar").disabled = true;
                                        </script>
                                    </form>
                                    <table class="table" style="width: 100%;">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Participante</th>
                                                <th>Función</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${participantes}" var="item">
                                                <tr>
                                                    <td><a onclick="$('#id_part').val(${item.id});
                                                            $('#frm_ep').submit();" style="cursor:pointer;"><span class="glyphicon glyphicon-remove"></span></a></td>
                                                    <td>${item.nombre}</td>
                                                    <td>${item.itemCatalogo.nombre}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <form id="frm_ep" action="eliminarParticipante.htm" method="POST">
                                        <input type="hidden" id="id_part" name="id_part">
                                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                                        <input type="hidden" id="us" name="us" value="${us}">
                                    </form>
                                </c:if>

                                <c:if test = "${fase == 'estadogestacion'}">
                                    <p style="padding-left: 10px;"><span class="badge">3</span> <strong>Estado de Gestación de la Idea</strong></p>  
                                    <form action="estadogestacion.htm" method="POST">
                                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                                        <table class="table" style="width: 100%;">
                                            <tr>
                                                <td style="width: 15%;"> <label for="area">Estado</label> </td>
                                                <td style="width: 85%;"> 
                                                    <select id="eg" name="eg" class="bg-info" style="size:50px;" required>
                                                        <option value="" selected>---</option>
                                                        <c:forEach items="${estadosgestacion}" var="item">
                                                            <c:if test = "${item.id == idea.itemCatalogoByEstadoGestacion.id}">
                                                                <option selected value="${item.id}">${item.nombre}</option>
                                                            </c:if>
                                                            <c:if test = "${item.id != idea.itemCatalogoByEstadoGestacion.id}">
                                                                <option value="${item.id}">${item.nombre}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select> *
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td style="width: 15%;"> <label for="estadoComentario">Comentario</label> </td>
                                                <td style="width: 85%;"> <input type="text" id="estadoComentario" name="estadoComentario" value="${item.estadoComentario}" style="width: 100%; margin-top: -5px;">
                                            </tr>   
                                        </table>
                                            <button class="btn btn-primary" > <span class="glyphicon glyphicon-save"></span> Guardar</button><br><br>
                                    </form>
                                </c:if>

                                <c:if test = "${fase == 'publicacion'}">
                                    <p style="padding-left: 10px;"><span class="badge">4</span> <strong>Finalización de la idea</strong></p>  
                                    <form action="publicar.htm" method="POST">
                                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                                        Al finalizar la idea, podrá ser evaluada por el agente evaluador.
                                        <br><br>
                                        <c:if test = "${idea.publicar == false}">
                                            <button class="btn btn-primary" > <span class="glyphicon glyphicon-ok"></span> Finalizar </button>
                                        </c:if>
                                        <c:if test = "${idea.publicar == true}">
                                            <label class="bg-success">Finalización exitosa</label>
                                        </c:if>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="row" style="height: 30px; background: #fafafa;"></div>
        <footer style="border-top:5px solid #ff9100;">
            <div class="row">
                <div class="col-md-3 text-center center-block">
                    <!--SECCIÓN DE PATROCINADORES-->
                    <a style="cursor:pointer;" href="http://utpl.edu.ec/" target="_blank"> <img src="${pageContext.request.contextPath}/recursos/img/utpl.png" width="100px;"/> </a> 
                </div>
                <div class="col-md-5">
                    <p class="text-justify">© 2017 Except where otherwise noted, content on this site is licensed under a <a href="https://creativecommons.org/licenses/by/4.0/" target="_blank">Creative Commons Attribution 4.0 International license</a>. Icons by The <a href="https://serendipity.utpl.edu.ec" target="_blank">Serendpity</a> Project.</p>
                </div>
                <div class="col-md-2"></div>

                <div class="col-md-2 text-center center-block">
                    <div style="margin-top:10px;">
                        © Innovation 
                    </div> 

                </div>
            </div>    
        </footer>    
        <!-- Modal  -->
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

        <div class="modal fade" id="mdl_login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <label class="">Ingreso con usuario y clave de EVA</label>
                    </div>
                    <div class="modal-body">
                        <div align="center">
                            <form:form action="${pageContext.request.contextPath}/auth.htm" modelAttribute="login" method="POST">  
                                <form:input type="text" path="username" autocomplete="true" placeholder="usuario" required=""  style="padding-top:5px;"/>
                                <br>
                                <form:input type="password" path="password" placeholder="contraseña" required="" />
                                <br><br>
                                <button class="btn btn-sm btn-primary"><strong>Ingresar</strong> <span class="glyphicon glyphicon-log-in"></span> </button> 
                                <hr>
                                <!--<a href="#" style="color:white;" class="btn btn-sm btn-info" data-toggle="modal" data-target="#mdl_register">Register</a>-->
                                <div class="pull-right" style="margin-top: -12px; margin-bottom: -19px;">
                                    <c:if test="${mensaje != null}">
                                        <script>
                                            notificar('glyphicon glyphicon-user', 'Login', 'Ingreso incorrecto', 'pastel-danger');
                                        </script>
                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <p style="font-size: 12px; padding-right: 15px;">${mensaje}</p>
                                        </div>
                                    </c:if>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal opción -->
        <div id="mdl_opcion" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <label>Tipo de Idea</label>
                        <p>Fase 1: para registrar ideas de reciente creación</p>
                        <p>Fase 2: para registrar ideas consolidadas</p>

                    </div>
                    <div class="modal-body">
                        <select id="cmb_opcion" onChange="if ($('#cmb_opcion').val() != 0) {
                                    window.open('idea_index.htm?us=${us}&nueva=true&opcion=' + $('#cmb_opcion').val());
                                }">
                            <option value="0">-----</option>
                            <option value="1">idea fase 1</option>
                            <option value="2">idea fase 2</option>
                        </select> 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
       
             
        <jsp:include page="modal.jsp"/>
        
        
        <jsp:include page="header.jsp"/>
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/easyui/css/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/easyui/css/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/easyui/css/color.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/easyui/css/prettify.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/easyui/js/jquery.easyui.min.js"></script>       
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/easyui/js/prettify.js"></script>
        
        <!--<script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/util.js"></script>-->
        <script>
            function busqueda_enter() {
                if ($('#busqueda').val().trim() != '') {
                    $('#span_esperar').show();
                    $('#span_total').show();
                    buscar(true, page, rows, 'results', false);
                }
            }

            function generarPaginacion(total_resultados, pagina, rows) {
                $('#pp').pagination({
                    total: total_resultados,
                    pageSize: 10,
                    onSelectPage: function (pageNumber, pageSize) {
//                        alert(pageNumber + " - " + pageSize);
//                        $('#pp').panel('refresh', 'show_content.php?page=' + pageNumber);
                    }
                });
            }
            function notificar(icon, title, message, type) {
                $.notify({
                    icon: icon,
                    title: title,
                    message: message
                }, {
                    type: type,
                    delay: 5000,
                    allow_dismiss: true,
                    newest_on_top: true,
                    animate: {
                        enter: 'animated fadeInRight',
                        exit: 'animated fadeOutRight'
                    },
                    template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
                            '<span data-notify="title">{1}</span>' +
                            '<span data-notify="message">{2}</span>' +
                            '</div>'
                });
            }

            function obtenerDetalle(idIdea) {
                var idea = callWS('${pageContext.request.contextPath}/buscarporid.htm', 'GET', 'JSON', {id_idea: parseInt(idIdea)});
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
                        '<a href="${pageContext.request.contextPath}/bancoideas/' + idea.imagen + '" target="_blank" style="float:left;"> <img   height = "50px" width = "100px" src="' + '${pageContext.request.contextPath}/bancoideas/' + idea.imagen + '" > </a>' +
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
//                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> Tipo </td>' +
//                        '<td width="70%">' + idea.itemCatalogoByTipo.nombre + '</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> Estado </td>' +
                        '<td width="70%">' + idea.itemCatalogoByEstado.nombre + '</td>' +
                        '</tr>' +
                        '<tr>' +
//                        '<td class="bg-primary" style="background-color:#003F72; color:white;"> Clasificación CIIU </td>' +
//                        '<td width="70%">' + idea.ciiu.nombre + '</td>' +
                        '</tr>';
//                if (idea.facebook != '' || idea.youtube != '' || idea.twitter != '') {
//                    html += '<tr>' +
//                            '<td colspan="2"> <strong>* MEDIA</strong> </td>' +
//                            '</tr>';
//                }
//                if (idea.facebook != '') {
//                    html += '<tr>' +
//                            '<td class="bg-primary" style="background-color:#003F72; color:white;"> link facebook </td>' +
//                            '<td width="70%"><a href="' + idea.facebook + '" target="_blank">' + idea.facebook + '</a></td>' +
//                            '</tr>';
//                }
//                if (idea.youtube != '') {
//                    html += '<tr>' +
//                            '<td class="bg-primary" style="background-color:#003F72; color:white;"> link youtube </td>' +
//                            '<td width="70%">' + idea.youtube + '</td>' +
//                            '</tr>';
//                }
//                if (idea.twitter != '') {
//                    html += '<tr>' +
//                            '<td class="bg-primary" style="background-color:#003F72; color:white;"> link twitter</td>' +
//                            '<td width="70%">' + idea.twitter + '</td>' +
//                            '</tr>';
//                }
                '</tbody>' +
                        '</table>';
                $('#mdl_body').append(html);
//            $('#mdl_modal').modal('show');
                $('#mdl_modal').modal('show');
            }

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

            function confirmar_evaluar(idea) {
                var tbl = '<form action="evaluar.htm" method="POST">' +
                        '<input type="hidden" id="us" name="us" value="' + ${us} + '">' +
                        '<input type="hidden" id="id_idea" name="id_idea" value="' + idea + '">' +
                        '<table class="table table-condensed table-striped">' +
                        '<tr>' +
                        '<td>Comentario</td><td><textarea id="comentario" name="comentario" style="width:100%;"></textarea></td>' +
                        '</tr>' +
                        '</table>' +
                        '<button class="btn btn-success"> <span class="glyphicon glyphicon-ok"> Aceptar</span></button>' +
                        '</form>';
                $('#mdl_body').html(tbl);
                $('#mdl_label').html('Confirme que desea evaluar la idea seleccionada');
                $('#mdl_modal').modal('show');
            }
//            function eliminar_confirmar(id, nombre, op) {
//                var tbl = '<form action="eliminar.htm" method="POST">' +
//                        '<input type="hidden" id="us" name="us" value="' + us + '">' +
//                        '<input type="hidden" id="id_idea" name="id_idea" value="' + id + '">' +
//                        '<button class="btn btn-danger"> <span class="glyphicon glyphicon-remove"> eliminar</span></button>' +
//                        '</form>';
//                $('#mdl_body').html(tbl);
//                $('#mdl_label').html('Confirme que desea eliminar el registro seleccionado');
//                $('#mdl_modal').modal('show');
//            }
        </script>

        <script>
                            function callWS(url, type, dataType, data) {
                                var resultado = '';
                                $.ajax({
                                    url: url,
                                    type: type,
                                    dataType: dataType,
                                    contentType: "json",
                                    data: data,
                                    async: false,
                                    success: function (data) {
                                        resultado = data;
                                    },
                                    error: function (e, msg) {
                                        console.log(msg + ' en ws ' + url);
                                    }
                                });
                                return resultado;
                            }
                            function eliminar_archivo(elemento, id, nombre, op) {
                                if (nombre != 'utpl.png') {//para no eliminar la imagen por defecto
                                    callWS('removefile.htm', 'GET', 'JSON', {nombre: nombre});
                                }
                                if (op == 1) { //eliminar imagen
                                    callWS('eliminar_imagen.htm', 'GET', 'JSON', {id_idea: id});
                                } else if (op == 2) { // eliminar adjuntos
                                    callWS('eliminar_adjunto.htm', 'GET', 'JSON', {id_adjunto: id});
                                }
                                elemento.parentNode.remove();
                                alert('Archivo removido');
                            }

                            function nuevo_elemento(opcion) {
                                var tabla = '';
                                var type = 'url';
                                var name = 'adjuntos';
                                if (opcion == 43) {
                                    tabla = 'fileTable';
                                    type = 'file';
                                } else if (opcion == 44) {
                                    tabla = 'youtubeTable';
                                    name = 'youtube';
                                } else if (opcion == 45) {
                                    tabla = 'twitterTable';
                                    name = 'twitter';
                                } else if (opcion == 46) {
                                    tabla = 'facebookTable';
                                    name = 'facebook';
                                }
//                alert($('#fileTable tr').children().length);
                                var pos = $('#' + tabla + ' tr').children().length - 1;
                                $('#' + tabla).append(
                                        '<tr>' +
                                        '<td style="width: 15%;"> <label class="label label-default" style="margin-top: 10px;">' + name + '</label> </td>' +
                                        '<td style="width: 85%;"> <input type="' + type + '"  + name="' + name + '[' + pos + '] " /> </td>' +
                                        '</tr>');
                            }

                            $(document).ready(function () {
                                $('#span_esperar').hide();
                                if (usr == -1) {
                                    //cargar();
                                    console.log('cargar');
                                }
                            });
                            

                            var page = 1;
                            var rows = 12;
                            var modal_activo = false;
                            var init_tag = false;
                            var rec = -1;
                            var usr = -1;
                            var src = String(window.location.href).split('?')[1];
                            if (src != undefined) {
                                var vrs = src.split('&');
                                for (var x = 0, c = vrs.length; x < c; x++) {
                                    var parametro = String(vrs[x]).split('=');
                                    if (parametro[0] == 'us') {
                                        usr = parametro[1];
                                        $('#usr').val(usr);
                                    }
                                    if (parametro[0] == 'id') {
                                        console.log('parametro obtenido en id =  ' + parametro[1]);
                                        rec = parametro[1];
                                    }
                                }
                            }

                            $(function () {
                                var themes = [
                                    {value: 'default', text: 'Default', group: 'Base'},
                                    {value: 'gray', text: 'Gray', group: 'Base'},
                                    {value: 'metro', text: 'Metro', group: 'Base'},
                                    {value: 'material', text: 'Material', group: 'Base'},
                                    {value: 'bootstrap', text: 'Bootstrap', group: 'Base'},
                                    {value: 'black', text: 'Black', group: 'Base'},
                                    {value: 'metro-blue', text: 'Metro Blue', group: 'Metro'},
                                    {value: 'metro-gray', text: 'Metro Gray', group: 'Metro'},
                                    {value: 'metro-green', text: 'Metro Green', group: 'Metro'},
                                    {value: 'metro-orange', text: 'Metro Orange', group: 'Metro'},
                                    {value: 'metro-red', text: 'Metro Red', group: 'Metro'},
                                    {value: 'ui-cupertino', text: 'Cupertino', group: 'UI'},
                                    {value: 'ui-dark-hive', text: 'Dark Hive', group: 'UI'},
                                    {value: 'ui-pepper-grinder', text: 'Pepper Grinder', group: 'UI'},
                                    {value: 'ui-sunny', text: 'Sunny', group: 'UI'}
                                ];
                                $('#demo').panel();
                                $('#cb-theme').combobox({
                                    groupField: 'group',
                                    data: themes,
                                    editable: false,
                                    panelHeight: 'auto',
                                    onChange: onChangeTheme,
                                    onLoadSuccess: function () {
                                        $(this).combobox('setValue', 'gray'); //gray
                                    }
                                });
                                var dp = $('#demo').offset();
                                if ($('#ck-rtl').is(':checked')) {
                                    $('body').addClass('demo-rtl');
                                }
                                $('#setting').bind('click', function (e) {
                                    e.stopPropagation();
                                });
                            });
                            function onLoad(data) {
                                data = data.replace(/(\r\n|\r|\n)/g, '\n');
                                data = data.replace(/\t/g, '    ');
                                $('#code').html('<pre name="code" class="prettyprint linenums" style="border:0"></pre>');
                                $('#code').find('pre').text(data);
                                prettyPrint();
                            }
                            function onChangeTheme(theme) {
                                var link = $('#styles').find('link:first'); //content
                                link.attr('href', 'http://www.jeasyui.com/easyui/themes/' + theme + '/easyui.css');
                            }
                            var currPlugin = 'Application';
                            var currPageItem = 'Basic CRUD';
                            function open1(url, a) {
                                currPageItem = $(a).text();
                                $('body>div.menu-top').menu('destroy');
                                $('body>div.window>div.window-body').window('destroy');
                                $('#demo').panel('refresh', url);
                            }
                            function open2(plugin) {
                                if (plugin) {
                                    currPlugin = plugin;
                                    currPageItem = '';
                                }
                                var href = '?plugin=' + currPlugin + '&theme=' + $('#cb-theme').combobox('getValue');
                                href += '&dir=' + ($('#ck-rtl').is(':checked') ? 'rtl' : 'ltr');
                                href += '&pitem=' + currPageItem;
                                href += '&sort=';
                                location.href = href;
                            }

                            function collapseAll() {
                                $('#tt').tree('collapseAll');
                            }
                            function expandAll() {
                                $('#tt').tree('expandAll');
                            }
                            function expandTo() {
                                var node = $('#tt').tree('find', 113);
                                $('#tt').tree('expandTo', node.target).tree('select', node.target);
                            }
                            function getSelected() {
                                var node = $('#tt').tree('getSelected');
                                if (node) {
                                    var s = node.text;
                                    if (node.attributes) {
                                        s += "," + node.attributes.p1 + "," + node.attributes.p2;
                                    }
//                    alert(s);
                                }
                            }

                            //social
//            $('#categoria').tagsinput({
//                tagClass: "badge badge-default",
//                typeahead: {
//                    source: function (query) {
//                        var result = new Array();
//                        var categorias = callWS('${pageContext.request.contextPath}/listitem.htm', 'GET', 'JSON', {term: query});
//                        $.each(categorias, function (i, item) {
//                            result.push(item.nombre);
//                        });
//                        return result;
//                    }
//                }
//            });
//            $('#hashtag').tagsinput({
//                tagClass: "badge badge-default",
//                typeahead: {
//                    source: function (query) {
//                        var result = new Array();
//                        var categorias = callWS('${pageContext.request.contextPath}/listitem.htm', 'GET', 'JSON', {term: query});
//                        $.each(categorias, function (i, item) {
//                            result.push(item.nombre);
//                        });
//                        return result;
//                    }
//                }
//            });
//            $("#categoria").change(function (event) {
//                if ($("#categoria").val().trim() != '') {
//                    var categorias = $("#categoria").val().split(',');
//                    agregarTag(categorias[categorias.length - 1], true); // se envía el último tag ingresado
//                }
//            });
//            $('#txtComment').on('keypress', function (e) {
//                if (e.which === 13) {
//                    if ($('#txtComment').val().trim() != '') {
//                        agregarComment($("#txtComment").val().trim()); // se envía el último tag ingresado
//                    }
//                }
//            });
//            function agregarTag(tag, agregar) {
//                $('#categoria').tagsinput('add', tag);
//                if (agregar && !init_tag) {
//
//                    var item = {
//                        nombre: tag
//                    }
//                    var it = callWS('${pageContext.request.contextPath}/categorianueva.htm', 'POST', 'JSON', JSON.stringify(item));
//                    var anotacion = {
//                        recurso: rec,
//                        usuario: {
//                            id: usr
//                        },
//                        item: it
//                    }
//                    var anotacion = callWS('${pageContext.request.contextPath}/anotacionnueva.htm', 'POST', 'JSON', JSON.stringify(anotacion));
//                    send_websocket(rec, 'tag', true);
//                    count_tags(modal_activo);
//                    actualizar_tag(true);
//                }
//            }
//
//            function eliminarTag(tag) {
//                var eliminar = callWS('${pageContext.request.contextPath}/eliminaranotacion.htm', 'GET', 'JSON', {usr: usr, rec: rec, tag: tag});
//                count_tags(modal_activo);
//                actualizar_tag(false);
//                send_websocket(rec, 'tag', false);
//            }

//            function agregarComment(comment) {
//                var comentario = {
//                    recurso: rec,
//                    usuario: {
//                        id: usr
//                    },
//                    comentario: comment
//                }
//                var comentario = callWS('${pageContext.request.contextPath}/comentarionuevo.htm', 'POST', 'JSON', JSON.stringify(comentario));
//                send_websocket(rec, 'comment', true);
//                $('#tbl_comments').append('<tr><td> <span class="glyphicon glyphicon-user"></span> <label class="label label-sm label-primary">' + comentario.usuario.nombre + '</label> ' + comentario.comentario + '</td></tr>');
//            }

                            var page = 1;
                            var rows = 12;
                            var modal_activo = false;
                            function buscar(issearch, page, rows, div, bytag) {
                                $('#' + div).text('');
                                var q = $('#busqueda').val().trim();
                                var results = '';
                                var url = '';
                                var data = {cadena: q};
                                var results = callWS('${pageContext.request.contextPath}/buscar.htm', 'GET', 'JSON', data)
                                $('#total').html(results.results);
                                if (issearch) {
                                    $('#span_page').text('');
                                    generarPaginacion(results.length, page, rows);
                                }
                                $('#span_esperar').hide();
                                $.each(results, function (i, item) {
                                    construir_resultado(div, item, false);
                                });
                                //                if (results.length > 0) {
                                //                    //generamos descarga de resultados
                                //                    crear_tabla('download');
                                //                    cargar_data(q, url, data);
                                //                }
                                //
                                //                if (item != undefined) {
                                //                    $('ul.pagination li.active').removeClass('active');
                                //                    $(item.parentNode).addClass("active");
                                //                }
                            }

                            function construir_resultado(div, item, modal) {
                                var subfix = '';
                                var div_inicial = '<div class = "col-md-4" style="height:325px; min-height:325px;">';
                                if (modal) {
                                    subfix = '2_';
                                    div_inicial = '<div style="width:100%;">';
                                }

                                var descriptionAll = '';
                                if (item.descripcion)
                                    descriptionAll = item.descripcion;
                                var description = descriptionAll.length > 140 ? descriptionAll.substring(0, 139) : descriptionAll;
                                setTimeout(function () {
                                    $('#' + div).append(div_inicial +
                                            '<div class = "box">' +
                                            '<div class = "box-header with-border">' +
                                            '<a href="#" target="_blank" onclick="obtenerDetalle(' + item.id + ');"> <img class="img-responsive center-block" src = "bancoideas/' + item.imagen + '" onerror="error(this)" style = "height: 100px;" /> </a>' +
                                            '<h3 class="box-title" style="height:50px;">' + item['nombre'] + '</h3>' +
                                            '<br><span class = "label label-default" style="height:25px;">' + item.kw + '</span>' +
                                            '<div class = "box-body" style="height:75px;">' + description + '<a href="#" onclick="obtenerDetalle(' + item.id + ');"> ... ver más</a> </div>' +
                                            '<small>' +
                                            '<div class = "box-footer" style="margin-top:10px;">' +
                                            //                            '<div class="pull-right">' + construir_social(item, subfix, usr) + '</div>' +
                                            '</small>' +
                                            '</div>' +
                                            '</div>'
                                            );
                                }, 500);
                            }



                            //            $('#ciiu').tagsinput({
                            //                tagClass: "badge badge-default",
                            //                typeahead: {
                            //                    source: function (query) {
                            //                        var result = new Array();
                            //                        var categorias = callWS('${pageContext.request.contextPath}/idea/listitem.htm', 'GET', 'JSON', {term: query});
                            //                        $.each(categorias, function (i, item) {
                            //                            result.push(item.nombre);
                            //                        });
                            //                        return result;
                            //                    }
                            //                }
                            //            });

                            $('#kw').tagsinput({
                                tagClass: "badge badge-success",
                                width: "100%"
                            });
                            function getInfoPersona(valor, opcion) {
                                document.getElementById("btn_agregar").disabled = true;
                                var url = 'buscarpersona.htm';
                                if (opcion == 'id')
                                    var url = 'buscarpersona.htm';
                                $.ajax({
                                    url: url,
                                    type: 'get',
                                    dataType: 'json',
                                    data: {valor: valor.trim(), opcion: opcion},
                                    success: function (data) {
                                        document.getElementById("btn_agregar").disabled = false;
                                        document.getElementById('span_nombre').innerHTML = data.nombre;
                                        $("#pnombre").val(data.nombre);
                                        $("#pidentificacion").val(data.cedula);
                                        //                    $("#pusuario").val(data.usuario);
                                    },
                                    error: function (e, msg) {
                                        document.getElementById('span_nombre').innerHTML = 'no existe...';
                                        //                        console.log(e);
                                    }
                                });
                            }
        </script>
        <!--<script src="${pageContext.request.contextPath}/recursos/js/websocket.js" type="text/javascript"></script>-->
    </body>
</html>