

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="\css\bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Order Furniture </title>
    </head>
    <body>
 
       
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
            </div>
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
