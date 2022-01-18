<%-- 
    Document   : arithemticcalculator
    Created on : Jan. 17, 2022, 5:00:23 p.m.
    Author     : Andy Diep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>

        <!--Labels and inputs for first and second number-->
        <form action="arithmetic" method="post">
            <label for="first">First:</label>
            <input type="number" name="first" id="first">
            <br>
            <label for="second">Second:</label>
            <input type="number" name="second" id="second">
            <br>
            <!--Operators-->
            <button name="calculate" value="add" type="submit"> + </button>
            <button name="calculate" value="minus" type="submit"> - </button>
            <button name="calculate" value="multiply" type="submit"> * </button>
            <button name="calculate" value="divide" type="submit"> % </button>

            <!--You can add h1 tag in button tag and not an input tag-->
        </form>

        <p>Result: ${result}</p>
        <a href="age">Age Calculator</a>

    </body>
</html>
