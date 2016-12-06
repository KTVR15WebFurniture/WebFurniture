

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="\WEB-INF\css\bootstrap.min.css">
        <link rel="stylesheet" href="\WEB-INF\css\bootstrap-theme.css">
        <link rel="stylesheet" href="\WEB-INF\css\calendar.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Order Furniture </title>
    </head>
    <body>
<style>
  #calendar4 {
  width: 100%;
  font: monospace;
  max-width: 700px;
  line-height: 1.2em;
  font-size: 15px;
  text-align: center;
  margin: 0 auto;
}
#calendar4 thead tr:last-child {
  font-size: small;
  font-weight: 700;
  color: rgb(103, 103, 103);
}
#calendar4 tbody td {
  color: rgb(44, 86, 122);
}
#calendar4 tbody td:nth-child(1) {
  font-size: small;
  color: rgba(103, 103, 103, .7);
}
#calendar4 tbody td:nth-child(n+7), #calendar4 .holiday {
  color: rgb(231, 140, 92);
}
#calendar4 tbody td.today {
  outline: 3px solid red;
}
</style>

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

<script>
function Calendar4(id, year, month) {

Date.prototype.getWeek = function () {
    var target  = new Date(this.valueOf());
    var dayNr   = (this.getDay() + 6) % 7;
    target.setDate(target.getDate() - dayNr + 3);
    var firstThursday = target.valueOf();
    target.setMonth(0, 1);
    if (target.getDay() != 4) {
        target.setMonth(0, 1 + ((4 - target.getDay()) + 7) % 7);
    }
    return 1 + Math.ceil((firstThursday - target) / 604800000);
}

var Dlast = new Date(year,parseFloat(month)+1,0).getDate(),
    D = new Date(year,month,Dlast),
    DNlast = D.getDay(),
    DNfirst = new Date(D.getFullYear(),D.getMonth(),1).getDay(),
    m = document.querySelector('#'+id+' option[value="' + D.getMonth() + '"]'),
    g = document.querySelector('#'+id+' input');

if (new Date(D.getFullYear(),D.getMonth(),1).getWeek() < 10) {
  calendar = '<tr><td>0' + new Date(D.getFullYear(),D.getMonth(),1).getWeek();
}else{
  calendar = '<tr><td>' + new Date(D.getFullYear(),D.getMonth(),1).getWeek();
}

if (DNfirst != 0) {
  for(var  i = 1; i < DNfirst; i++) calendar += '<td>';
}else{
  for(var  i = 0; i < 6; i++) calendar += '<td>';
}

for(var  i = 1; i <= Dlast; i++) {
  if (i == new Date().getDate() && D.getFullYear() == new Date().getFullYear() && D.getMonth() == new Date().getMonth()) {
    calendar += '<td class="today">' + i;
  }else{
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
    }else{
      calendar += '<td>' + i;
    }
  }
  if (new Date(D.getFullYear(),D.getMonth(),i).getDay() == 0 && i != Dlast) {
    if (new Date(D.getFullYear(),D.getMonth(),i).getWeek() < 9) {
      calendar += '<tr><td>0' + new Date(D.getFullYear(),D.getMonth(),i+1).getWeek();
    }else{
      calendar += '<tr><td>' + new Date(D.getFullYear(),D.getMonth(),i+1).getWeek();
    }
  }
}

if (DNlast != 0) {
  for(var  i = DNlast; i < 7; i++) calendar += '<td>';
}

document.querySelector('#'+id+' tbody').innerHTML = calendar;
g.value = D.getFullYear();
m.selected = true;

if (document.querySelectorAll('#'+id+' tbody tr').length < 6) {
    document.querySelector('#'+id+' tbody').innerHTML += '<tr><td>&nbsp;<td><td><td><td><td><td><td>';
}

document.querySelector('#'+id+' option[value="' + new Date().getMonth() + '"]').style.color = 'rgb(220, 0, 0)';

}

Calendar4("calendar4",new Date().getFullYear(),new Date().getMonth());
document.querySelector('#calendar4').onchange = function Kalendar4() {
  Calendar4("calendar4",document.querySelector('#calendar4 input').value,document.querySelector('#calendar4 select').options[document.querySelector('#calendar4 select').selectedIndex].value);
}
</script>



     <div class="text-center">
        <form>
             <div class="container">
             <fieldset>
             <legend><h1 class="text-center">Заказ</h1></legend>   
            Номер заказа:<br>
            <input required autofocus type="text">
            <br>
            
             Неделя:<br>
            <select>
                <option value="1"> 1</option> 
            </select>
             
            <br>
            
                Месяц:<br>
            <select>
                <option value="1"> 1</option> 
            </select>
         
            <br>
               Год:<br>
            <select>
                <option value="2017"> 2017</option> 
            </select>
        
            <br>
            Модель:<br>
             <select>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="2">3</option>
            </select>
            <br>
            Количество:<br>
            <input required type="text">
            <br>
            Модель:<br>
             <select>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="2">3</option>
            </select>
            <br>
            Количество:<br>
            <input required type="text">
            <br>
            Модель:<br>
             <select>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="2">3</option>
            </select>
            <br>
            Количество:<br>
            <input required type="text">
            <br>
            Модель:<br>
             <select>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="2">3</option>
            </select>
            <br>
            Количество:<br>
            <input required type="text">
            <br>
            Модель:<br>
             <select>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="2">3</option>
            </select>
            
            <br>
            Количество:<br>
            <input required type="text">
            <br>
            <br>
           
            <input class="btn btn-primary"  type ="submit" value="Заказать"> </input>
            <input class="btn btn-primary"  type ="submit" value="Изменить"> </input>
            <input class="btn btn-primary"  type ="submit" value="Удалить"> </input>
            
                 
             </fieldset>
        </div>
        </form>
        </div>
  
  <div class="container">
      <h2>Заказы:</h2>
    <table class="table table-bordered">
         <thead>
      <tr>
        <th>Номер заказа:</th>
      </tr>
      <tr>
         <tbody>
          <td>1</td> 
       </tr>
       </thead>
    </tbody>
</table>
</div>
</html>
