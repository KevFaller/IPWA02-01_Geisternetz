<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <script src="https://cdn.jsdelivr.net/npm/leaflet@1.7.1/dist/leaflet.js"></script>
    <script src="map.js"></script>
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
<a href="login">Login</a><br>

<!-- Hier wird der Map-Container hinzugefügt -->
<div id="map"></div>

</body>
</html>
