<%-- 
    Document   : agecalculator
    Created on : Jan. 15, 2022, 4:35:16 p.m.
    Author     : andyd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        
        <form action="age" method="post">
            <label for="age">Enter your age:</label>
            <input type="number" name="age" id="age">
            
            <button type="submit">Submit</button> <!-- You can add h1 tag in button tag and not an input tag-->
        </form>
        
        <p>${message}</p>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
