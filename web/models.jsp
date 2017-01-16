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

                                    <th>Название части: </th>
                                    <th>Стоимость операции: </th>
                                    <th>Время выполнения: </th>
                                    <th>Описание: </th>
                                    <th>Удалить: </th>
                                    <th>Изменить: </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="part" items="${selectedModel.parts}">                               
                                <tr>                            
                                    <td><a href='partId=${part.id}&modelId=${selectedModel.id}' name='partId'>${part.serial}</a></td>
                                    <td>${part.price}</td>
                                    <td>${part.duration}</td>
                                    <td>${part.description}</td>
                                    
                                <form></form> <!-- необъяснимая форма, без кот. кнопки отказываются работать -->
                                
                                    <td>                                        
                                        <form method="POST" action="deletePart" id="_deletePart" name="deletePart">
                                            
                                            <input type="hidden" name="selected-model-id" value="${selectedModel.id}">
                                            <input type="hidden" name="delete-part-id" value="${part.id}">
                                        <button type="submit" class="btn btn-danger btn-sm" id="_partToDelete" name="partToDelete">
                                        <span class="glyphicon glyphicon-remove" title="Удалить ${part.serial} (id = ${part.id})"></span></button> 
                                        </form>
                                    </td>
                                    
                                    <td>                     
                                        <form method="POST" action="editPart" id="_editPart" name="editPart">
                                            <input type="hidden" name="selected-model-id" value="${selectedModel.id}">
                                            <input type="hidden" name="edit-part-id" value="${part.id}">
                                        <button type="submit" class="btn btn-primary btn-sm" id="_partToEdit" name="partToEdit">
                                        <span class="glyphicon glyphicon-edit" title="Изменить ${part.serial} (id = ${part.id})"></span></button> 
                                        </form>
                                    </td>        
                                    
                                </tr>                                    
                                </c:forEach>
                            </tbody>
                        </table> 
                        
                    
                    <%-- добавление новой операции --%>
                    <div>
                        <label for="comment">Название операции: </label>
                        <input type="text" class="form-control" id="_newpartname" name="newpartname" value="${part.name}">
                        <br>

                        <label for="comment">Описание: </label>
                        <textarea class="form-control" rows="5" id="_newpartdescription" name="newpartdescription" value="${part.description}"></textarea>

                        <br>                   

                        <div class="row">
                            <div class="col-sm-3">
                                <label for="comment">Стоимость операции: </label>
                                <input type="text" class="form-control" id="_newpartprice" name="newpartprice" value="${part.price}">

                                <br>

                                <label for="comment">Время выполнения: </label>
                                <input type="text" class="form-control" id="_newpartduration" name="newpartduration" value="${part.duration}">
                            </div>
                        </div>
                    </div>

                    <br>

                </div>
                <input type="submit" class="btn btn-primary btn-lg" id="_submit" name="_submit" value="Добавить">
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
