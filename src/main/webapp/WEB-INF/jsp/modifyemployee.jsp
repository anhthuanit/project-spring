<%-- 
    Document   : modifiEmployee
    Created on : Sep 13, 2016, 12:31:00 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Employee </title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/modifyemployee.js?ver=1.0" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            showEmployee();
            btnUpdateClick();
        });
       
    </script>
    <body>
        <caption>Modify Employee
            </caption>
        <form>
              <div>
                    <label for="id">ID:</label>
                    <input type="text" disabled="true" id="id" name="id">
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
                    <button type="button" id="btnUpdate">Edit</button>
                  </div>
        </form>
    </body>
</html>
