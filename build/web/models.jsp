<%-- 
    Document   : models
    Created on : Nov 29, 2016, 11:07:07 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <section class="container">
            <h1 class="col-sm-offset-5">Модель: </h1>
            <form method="POST" class="col-sm-8 col-sm-offset-2" action="addmodel" id="_addproduct" name="addmodel">
                <div class="form-group">
                    <label for="usr">Наименование модели: </label>                    
                    <div class="row">
                        <div class="col-sm-9">
                            <select class="form-control" required="true" id="_model" name="model" onchange="submit()" >
                                <option disabled selected value="">Выберите модель</option>
                                <c:forEach var="model" items="${models}">
                                <c:if test="${model.id eq selectedModel.id}">
                                <option selected="true" value="${model.id}">${model.name}</option>
                                </c:if>
                                <c:if test="${model.id ne selectedModel.id}">
                                <option value="${model.id}">${model.name}</option>
                                </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div  class="col-sm-2">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModel">Добавить новую</button>
                        </div>
                    </div>                  
                    <br>

                    <%-- таблица составляющих модели --%>
                    
                        <h2 class="col-sm-offset-4">Составляющие: </h2>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Серийный номер:</th>
                                    <th>Стоимость операции: </th>
                                    <th>Время выполнения: </th>
                                    <th>Описание: </th>
                                    <th>Удалить: </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="part" items="${selectedModel.parts}">                               
                                <tr>
                                    <td><a href='editPart?edit_part_id=${part.id}&selected_model_id=${selectedModel.id}' name='edit_part_id'>${part.serial}</a></td>
                                    <td>${part.price}</td>
                                    <td>${part.duration}</td>
                                    <td>${part.description}</td>                
                                    <td><a href='deletePart?delete_part_id=${part.id}&selected_model_id=${selectedModel.id}' name='delete_part_id'> 
                                            <span class="btn btn-danger btn-sm glyphicon glyphicon-remove" title="Удалить ${part.serial} (id = ${part.id})"></span></a>
                                    </td>
                                </tr>                                    
                                </c:forEach>
                            </tbody>
                        </table> 
                        
                    
                    <%-- добавление новой операции --%>
                    <div>
                        
                        <label for="comment">Серийный номер: </label>
                        <input type="text" class="form-control" id="_newpartname" name="newpartname" value="${partToEdit.serial}">
                        <br>

                        <label for="comment">Описание: </label>
                        <textarea class="form-control" rows="5" id="_newpartdescription" name="newpartdescription">${partToEdit.description}</textarea>
                        <br>  
                        <div class="row">
                            <div class="col-sm-3">
                                <label for="comment">Стоимость операции: </label>
                                <input type="text" class="form-control" id="_newpartprice" name="newpartprice" value="${partToEdit.price}">
                                <br>
                                <label for="comment">Время выполнения: </label>
                                <input type="text" class="form-control" id="_newpartduration" name="newpartduration" value="${partToEdit.duration}">
                            </div>
                        </div>

                    </div>

                    <br>

                </div>
                <input type="submit" class="btn btn-primary btn-lg" id="save" name="save" value="Сохранить">
            </form>
        </section>

        
        <%-- добавление новой модели --%>
        <div class="modal fade" id="addModel" role="dialog">
            <form method="POST" action="addmodelname" id="_addmodelname" name="addmodelname">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Новая модель: </h4>
                        </div>
                        <div class="modal-body">
                            <label for="comment">Название: </label>
                            <input type="text" class="form-control" id="_newmodel" name="newmodel">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Добавить</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
