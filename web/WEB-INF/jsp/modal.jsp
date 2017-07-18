<%-- 
    Document   : modal
    Created on : 18-jul-2017, 12:07:18
    Author     : manuelmax
--%>
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
                            
                         
                            


