<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/calendar.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/order.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="resources/js/calendar.js" defer></script>
        <title>Order Furniture </title>
    </head>
    <body>
        <div class="container-fluid">
            <h1>Заказ</h1> 
            <div id="calendar">

                <table id="calendar4" >
                    <thead>
                        <tr><td><td colspan="4">
                                <select>
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
                        <tr><td><td>Пн<td>Вт<td>Ср<td>Чт<td>Пт<td>Сб<td>Вс
                    <tbody></tbody>
                </table>
            </div>
            <form action="orderForm" id="_orderForm" name="orderForm" method="POST">
                <div id="date-box">
                    <div class="date-line">
                        Неделя:<br><select id="_select-week" name="select-week"></select>
                    </div>
                    <div class="date-line">
                        Месяц:<br><select id="_select-month" name="select-month"></select>
                    </div>
                    <div class="date-line">
                        Год:<br><select id="_select-year" name="select-year"></select>
                    </div>
                </div>
                <div id="boxes">
                    <div id="wrap">
                        <div id="boxes-left">
                            <div id="_order-name-box">
                                <label>Заказ:</label>
                                <input class="form-control" id="_order-name" name="order-name" type="text">
                            </div>
                            <div id="block-labels">
                                <div id="label-line">
                                    <label id="label-model">Модель:</label>
                                    <label id="label-count">Количество:</label>
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model-name[]" >
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model-count[]" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model-name[]" >
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model-count[]" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model-name[]" >
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model-count[]" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model-name[]" >
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model-count[]" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model-name[]" >
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control  input-count"" name="model-count[]" type="text">
                                </div>
                            </div>
                            <div id="button-box">
                                <input type="submit" name="add" value="Добавить">
                                <input type="submit" name="update" value="Обновить">
                                <input type="submit" name="remove" value="Удалить">
                            </div>
                        </div>
                        <div id="boxes-right">
                            <h4>Заказы на указанную дату:</h4>
                            <table class="table-condensed">
                            <thead>
                              <tr>
                                <th>№</th>
                                <th>Название ордера</th>
                                <th>Заметки</th>
                              </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="order" items="${orders}" varStatus="status">
                                    <tr class="success">
                                        <td>${status.getOndex()}</td>
                                        <td>${order.name}</td>
                                        <td>${order.desctiption}</td>
                                    </tr>
                                </c:forEach>    
                            </tbody>
                          </table> 
                        </div>  
                        <!-- слой необходим для позиционирования блока boxes-->
                        <div class="clear"></div>
                    </div>   
                </div>
            </form>
        </div>
    </body>
</html>
