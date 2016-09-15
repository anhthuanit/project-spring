<%-- 
    Document   : index
    Created on : Sep 13, 2016, 11:34:15 AM
    Author     : Ho Anh Thuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <script src="js/addemployee.js?ver=1.0" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            btnAddEmployeClick();
        });

    </script>
    <body>
    <caption>Create Employee
    </caption>
    <form >
        <div>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id">
        </div>

        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="age">Age:</label>
            <input type="text" id="age" name="age">
        </div>
        <div>
            <label for="dept">Dept:</label>
            <input type="text" id="dept" name="dept">
        </div>
        <div>
            <label for="salary">Salary :</label>
            <input type="text" id="salary" name="salary">
        </div>
         
        <div class="button">
            <button type="button" id="btnAddEmployee">Add</button>
        </div>
    </form>
</body>
</html>
