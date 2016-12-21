<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Заказ</title>
        <link rel="stylesheet" href="css/order.css">
    </head>
    <body>
        <h3> Календарь:</h3>

        <table id="calendar4">

            <thead>

                <tr><td><td colspan="4"><select>

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

                <tr><td>Неделя<td>Пн<td>Вт<td>Ср<td>Чт<td>Пт<td>Сб<td>Вс

            <tbody>


        </table>




        <h1>Заказ</h1>
        <form action="/OrderFurniture" method="post" > 
            <fieldset>
                <legend>Название заказа</legend>
                <input class="name" name="ordername" type="text"  autofocus/> 

            </fieldset>
            <br>
            <fieldset class="dataorder">
                <legend>
                    Неделя:
                </legend>
                <select name="weekend">
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>


                <select name="month" >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">2</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
                <select name="yearo" >	
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                </select>
            </fieldset>
            <br>
            <fieldset>
                <legend>Модель</legend> 
                <select  name="model1" class="model">
                    <option value="0" selected="true">Не выбрано</option>
                    <c:forEach var="model" items="models">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>

                <input class="orderN" value="0" name="qt1"  type="number"/> 

            </fieldset>
            <br>

            <fieldset>

                <select class="model"name="model2"  >
                    <option value="0" selected="true">Не выбрано</option>
                    <c:forEach var="model" items="models">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>

                <input class="orderN" value="0" name="qt2" type="number"/> 

            </fieldset>
            <br>
            <fieldset>

                <select name="model3"  class="model">
                    <option value="0" selected="true">Не выбрано</option>
                    <c:forEach var="model" items="models">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>

                <input class="orderN" value="0" name="qt3" type="number"/> 
            </fieldset>
            <br>
            <fieldset>

                <select class="model" name="model4" >
                    <option value="0" selected="true">Не выбрано</option>
                    <c:forEach var="model" items="models">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>

                <input class="orderN" value="0"  name="qt4" type="number"/> 

            </fieldset>
            <br>
            <fieldset>

                <select class="model"name="model5" >
                    <option value="0" selected="true">Не выбрано</option>
                    <c:forEach var="model" items="models">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>


                <input class="orderN" value="0"  name="qt5" type="number"/>
            </fieldset>
            <br>
       
        <div class="botton" >
            <input type="submit" class="but" value="Заказать"/>
            <input type="submit" class="but" value="Изменить"/>
            <input type="submit" class="but" value="Удалить"/>
         </div>
        </form>
        <table class="zakaz">
            <tr>
                <th> Заказы </th>  
            </tr>
            <tr>
                <td class="num">№</td>
                <td class="name">Название</td>
            </tr>
            <c:forEach var="order" items="orders">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.name}</td>
                </tr>
            </c:forEach>

        </table>
        <script type="text/javascript">
            function Calendar4(id, year, month) {

                Date.prototype.getWeek = function () {
                    var target = new Date(this.valueOf());
                    var dayNr = (this.getDay() + 6) % 7;
                    target.setDate(target.getDate() - dayNr + 3);
                    var firstThursday = target.valueOf();
                    target.setMonth(0, 1);
                    if (target.getDay() != 4) {
                        target.setMonth(0, 1 + ((4 - target.getDay()) + 7) % 7);
                    }
                    return 1 + Math.ceil((firstThursday - target) / 604800000);
                }

                var Dlast = new Date(year, parseFloat(month) + 1, 0).getDate(),
                        D = new Date(year, month, Dlast),
                        DNlast = D.getDay(),
                        DNfirst = new Date(D.getFullYear(), D.getMonth(), 1).getDay(),
                        m = document.querySelector('#' + id + ' option[value="' + D.getMonth() + '"]'),
                        g = document.querySelector('#' + id + ' input');

                if (new Date(D.getFullYear(), D.getMonth(), 1).getWeek() < 10) {
                    calendar = '<tr><td>0' + new Date(D.getFullYear(), D.getMonth(), 1).getWeek();
                } else {
                    calendar = '<tr><td>' + new Date(D.getFullYear(), D.getMonth(), 1).getWeek();
                }

                if (DNfirst != 0) {
                    for (var i = 1; i < DNfirst; i++)
                        calendar += '<td>';
                } else {
                    for (var i = 0; i < 6; i++)
                        calendar += '<td>';
                }

                for (var i = 1; i <= Dlast; i++) {
                    if (i == new Date().getDate() && D.getFullYear() == new Date().getFullYear() && D.getMonth() == new Date().getMonth()) {
                        calendar += '<td class="today">' + i;
                    } else {
                        if (
                                (i == 1 && D.getMonth() == 0 && ((D.getFullYear() > 1897 && D.getFullYear() < 1930) || D.getFullYear() > 1947)) ||
                                (i == 2 && D.getMonth() == 0 && D.getFullYear() > 1992) ||
                                ((i == 3 || i == 4 || i == 5 || i == 6 || i == 8) && D.getMonth() == 0 && D.getFullYear() > 2004) ||
                                (i == 7 && D.getMonth() == 0 && D.getFullYear() > 1990) ||
                                (i == 23 && D.getMonth() == 1 && D.getFullYear() > 2001) ||
                                (i == 8 && D.getMonth() == 2 && D.getFullYear() > 1965) ||
                                (i == 1 && D.getMonth() == 4 && D.getFullYear() > 1917) ||
                                (i == 9 && D.getMonth() == 4 && D.getFullYear() > 1964) ||
                                (i == 12 && D.getMonth() == 5 && D.getFullYear() > 1990) ||
                                (i == 7 && D.getMonth() == 10 && (D.getFullYear() > 1926 && D.getFullYear() < 2005)) ||
                                (i == 8 && D.getMonth() == 10 && (D.getFullYear() > 1926 && D.getFullYear() < 1992)) ||
                                (i == 4 && D.getMonth() == 10 && D.getFullYear() > 2004)
                                ) {
                            calendar += '<td class="holiday">' + i;
                        } else {
                            calendar += '<td>' + i;
                        }
                    }
                    if (new Date(D.getFullYear(), D.getMonth(), i).getDay() == 0 && i != Dlast) {
                        if (new Date(D.getFullYear(), D.getMonth(), i).getWeek() < 9) {
                            calendar += '<tr><td>0' + new Date(D.getFullYear(), D.getMonth(), i + 1).getWeek();
                        } else {
                            calendar += '<tr><td>' + new Date(D.getFullYear(), D.getMonth(), i + 1).getWeek();
                        }
                    }
                }

                if (DNlast != 0) {
                    for (var i = DNlast; i < 7; i++)
                        calendar += '<td>';
                }

                document.querySelector('#' + id + ' tbody').innerHTML = calendar;
                g.value = D.getFullYear();
                m.selected = true;

                if (document.querySelectorAll('#' + id + ' tbody tr').length < 6) {
                    document.querySelector('#' + id + ' tbody').innerHTML += '<tr><td>&nbsp;<td><td><td><td><td><td><td>';
                }

                document.querySelector('#' + id + ' option[value="' + new Date().getMonth() + '"]').style.color = 'rgb(220, 0, 0)';

            }

            Calendar4("calendar4", new Date().getFullYear(), new Date().getMonth());
            document.querySelector('#calendar4').onchange = function Kalendar4() {
                Calendar4("calendar4", document.querySelector('#calendar4 input').value, document.querySelector('#calendar4 select').options[document.querySelector('#calendar4 select').selectedIndex].value);
            }
        </script>
    </body>
</html>
