<%-- 
    Document   : bookkeeper
    Created on : Dec 1, 2016, 12:33:49 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/calendar.css" rel="stylesheet" type="text/css"/>
        <link href="resourses/css/bookkeeper.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/calendar.js" defer></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>bookkepper</title>
    </head>
    <body>
        <h1>Зарплата</h1>

        <div class="calender">
            <table id="calendar4">
                <thead>
                    <tr><td colspan="4"><select>
                                <option value="0">Январь</option>
                                <option value="1">Февраль</option>
                                <option value="2">Март</option>
                                <option value="3">Апрель</option>
                                <option value="4">Май</option>
                                <option value="5">Июнь</option>
                                <option value="6">Июль</option>
                                <option value="7">Август</option>
                                <option value="8">Сентябрь</option>
                                <option value="9">Октябрь</option>
                                <option value="10">Ноябрь</option>
                                <option value="11">Декабрь</option>
                            </select><td colspan="3"><input type="number" value="" min="0" max="9999" size="4">
                    <tr><td>Пн<td>Вт<td>Ср<td>Чт<td>Пт<td>Сб<td>Вс
                <tbody>
            </table>

           
        </div>
        <div class="container">
            <div class="date">
                <select class="form-control" id="sel1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
                <div class="date">
                <select class="form-control" id="sel1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
            <p></p>
            <table class="table">
                <thead>
                    <tr>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Зарплата</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>----------------------------</td>
                        <td>-------------------------------</td>
                        <td>------------------------------</td>
                    </tr>      
                    <tr class="success">
                        <td>^^^^^^^^^^^^^^^^^^^^^</td>
                        <td>^^^^^^^^^^^^^^^^^^^^^</td>
                        <td>^^^^^^^^^^^^^^^^^^^^^</td>
                    </tr>
                    <tr class="danger">
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr class="info">
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr class="warning">
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr class="active">
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
