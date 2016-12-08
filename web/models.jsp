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
                            <select class="form-control " id="_model" name="model">
                                <%--
                                <c:forEach var="model" items="models">
                                    <c:if test="${model.id eq selectedModel.id}">
                                        <option selected="true" value="${model.id}">${model.modelName}</option> 
                                    </c:if>
                                    <c:if test="${model.id ne selectedModel.id}">
                                        <option value="${model.id}">${model.modelName}</option>
                                    </c:if>
                                </c:forEach>
                                --%>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#addModel">Добавить новую</button>
                        </div>
                    </div>                  
                    <br>
                    <label for="usr">Наименование операции: </label>
                    <div class="row">
                        <div class="col-sm-9">
                            <select class="form-control " id="_model" name="operation">
                                <%--
                                <c:forEach var="part" items="parts">
                                    <c:if test="${part.id eq selectedPart.id}">
                                        <option selected="true" value="${part.id}">${part.name}</option> 
                                    </c:if>
                                    <c:if test="${part.id ne selectedPart.id}">
                                        <option value="${part.id}">${part.name}</option>
                                    </c:if>
                                </c:forEach>
                                --%>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#addOperation">Добавить новую</button>
                        </div>
                    </div>   
                    <br>
                </div>
                <input type="submit" class="btn btn-primary btn-lg" id="_submit" name="submit" value="Добавить">
            </form>
        </section>

        <%-- таблица составляющих модели --%>
        <section class="container">
            <h1 class="col-sm-offset-5">Операции: </h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Название части: </th>
                        <th>Стоимость операции: </th>
                        <th>Время выполнения: </th>
                        <th>Описание: </th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%-- 
                    <c:forEach var="operation" items="${operations}">
                    --%>
                    <tr>
                        <td>${part.name}</td>
                        <td>${part.price}</td>
                        <td></td>
                        <td></td>
                        <td>            
                            <a href="#" role="button" data-keyboard="false" class="btn btn-primary btn-sm" data-backdrop="static" data-toggle="modal" data-target="#operationEdit" data-remote="">
                                <span class="glyphicon glyphicon-edit" title="Изменить" ></span></a>

                            <a href="#" role="button" data-keyboard="false" class="btn btn-primary btn-sm" data-backdrop="static" data-toggle="modal" data-target="#operationDelete" data-remote="">
                                <span class="glyphicon glyphicon-remove" title="Удалить" ></span></a>
                        </td>
                    </tr>
                    <%--
                    </c:forEach>
                    --%>
                </tbody>
            </table>               
        </section> 

        <%-- добавление новой модели --%>
        <div class="modal fade" id="addModel" role="dialog">
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
                        <button type="button" class="btn btn-success" data-dismiss="modal">Добавить</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>

        <%-- добавление новой операции --%>
        <div class="modal fade" id="addOperation" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Новая операция: </h4>
                    </div>
                    <div class="modal-body">
                        <label for="comment">Название операции: </label>
                        <input type="text" class="form-control" id="_name">
                        <br>

                        <label for="comment">Описание: </label>
                        <textarea class="form-control" rows="5" id="_description"></textarea>

                        <br>                   

                        <div class="row">
                            <div class="col-sm-3">
                                <label for="comment">Стоимость операции: </label>
                                <input type="text" class="form-control" id="_price">

                                <br>

                                <label for="comment">Время выполнения: </label>
                                <input type="text" class="form-control" id="_time">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">Добавить</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>

        <%-- редактирование операции --%>
        <div id="operationEdit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Изменить операцию: </h4>
                    </div>
                    <div class="modal-body">
                        <label for="comment">Название операции: </label>
                        <input type="text" class="form-control" id="_name">

                        <br>

                        <label for="comment">Описание: </label>
                        <textarea class="form-control" rows="5" id="_description"></textarea>

                        <br>                   

                        <div class="row">
                            <div class="col-sm-3">
                                <label for="comment">Стоимость операции: </label>
                                <input type="text" class="form-control" id="_price">

                                <br>

                                <label for="comment">Время выполнения: </label>
                                <input type="text" class="form-control" id="_time">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">Сохранить</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div> 

        <%-- удаление операции --%>
        <div id="operationDelete" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Удалить операцию: </h4>
                    </div>
                    <div class="modal-body">
                        % название операции здесь %
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Удалить</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
