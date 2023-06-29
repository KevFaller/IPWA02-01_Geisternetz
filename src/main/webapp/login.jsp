<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCUMENTYP html>
<html>
<head>
    <meta charset="utf-8">
    <title>loginX</title>
</head>
    <body>
        <h1>Login Seite</h1>
        <form method="post" action="login">
            <label for="username">Username</label><br>
            <input type="text" id="username" name="username"><br>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="Submit">
        </form>
        <a href="register">Registrieren</a>
    </body>
</html>
