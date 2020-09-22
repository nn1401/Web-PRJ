<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User web</title>
    </head>
    <body>
        <h1>New User</h1>
        <hr>
        <form action="AddUser" method="POST">
            Name: <input type="text" name="txtName" value="" />
            <br>
            Password: <input type="password" name="txtPassword" value="" />
            <br>
            Gender:  <input type="radio" name="txtGender" value="Male" /> Male
            <input type="radio" name="txtGender" value="Female" /> Female
            <br>
            <input type="submit" value="Add User" />
        </form>
        <br>
        <form action="GetAll" method="POST">
            <input type="submit" value="Get All" />
        </form>
    </body>
</html>
