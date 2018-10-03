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
                    alert("Error leyendo datos." + textStatus);
                }
            });
        </script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
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
                    <!--<a style="cursor:pointer;" href="http://smartland.utpl.edu.ec" target="_blank"> <img src="${pageContext.request.contextPath}/recursos/img/smartland.png" width="100px;"/> </a> &nbsp;&nbsp;&nbsp;-->
                </div>
                <div class="col-md-6">
                    <p>
                        Un sistema para emprendedores a través del cual podrá inscribir su idea de negocio que a su vez le permitirá 
                        contactar con inversionistas que impulsarán el desarrollo de su iniciativa 
                    </p>
                </div>
            </div>
        </c:if>
        <!-- MAIN CONTENT -->
        <div class="container" style="background-color: #FFF;">
            <div align='center'>
                <br><br>
                <div class="row">
                    <div class="col-md-6" style="vertical-align: middle;">
                        <div>
                            <p class="alert alert-info">
                                <span class="glyphicon glyphicon-info-sign"></span> Estimado(a) usuario, para acceder al sistema del Banco de Ideas UTPL (BI), deberá hacerlo con las credenciales del correo institucional o sistema académico.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6" style="vertical-align: middle;">

                        <label>Ingreso al sistema</label>
                        <form:form action="auth.htm" modelAttribute="login" method="POST" autocomplete="off">   
                            <table>
                                <tr>
                                    <td>Usuario: </td>
                                    <td>
                                        <form:input type="text" path="username" placeholder="Usuario" size="30" autofocus="autofocus" />
                                        <form:errors path="username" cssClass="error" />
                                    </td>
                                </tr>
                                <tr><td><br></td><td></td></tr>
                                <tr>
                                    <td>Clave: </td>
                                    <td>
                                        <form:input type="password" path="password" placeholder="Contraseña" size="30" />
                                        <form:errors path="password" cssClass="error" />
                                    </td>
                                </tr>
                                <tr><td><br></td><td></td></tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <button class="btn btn-primary"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Ingresar</button>
                                    </td>
                                </tr>
                            </table>

                            <div>
                                <c:if test="${!empty message}">
                                    <div class="message green">${message}</div>
                                </c:if>
                            </div>
                        </form:form>
                    </div> <!-- end content -->
                </div>
            </div>
        </div>
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
    </body>
</html>