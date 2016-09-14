<%-- 
    Document   : allEmployee
    Created on : Sep 13, 2016, 12:30:38 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Employee</title>
        <style type="text/css">
            table, td, th {
                border: 1px solid #ddd;
                text-align: left;
            }

            table {
                border-collapse: collapse;
                width: 80%;
                margin:auto;
            }

            th, td {
                padding: 10px;
            }
        </style>

    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/allemployee.js?ver=1.0" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            showAllEmployee();
            btnAddClick();
        });
    </script>
    <body>
        <button id="btnAdd" style="margin: auto;float: right">Add Employee</button>
        <table id="myTable" >
            <caption>All Employee
            </caption>
            <colgroup align="center" valign="middle" width="30%" />
            <colgroup align="center" valign="middle" width="20%" />
            <colgroup align="center" valign="middle" width="15%" />
            <colgroup align="center" valign="middle" width="15%" />
            <colgroup align="center" valign="middle" width="15%" />
            <colgroup align="center" valign="middle" width="5%" />
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Dept</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        
    </body>
</html>
