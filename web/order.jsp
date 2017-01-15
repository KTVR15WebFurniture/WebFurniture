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
            <form action="create_order" name="create_order" method="POST">
            <div>
                <div id="date-box">
                    <div class="date-line">
                       Неделя:<br><select id="select-week" name="select_week">
                            <c:forEach var="week" begin="1" end="53">
                                <c:if test="${week eq curentDate[0]}">
                                    <option value="${week}" selected="true">${week}</option>
                                </c:if>
                                <c:if test="${week ne curentDate[0]}">
                                    <option value="${week}">${week}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="date-line">
                        Месяц:<br><select id="select-month" name="select_month">
                            <option value="${curentDate[1]}" selected="true">${curentDate[1]}</option>
                        </select>
                    </div>
                    <div class="date-line">
                        Год:<br><select id="select-year" name="select_year">
                            <option value="${curentDate[2]}" selected="true">${curentDate[2]}</option>
                        </select>
                    </div>
                </div>
                <div id="boxes">
                    <div id="wrap">
                        <div id="boxes-left">
                            <div id="order-name-box">
                                <label>Заказ:</label><span id="info">${infoMassage}</span>
                                <input class="form-control" id="order_name" name="order_name" value="${order.name}" type="text">
                                <input type="hidden" name="order_id">
                            </div>
                            <div id="block-labels">
                                <div id="label-line">
                                    <label id="label-model">Модель:</label>
                                    <label id="label-count">Количество:</label>
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model_name1" >
                                        <option value="">Выберите модель</option>
                                        <c:forEach var="model" items="${models}">
                                            <c:if test="${model.id eq model1}">
                                                <option selected="true" value="${model.id}">${model.name}</option>
                                            </c:if>
                                            <c:if test="${model.id ne model1}">
                                                <option value="${model.id}">${model.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model_count1" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model_name2" >
                                        <option value="">Выберите модель</option>
                                        <c:forEach var="model" items="${models}">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model_count2" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model_name3" >
                                        <option value="">Выберите модель</option>
                                        <c:forEach var="model" items="${models}">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model_count3" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model_name4" >
                                        <option value="">Выберите модель</option>
                                        <c:forEach var="model" items="${models}">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control input-count" name="model_count4" type="text">
                                </div>
                            </div>
                            <div class="block-models">
                                <div class="model-select-line">
                                    <select class="form-control select-model" name="model_name5" >
                                        <option value="">Выберите модель</option>
                                        <c:forEach var="model" items="${models}">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="model-count-line">
                                    <input class="form-control  input-count"" name="model_count5" type="text">
                                </div>
                            </div>
                            <div id="button-box">
                                <input type="submit" name="add" value="Добавить">
                                <input type="submit" name="update" value="Обновить">
                                
                            </div>
                        </div>
                        <div id="boxes-right">
                            <h4>Заказы на указанную дату:</h4>
                           
                                <table class="table-condensed">
                                    <thead>
                                        
                                        <th>№</th>
                                        <th>Название ордера</th>
                                        <th></th>
                                        <th></th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="order" items="${orders}" varStatus="status">
                                            <tr class="success">
                                                
                                                <td>${status.getIndex()+1}</td>
                                                <td><a href="load?load_order_id=${order.id}">${order.name}</a></td>
                                                <td><a href="load?delete_order_id=${order.id}">x</a></td>
                                            </tr>
                                        </c:forEach>  
                                    </tbody>
                                </table> 
                            
                        </div>  
                        <!-- слой clear необходим для позиционирования блока boxes-->
                        <div class="clear"></div>
                    </div>   
                </div>
           
            </div> 
            </form>
        </div>
    </body>
</html>
