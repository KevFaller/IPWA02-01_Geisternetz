<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Registrierung</title>
</head>
<body>
<h1>Bitte registriere Dich</h1>
<p>Register Formular</p><br>
<form method="post" action="register">
  <p>Bitte gib dein Vorname ein (Vorname = Username)</p>
  <input type="text" id="rVorname" name="rVorname"><br>
  <p>Bitte gib dein Nachname ein</p>
  <input type="text" id="rNachname" name="rNachname"><br>
  <p>Bitte gib dein Password ein</p>
  <input type="password" id="rPassword" name="rPassword"><br>
  <p>Bitte wiederhole dein Password</p>
  <input type="password" id="rPassword2" name="rPassword2" oninput="checkPasswordMatch();"><br>
  <p id="passwordMatchError" style="color: red; display: none;">Die Passwörter stimmen nicht überein</p>
  <p>Bitte gib deine Mailadresse ein</p>
  <input type="email" id="rMail" name="rMail"><br>
  <p>Bitte gib deine Telefonnummer ein</p>
  <input type="tel" id="rTelefon" name="rTelefon"><br>
  <input type="submit" value="registrieren">
</form>

<script>
  function checkPasswordMatch() {
    var password1 = document.getElementById("rPassword").value;
    var password2 = document.getElementById("rPassword2").value;
    var errorText = document.getElementById("passwordMatchError");

    if (password1 !== password2) {
      errorText.style.display = "block";
    } else {
      errorText.style.display = "none";
    }
  }
</script>
</body>
</html>
