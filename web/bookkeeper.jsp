<%-- 
    Document   : bookkeeper
    Created on : Dec 1, 2016, 12:33:49 PM
    Author     : pupil
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>bookkepper</title>
    </head>
    <body>
        <h1>Зарплата</h1>
<div class="container">           
                <select class="form-control" id="sel1" name="selectMonth">
                                <option value="1">Январь</option>
                                <option value="2">Февраль</option>
                                <option value="3">Март</option>
                                <option value="4">Апрель</option>
                                <option value="5">Май</option>
                                <option value="6">Июнь</option>
                                <option value="7">Июль</option>
                                <option value="8">Август</option>
                                <option value="9">Сентябрь</option>
                                <option value="10">Октябрь</option>
                                <option value="11">Ноябрь</option>
                                <option value="12">Декабрь</option>
                </select>                
                <select class="form-control" id="sel1" name="selectYear">
                    <option>2017</option>
                    <option>2016</option>
                    <option>2015</option>
                    <option>2014</option>
                </select>           
            <p></p>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Статус</th>
                        <th>Зарплата</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${workers}" var="worker">
                        <tr><td>${worker.id}</td><td>${worker.firstname}</td>
                            <td>${worker.lastname}</td><td>${worker.status}</td> </tr>
                    </c:forEach>                        
                </tbody>
            </table>
        </div>
    </body>
</html>
