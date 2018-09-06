<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

    <title>Result</title>
</head>

<body>

<div class='well'>
    <h1>PunchLine</h1>
    <br/><br/>
    <table class='table'>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>punchline</th>

        </tr>
        <tr>
            <td>${firstname}</td>
            <td>${lastname}</td>
            <td>${punchline}</td>
        </tr>

    </table>

    <br/><br/>
</div>

</body>
</html>

