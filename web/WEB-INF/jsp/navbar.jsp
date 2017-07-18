<%-- 
    Document   : navbar
    Created on : 18-jul-2017, 16:05:32
    Author     : manuelmax
--%>
<%@include file="/WEB-INF/jsp/includes.jsp" %>
        <!--SECCIÓN DE CABECERA--> 
        <nav class="navbar navbar-default" style="background-color: #fff;border:none;margin-bottom: 0px;border-radius:0;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<img src="${pageContext.request.contextPath}/recursos/img/serendipity_social.png" alt=""  width="200px;" style="padding: 5px 0px;"/>-->
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <!--<li> <p style="font-size: 24px;">Banco de Ideas</p> </li>-->
                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="padding: 5px 0px;">
                        <c:if test="${empty nombre}">
                            <li style="margin-top:5px;">
                                <button class="btn btn-sm btn-primary" onclick="$('#mdl_login').modal('show');$('#username').focus();">
                                <strong>Ingresar</strong> <span class="glyphicon glyphicon-log-in"></span> 
                                </button>
                            </li>
                            <li>
                                <!--<button class="btn btn-sm btn-info" onclick="$('#mdl_register').modal('show')"><strong>Register</strong> <span class="glyphicon glyphicon-log-in"></span> </button>--> 
                            </li>
                        </c:if>
                        <c:if test="${!empty nombre}">
                            <c:if test="${!empty menu}">
                                <li>
                                    <div id="div_menu"> 
                                        
                                            <c:forEach items="${menu}" var="m">
                                                <div class="btn-group">
                                                    <a id="dLabel" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                                                        <span class="${m.titulo.icono}" aria-hidden="true"></span> ${m.titulo.nombre}
                                                        <span class="caret"></span>
                                                    </a>
                                                    <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                                        <c:forEach items="${m.items}" var="it">
                                                            <li> <a href="${it.url}?us=${us}&conv=1"> <span class="${it.icono}" aria-hidden="true"></span> ${it.nombre} </a> </li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                            </c:forEach>
                                        
                                    </div>
                                </li>
                            </c:if>
                            <li style="margin-top:5px;">
                                <c:if test = "${nombre != null}">
<!--                                    <form action="idea_index.htm?us=${us}&nueva=true" method="GET">-->
                                    <button class="btn btn-sm btn-primary" onclick="$('#mdl_opcion').modal('show');"><strong>Nueva idea</strong> <span class="glyphicon glyphicon-plus"></span> </button> &nbsp;&nbsp;
                                    <!--</form>-->
<!--                                    <a class="btn btn-sm btn-primary" href="idea/index.htm?us=${us}"> <span class="glyphicon glyphicon-plus"></span> Nueva Idea </a>-->
                                    <br><br>
                                </c:if>
                                <!--<button class="btn btn-sm btn-primary" onclick="$('#mdl_contribucion').modal('show')"><strong>Contribución OER</strong> <span class="glyphicon glyphicon-plus"></span> </button> &nbsp;&nbsp;-->
                            </li>
                            <li>
                                <nav class="navbar navbar-static-top">
                                    <!-- Sidebar toggle button-->
                                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                                        <span class="sr-only">Toggle navigation</span>
                                    </a>
                                    <div class="navbar-custom-menu">
                                        <ul class="nav navbar-nav">
                                            <!--                                            <li class="dropdown messages-menu">
                                                                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-toggle="tooltip" data-placement="top" title="Favorites">
                                                                                                <i><span class="glyphicon glyphicon-star"></span></i>
                                                                                                <span class="label label-success" id="span_total_fav_1">${fn:length(favoritos)}</span>
                                                                                            </a>
                                                                                            <ul class="dropdown-menu">
                                                                                                <li class="header">You have <span id="span_total_fav_2">${fn:length(favoritos)}</span> resources marked as favorite</li>
                                                                                                <li>
                                                                                                    <ul class="menu" id="ul_recursos_fav" >
                                            <c:forEach items="${favoritos}" var="f">
                                                <li id="li_fav_${f.id}"> start message 
                                                    <a style="cursor: pointer;" onclick="obtenerDetalle(${f.id})" data-toggle="modal" data-target="#mdl_modal">
                                                        <div class="pull-left">
                                                            <span class="glyphicon glyphicon-star"></span>
                                                        </div>
                                                        <h4>
                                                ${f.titulo}
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>${f.descripcion}</p>
                                        </a>
                                    </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#" onclick="listar('favorites',${us});">view all</a></li>
                                </ul>
                            </li>

                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-toggle="tooltip" data-placement="top" title="Likes">
                                    <i><span class="glyphicon glyphicon-thumbs-up"></span></i>
                                    <span class="label label-success" id="span_total_like_1">${fn:length(likes)} </span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have <span id="span_total_like_2">${fn:length(likes)}</span> resources marked as like</li>
                                    <li>
                                         inner menu: contains the actual data 
                                        <ul class="menu" id="ul_recursos_like">
                                            <c:forEach items="${likes}" var="l">
                                                <li id="li_lk_${l.id}"> start message 
                                                    <a style="cursor: pointer;" onclick="obtenerDetalle(${l.id})" data-toggle="modal" data-target="#mdl_modal">
                                                        <div class="pull-left">
                                                            <span class="glyphicon glyphicon-thumbs-up"></span>
                                                        </div>
                                                        <h4>
                                                ${l.titulo}
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>${l.descripcion}</p>
                                        </a>
                                    </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#" onclick="listar('likes',${us});">view all</a></li>
                                </ul>
                            </li>

                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-toggle="tooltip" data-placement="top" title="Tags">
                                    <i><span class="glyphicon glyphicon-tag"></span></i>
                                    <span class="label label-success" id="span_total_tag_1">${fn:length(tags)}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have <span id="span_total_tag_2">${fn:length(tags)}</span> resources taged</li>
                                    <li>
                                         inner menu: contains the actual data 
                                        <ul class="menu" id="ul_recursos_tag">
                                            <c:forEach items="${tags}" var="t">
                                                <li id="li_tag_${t.id}"> start message 
                                                    <a style="cursor: pointer;" onclick="obtenerDetalle(${t.id})" data-toggle="modal" data-target="#mdl_modal">
                                                        <div class="pull-left">
                                                            <span class="glyphicon glyphicon-tags"></span>
                                                        </div>
                                                        <h4>
                                                ${t.titulo}
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>${t.descripcion}</p>
                                        </a>
                                    </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#" onclick="listar('tags',${us});">view all</a></li>
                                </ul>
                            </li>

                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-toggle="tooltip" data-placement="top" title="My Ideas">
                                    <i><span class="glyphicon glyphicon-th-large"></span></i>
                                    <span class="label label-success" id="span_total_rec_1">${fn:length(recursos)}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have <span id="span_total_rec_2">${fn:length(recursos)} resources added</li>
                                    <li>
                                         inner menu: contains the actual data 
                                        <ul class="menu" id="ul_recursos_rec">
                                            <c:forEach items="${recursos}" var="r">         
                                                <li id="li_rec_${r.id}"> start message 
                                                    <a style="cursor: pointer;" onclick="obtenerDetalle(${r.id}, 1)" data-toggle="modal" data-target="#mdl_modal">
                                                        <div class="pull-left">
                                                            <span class="glyphicon glyphicon-th-large"></span>
                                                        </div>
                                                        <h4>
                                                ${r.titulo}
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>${r.descripcion}</p>
                                        </a>
                                    </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#" onclick="listar('resources',${us});">view all</a></li>
                                </ul>
                            </li>-->

                                            <!-- User Account: style can be found in dropdown.less -->
                                            <li class="dropdown user user-menu">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                    <img src="${pageContext.request.contextPath}/recursos/img/user-profile.png" class="user-image" alt="User Image">
                                                    <span class="hidden-xs">${nombre}</span>
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <!-- User image -->
                                                    <li class="user-header">
                                                        <img src="${pageContext.request.contextPath}/recursos/img/user-profile.png" class="img-circle" alt="User Image">
                                                        <p>
                                                            ${nombre}
                                                        </p>
                                                    </li>
                                                    <!-- Menu Body -->
                                                    <li class="user-body">
                                                        <div class="row">
                                                            <div class="col-xs-4 text-center">
                                                                <a href="#">Favoritos</a>
                                                            </div>
                                                            <div class="col-xs-4 text-center">
                                                                <a href="#">Likes</a>
                                                            </div>
                                                            <div class="col-xs-4 text-center">
                                                                <a href="#">Tags</a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li class="user-footer">
                                                        <div class="pull-left">
                                                            <a href="#" class="btn btn-default btn-flat">Perfil</a>
                                                        </div>
                                                        <div class="pull-right">
                                                            <a href="${pageContext.request.contextPath}/logout.htm" class="btn btn-default btn-flat"><strong> ( Salir ) </strong></a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>

                                    </div>
                                </nav>
                            </li>
                        </c:if>

                        <!--                        <li>
                                                    <div class="pull-right">
                                                        <span style="color:#999">Themes:</span>
                                                        <select id="cb-theme" style="width:120px;height:25px"></select>
                                                    </div>
                                                </li>-->
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

