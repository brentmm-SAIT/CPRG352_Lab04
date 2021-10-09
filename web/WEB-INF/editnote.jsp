<%-- 
    Document   : sayHello
    Created on : Sep 22, 2021, 12:09:42 PM
    Author     : 771684
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper
            <h2>Edit Page</h2>

            <form method="POST">
                <label>Title:</label>
                <input type="text" name="title" value="${note.title}">
                <br>
                <label>Contents:</label>
                <input type="text" name="contents" value="${note.contents}">
                <br>
                <input type="submit" value="Save">               
            </form>

    </body>
</html>
