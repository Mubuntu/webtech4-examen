<%@ page language='java' contentType='text/html; charset=UTF-8'
         pageEncoding='UTF-8' %>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>

    <link rel='stylesheet' href='/resources/css/bootstrap.min.css'>
    <script type='text/javascript' src='/resources/js/app.js'></script>

    <title>Grade a student</title>
</head>

<body>

<div class='well'>
    <h1>lets get to cracking</h1>
    <br/>
    <form method=POST action='joke_post' onsubmit='return validate()'>
        <div class='form-group row'>
            <div class='col-xs-4'>
                <label for='firstName'>First Name : </label>
                <input type='text' class='form-control' name='firstName' id='firstName'>
            </div>
        </div>
        <div class='form-group row'>
            <div class='col-xs-4'>
                <label for='lastName'>Last Name : </label>
                <input type='text' class='form-control' name='lastName' id='lastName'>
            </div>
        </div>
        <%--<div class='form-group row'>--%>
            <%--<div class='col-xs-4'>--%>
                <%--<label for='grade'>Grade : </label>--%>
                <%--<input type='text' class='form-control' name='grade' id='grade'>--%>
            <%--</div>--%>
        <%--</div>--%>

        <input type=SUBMIT value='Save'>
    </form>

    <br/><br/>
    <%--<a href='/list'>List all students</a>--%>
</div>

</body>
</html>