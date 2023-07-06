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
      var gpsField = document.getElementById("gpsField");
      var groeseField = document.getElementById("groeseField");

      if (statusSelect.value === "melden") {
        netzDropdown.style.display = "none";
        gpsField.style.display = "block";
        groeseField.style.display = "block";
      } else {
        netzDropdown.style.display = "block";
        gpsField.style.display = "none";
        groeseField.style.display = "none";
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
                        <% netzArrayCreat netzArray = new netzArrayCreat();
                          String[] geisternetzArray = netzArray.getGeisternetzArray();
                          for (String netz : geisternetzArray) { %>
                        <option value="<%= netz %>"><%= netz %></option>
                        <% } %>
                    </select>
                </div>

                <div class="text-field" id="gpsField" style="display: none;">
                    <br><label for="inputGPS">GPS Daten:</label>
                    <input
                            aria-label="GPS"
                            type="POINT"
                            id="inputGPS"
                            name="inputGPS"
                            placeholder="z.B. 34.0000 15.0000"
                            required
                    >
               </div>

               <div class="text-field" id="groeseField" style="display: none;">
                    <br><label for="inputGroese">Geschaetzte Größe:</label>
                    <input
                            aria-label="qm"
                            type="text"
                            id="inputGroese"
                            name="inputGroese"
                            placeholder="z.B. 4x4qm"
                            required
                    >
               </div>
            </div>
            <input type="submit" class="my-form__button" value="Bearbeitung">
            <div class="my-form__actions">
                <div class="my-form__row">
                </div>
            </div>
        </form>
    </span>
</body>
</html>
