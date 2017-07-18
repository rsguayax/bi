<%-- 
    Document   : header
    Created on : 20-mar-2017, 11:36:45
    Author     : TAWSBC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- jQuery 2.2.3 -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap3-typeahead.min.js"></script>
        <script src="${pageContext.request.contextPath}/recursos/js/bootstrap-tagsinput.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/recursos/css/bootstrap-tagsinput.css" rel="stylesheet"/>

        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/primeui-1.0-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/bootstrap.min.js"></script>

        <!-- Font Awesome -->
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">-->
        <!-- Ionicons -->
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">-->
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
        <!--         AdminLTE Skins. Choose a skin from the css/skins
                     folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css">
        <!--iCheck--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/flat/blue.css">
        <!--Morris chart--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
        <!--jvectormap--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!--Date Picker--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
        <!--Daterange picker--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
        <!--bootstrap wysihtml5 - text editor--> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"><!--

        <link href="${pageContext.request.contextPath}/recursos/css/primeui-1.0-min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/recursos/css/jquery-ui.css" rel="stylesheet" />-->

        <link href="${pageContext.request.contextPath}/notify/animate.css" type="text/css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/notify/bootstrap-notify.min.js"></script>

        <!--<script type="text/javascript" src="${pageContext.request.contextPath}/recursos/js/clipboard.min.js"></script>-->

        <!--        librerías para datatables--> 
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/datatables.min.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/datatables.min.js"></script>-->

        
        <style>
            @-moz-document url-prefix() {
                fieldset { display: table-cell; }
            }
        </style>
    </head>
    <body>
        <!-- Modal Generic-->
        <div class="modal fade" id="mdl_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <label id="mdl_label"></label>
                    </div>
                    <div class="modal-body">
                        <div id="mdl_body"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Tag-->
        <div class="modal fade" id="mdl_tag" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Anotación Colaborativa</h4>
                        <br>
                        <span id="info_tags"></span>
                    </div>
                    <div class="modal-body">
                        <div class="input-group">
                            <div class="input-group">Categorías. <span class="glyphicon glyphicon-search" aria-hidden="true"></span></div>
                                <c:if test="${empty us}">  
                                <span class="bg-danger">Ingrese con su usuario y clave para tagear el recurso</span>
                            </c:if>
                            <c:if test="${!empty us}">  
                                <input id="categoria" type="text" class="form-control" style="width: 100% !important;" data-role="tagsinput" value="" placeholder="Ingrese categoría" />
                            </c:if>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal Comment-->
        <div class="modal fade" id="mdl_comment" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Comments</h4>
                        <br>
                        <span id="info_comments"></span>
                    </div>
                    <div class="modal-body">
                        <c:if test="${empty us}">  
                            <span class="bg-danger">Ingrese con su usuario y clave para comentar el recurso</span>
                        </c:if>
                        <c:if test="${!empty us}">  
                            <span id="span_comments">
                                Add New Comment
                                <input type="text" id="txtComment" name="txtComment" style="width: 100%;">
                            </span>
                        </c:if>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
