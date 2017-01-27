<%-- 
    Document   : workers
    Created on : Dec 2, 2016, 9:19:45 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <script src="resources/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/worker.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>workers</title>
    </head>
    <body>
        
         <div class="container">
             <h1>Данные работника:</h1>
             
                <div id="info">
                    <c:out value="${infoMassage}" default="" escapeXml="true" />
                </div>
            
               
            <form class="form-horizontal tdWorker" action="forWorker">   
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft " for="firstname">Имя:</label>
                    <div class="col-sm-10 ">
                        <input type="text" class="form-control" id="_firstname" name="firstname" value="${worker.firstname}" required>
                        <input type="hidden" id="_id" name="id" value="${worker.id}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft" for="lastname">Фамилия:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="_lastname" name="lastname" value="${worker.lastname}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft" for="isikukood">Isikukood:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="_isikukood" name="isikukood" value="${worker.isikukood}" required>
                    </div>   
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft" for="mail">E-почта:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="_mail" name="mail" value="${worker.mail}" required>
                    </div>   
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft" for="telephon">Телефон:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="_telephon" name="telephon" value="${worker.telephon}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 alignLeft" for="status">Статус:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="_status" name="status" value="${worker.status}" required>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info btn-xs" id="_add" name="add">Добавить</button>
                        <button type="submit" class="btn btn-info btn-xs" id="_remove" name="remove">Удалить</button>
                        <button type="submit" class="btn btn-info btn-xs" id="_update" name="update">Изменить</button>
                    </div>
                </div>
            </form>
                    <hr>
                    
            <form action="selectWorker" class="" method="POST">
                <div class="form-group">
                    <select class="form-control selWorker" style="font-weight: bold;" id="_selectWorker" name="selectWorker" onchange="submit(this)">
                        <option value="#" style="font-style: italic;">*** Выберите работника ***</option>
                        <c:forEach var="worker" items="${workers}">
                            <option value="${worker.id}">${worker.firstname} ${worker.lastname}</option>  
                        </c:forEach>
                    </select>
                </div>
            </form>
        </div>
    </body>
</html>


<!--value="worker?id=-->