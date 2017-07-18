<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ideas</title>
        <!--<link href="${pageContext.request.contextPath}/recursos/css/bootstrap.min-3.3.4.css" rel="stylesheet" type="text/css"/>-->
    </head>

    <body>
    <header>
        <jsp:include page="../inicio/header.jsp" />
    </header>
    <div class="container">
        <a href="javascript:history.back(1)"><span class="glyphicon glyphicon-menu-left"></span>Volver Atrás</a>
        <br><br>
        <!--<a class="btn btn-primary pull-right" href="listar.htm"> <span class="glyphicon glyphicon-list"></span> Listar Ideas </a>-->
        <div class="row">
            <div class="col-md-4">
                <table class="table-striped table-bordered table-condensed" style="width: 90%;">
                    <tr>
                        <td> 
                            <c:if test = "${idea.id == null}">
                                <a href="index.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">1</span> Información de la Idea</a> 
                            </c:if>
                            <c:if test = "${idea.id != null}">
                                <a href="index.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">1</span> Información de la Idea <span class="glyphicon glyphicon-ok pull-right"></span> </a> 
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test = "${idea.id == null}">
                                <a href="participante.htm?us=${us}&id_idea=${idea.id}" style="cursor:not-allowed;pointer-events: none;"> <span class="badge">2</span>  Participantes</a> 
                            </c:if>
                            <c:if test = "${idea.id != null}">
                                <c:if test = "${fn:length(participantes) == 0}">
                                    <a href="participante.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">2</span>  Participantes</a> 
                                </c:if>
                                <c:if test = "${fn:length(participantes) > 0}">
                                    <a href="participante.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">2</span>  Participantes <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                    </c:if>
                                </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <c:if test = "${idea.id == null}">
                                <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}" style="cursor:not-allowed;pointer-events: none;"> <span class="badge">3</span> Estado de la idea</a> 
                            </c:if>
                            <c:if test = "${idea.id != null}">
                                <c:if test = "${idea.itemCatalogoByEstadoGestacion == null}">
                                    <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">3</span> Estado de la idea</a> 
                                </c:if>
                                <c:if test = "${idea.itemCatalogoByEstadoGestacion != null}">
                                    <a href="estadogestacion.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"> <span class="badge">3</span> Estado de la idea <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                    </c:if>
                                </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <c:if test = "${idea.id == null}">
                                <a href="publicar.htm?us=${us}&id_idea=${idea.id}" style="cursor:not-allowed;pointer-events: none;"><span class="badge">4</span> Publicar</a> 
                            </c:if>
                            <c:if test = "${idea.id != null}">
                                <c:if test = "${idea.publicar == false}">
                                    <a href="publicar.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;"><span class="badge">4</span> Publicar</a> 
                                </c:if>
                                <c:if test = "${idea.publicar == true}">
                                    <a href="publicar.htm?us=${us}&id_idea=${idea.id}" style="cursor:pointer;" ><span class="badge">4</span> Publicar <span class="glyphicon glyphicon-ok pull-right"></span></a> 
                                    </c:if>
                                </c:if>
                        </td>
                    </tr>
                </table>
            </div>
            
            <c:if test = "${fase == 'idea'}">
                <div class="col-md-8">
                    <form:form action="guardar.htm" modelAttribute="idea" method="POST" enctype="multipart/form-data" >
                        <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                        <input type="hidden" id="id_us" name="id_us" value="${us}">
                        <div class="thumbnail">
                            <p class="bg-primary" style="padding-left: 10px; color:white;"><span class="badge">1.</span><strong>Datos Generales</strong></p>  
                            <table class="table" style="width: 100%;">
                                <tr>
                                    <td style="width: 15%;"> <label for="conv">Convocatoria</label> </td>
                                    <td style="width: 85%;"> 
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
                                    <td style="width: 15%;"> <label for="nombre">Nombre</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="nombre" name="nombre" value="${idea.nombre}" style="width: 98%;" required> *</td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="kw">Imagen</label> </td>
                                    <td style="width: 85%;"> <!--
                                        <div class="panel-body">
                                            <div id="dropzoneImage" action="index.htm" class="dropzone" >
                                                <div class="fallback">
                                                    <input type="file" id="file" name="file">
                                                </div>
                                            </div>
                                        </div>
                                        -->
                                        <input type="file" id="file"  accept="image/*"  />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="tipo">Tipo</label> </td>
                                    <td style="width: 85%;"> 
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
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="descripcion">Descripción</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="descripcion" name="descripcion" value="${idea.descripcion}" style="width: 98%;" required> *</td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="objetivo">Objetivo</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="objetivo" name="objetivo" value="${idea.objetivo}" style="width: 98%;" required> *</td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="mercado">Mercado Potencial</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="mercado" name="mercado" value="${idea.mercadoPotencial}" style="width: 98%;" > </td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="lugar">Lugar de origen de la idea</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="lugar" name="lugar" value="${idea.lugar}" style="width: 98%;" required> *</td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="kw">Keywords</label> </td>
                                    <td style="width: 85%;"> <input type="text" id="kw" name="kw" value="${idea.kw}" style="width: 98%;" required> *</td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="ciiu">Clasificación CIIU</label> </td>
                                    <td style="width: 85%;"> 
                                        <input id="ciiu" type="text" class="form-control" style="width: 100% !important;" data-role="tagsinput" value="" placeholder="Ingrese categoría ciiu" />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 15%;"> <label for="kw">Archivos adjuntos</label> </td>
                                    <td style="width: 85%;"> 
                                        <input type="file" path="fileAdjunto" id="fileAdjunto" accept="application/pdf" />
                                    </td>
                                </tr>
                            </table>
                            <label class="label label-success" style="margin-left: 10px; padding-left: 10px;">MEDIA</label>  
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
                            </table>
                        </div>
                        <br>
                        <div align="center">
                            <button id="btn_guardar" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span> Guardar</button>
                        </div>
                    </form:form> 
                </div>
            </div>
        </c:if>

        <c:if test  = "${fase == 'participante'}">
            <div class="col-md-8">
                <p class="bg-primary" style="padding-left: 10px; color:white;"><span class="badge">2.</span><strong>Miembros integrantes de la idea</strong></p>  
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
            </div>
        </c:if>

        <c:if test = "${fase == 'estadogestacion'}">
            <div class="col-md-8">
                <p class="bg-primary" style="padding-left: 10px; color:white;"><span class="badge">3.</span><strong>Estado de Gestación de la Idea</strong></p>  
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
                    </table>
                    <button class="btn btn-primary" > <span class="glyphicon glyphicon-save"></span> Guardar</button>
                </form>
            </div>
        </c:if>

        <c:if test = "${fase == 'publicacion'}">
            <div class="col-md-8">
                <p class="bg-primary" style="padding-left: 10px; color:white;"><span class="badge">4.</span><strong>Publicación de la Idea</strong></p>  
                <form action="publicar.htm" method="POST">
                    <input type="hidden" id="id_idea" name="id_idea" value="${idea.id}">
                    Al publicar la idea, estará disponible para compartirla con otros innovadores e inversionistas
                    <br><br>
                    <c:if test = "${idea.publicar == false}">
                        <button class="btn btn-primary" > <span class="glyphicon glyphicon-ok"></span> Publicar </button>
                    </c:if>
                    <c:if test = "${idea.publicar == true}">
                        <label class="bg-success">Tu idea ya ha sido publicada</label>
                    </c:if>
                </form>
            </div>
        </c:if>
    </div>

    <script>
        Dropzone.autoDiscover = false;
        var dropzoneImage = new Dropzone("#dropzoneImage", {
            url: 'guardar.htm',
            autoProcessQueue: false, //para que solo carge el archivo
            maxFilesize: 1, // MB
            addRemoveLinks: true,
            dictRemoveFile: "Eliminar",
            uploadMultiple: false,
            maxFiles: 1,
            dictDefaultMessage: "<h3 class='text-muted'>Arrastre aquí<h3>",
            acceptedFiles: "image/*", //".xls,.xlsx,.doc,.docx",
            init: function () {
                this.on("addedfile", function (file) {
//                    alert("Archivo agregado.");
                });
                this.on("removedfile", function (file) {
                    callWS('removefile.htm', 'POST', 'JSON', JSON.stringify(file.name));
                    alert('Archivo removido');
                });
            }
        });

//        Dropzone.autoDiscover = false;
//        var dropzoneArchivos = new Dropzone("#dropzoneArchivos", {
//            url: 'index.htm',
//            autoProcessQueue: false, //para que solo carge el archivo
//            maxFilesize: 2, // MB
//            addRemoveLinks: true,
//            dictRemoveFile: "Eliminar",
//            uploadMultiple: false,
//            maxFiles: 5,
//            dictDefaultMessage: "<h3 class='text-muted'>Arrastre aquí<h3>",
////            acceptedFiles: "image/*", //".xls,.xlsx,.doc,.docx",
//            init: function () {
//                this.on("addedfile", function (file) {
//                    alert("Archivo agregado.");
//                });
//                this.on("removedfile", function (file) {
//                    callWS('removefile.htm', 'POST', 'JSON', JSON.stringify(file.name));
//                    alert('Archivo removido');
//                });
//            }
//        });

        $(document).ready(function () {
            $('#btn_guardar').on('click', function (e) {
                e.preventDefault();
                dropzoneImage.processQueue();
//                dropzoneArchivos.processQueue();
            });
        });

        //Add existing files into dropzone
        function cargarArchivosExistentes() {
            var existingFiles = [
                {name: "hyundai.jpg", size: 31614}
            ];
            for (i = 0; i < existingFiles.length; i++) {
                dropzoneImage.emit("addedfile", existingFiles[i]);
                dropzoneImage.createThumbnailFromUrl(existingFiles[i], "http://localhost:8080/metadata/metadata/hyundai.jpg");
                dropzoneImage.emit("complete", existingFiles[i]);
                dropzoneImage.emit("success", existingFiles[i]);
            }
        }

        $('#ciiu').tagsinput({
            tagClass: "badge badge-default",
            typeahead: {
                source: function (query) {
                    var result = new Array();
                    var categorias = callWS('${pageContext.request.contextPath}/idea/listitem.htm', 'GET', 'JSON', {term: query});
                    $.each(categorias, function (i, item) {
                        result.push(item.nombre);
                    });
                    return result;
                }
            }
        });

        function getInfoPersona(valor, opcion) {
            document.getElementById("btn_agregar").disabled = true;
//            document.getElementById('nombres').innerHTML = '';

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
</body>
</html>
