<%@ page import="com.example.ipwa02netz.netzArrayCreat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="netzBearbeiten.css">
  <script>
    function toggleNetzDropdown() {
      var statusSelect = document.getElementById("status");
      var netzDropdown = document.getElementById("netz");

      if (statusSelect.value === "verschollen" || statusSelect.value === "bergen") {
        netzDropdown.style.display = "block";
      } else {
        netzDropdown.style.display = "none";
      }
    }
  </script>
</head>
<body>
<span class="background"></span>
<span class="centering">
        <form class="my-form" method="post" action="netzBearbeiten">
            <span class="login-welcome-row">
                <img class="login-welcome" src="Bild-Bert1.png" />
              <!-- optimize the image in production -->
                <h1>Geisternetz Melden / Bergen!</h1>
            </span>
            <div class="text-field">
                <label for="Status">Ich möchte ein Geisternetz:</label>
                <select name="status" id="status" onchange="toggleNetzDropdown()">
                    <option value="melden">Melden</option>
                    <option value="bergen">Bergen</option>
                    <option value="verschollen">Verschollen</option>
                </select><br>

                <div id="netz" style="display: none;">
                    <label for="netz">Netz:</label>
                    <select name="netz" id="netzDropdown">
                        <%
                          // Instanz der netzArrayCreat-Klasse erstellen
                          netzArrayCreat netzArray = new netzArrayCreat();
                          // Geisternetz-Array abrufen
                          String[] geisternetzArray = netzArray.getGeisternetzArray();
                          // Schleife über das Geisternetz-Array
                          for (String netz : geisternetzArray) {
                        %>
                        <option value="<%= netz %>"><%= netz %></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <input type="submit" class="my-form__button" value="Bearbeitung" />
            <div class="my-form__actions">
                <div class="my-form__row">
                </div>
            </div>
        </form>
        <script>
            // JavaScript-Code hier einfügen, falls benötigt
        </script>
    </span>
</body>
</html>
