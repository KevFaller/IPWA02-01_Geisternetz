<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Registrierung</title>
  <link rel="stylesheet" href="netz.css">
</head>

<body>
<h1>Auflistung der geisternetze</h1>
<button class="button-link" onclick="window.location.href='netzBearbeiten'">Geisternetz-Melden/Bergen</button><br>


<body>
<span class="background"></span>
<span class="centering">
            <form class="my-form" method="post" action="netz">
                 <table>
        <thead>
            <tr>
                <th>Geolocation</th>
                <th>Geschätzte Größe</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <% for (String data : (String[]) request.getAttribute("geisternetzArray")) { %>
            <% String[] deviceInfo = data.split(","); %>
            <tr>
                <% for (String info : deviceInfo) { %>
                <td><%= info.trim() %></td>
                <% } %>
            </tr>
            <% } %>
        </tbody>
    </table>
            </form>
              <script>

            </script>
        </span>
</body>
</body>
</html>
