<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1><%= "Ich bin die Startseite" %></h1><br>

  <%//so laesst sich javacode schreiben
      if (request.getAttribute("Hallo") != null) {
          String esel = (String) request.getAttribute("Hallo");
          out.println("Hallo Lord: " + esel);
      }
  %>

<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="login">Login</a>
</body>
</html>