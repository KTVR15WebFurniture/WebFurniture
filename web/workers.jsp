<%-- 
    Document   : workers
    Created on : Dec 2, 2016, 9:19:45 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript"></script>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>Workers</title>
    </head>
    <body>
        <h1>Данные работника</h1>
        <div class="container">
            <form class="form-horizontal">   
                <div class="form-group">
                    <label class="control-label col-sm-2" for="firstname">Имя:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="firstname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lastname">Фамилия:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="lastname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="isikukood">Isikukood:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="isikukood">
                    </div>   
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="adress">Адрес:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adress">
                    </div>   
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="telefon">Телефон:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="telefon">
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info btn-lg" id="add">Добавить</button>
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="change">Изменить</button>
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Изменить данные работника</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form-horizontal">   
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="firstname">Имя:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="firstname">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="lastname">Фамилия:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="lastname">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="isikukood">Isikukood:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="isikukood">
                                                </div>   
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="adress">Адрес:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="adress">
                                                </div>   
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="telefon">Телефон:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="telefon">
                                                </div>
                                            </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>


                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="remove">Удалить</button>
                    </div>

                </div>
            </form>

        </div>
    </body>
</html>
