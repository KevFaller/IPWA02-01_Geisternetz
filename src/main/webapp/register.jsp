<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCUMENTYP html>
<html>
<head>
    <meta charset="utf-8">
    <title>Regestrierung</title>
</head>
<body>
  <h1>Bitte registriere Dich</h1>
  <p>Register Formular</p><br>
    <form method="post" action="register">
      <p>Bitte gib dein Vorname ein</p>
      <input type="text" id="rVorname" name="rVorname"><br>
      <p>Bitte gib dein Nachname ein</p>
      <input type="text" id="rNachname" name="rNachname"><br>
      <p>Bitte gib dein Password ein</p>
      <input type="text" id="rPassword" name="rPassword"><br>
      <p>Bitte wiederhole dein Password </p>
      <input type="text" id="rPassword2" name="rPassword2"><br>
      <input type="submit" value="registrieren">
    </form>
</body>
</html>
