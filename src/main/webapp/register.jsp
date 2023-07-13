<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Registrierung</title>
  <link rel="stylesheet" href="register.css">
</head>

<body>
<h1>Bitte registriere Dich</h1>
<p>Register Formular</p><br>


<body>
<span class="background"></span>
<span class="centering">
            <form class="my-form" method="post" action="register">
                <span class="login-welcome-row">
                    <img
                            class="login-welcome"
                            src="Bild-Bert1.png"
                    />

                    <h1>Registrieren!</h1>
                </span>
              <div class="text-field">
                    <%--@declare id="email"--%><label for="rVorname">Vorname:</label>
                    <input
                            aria-label="Vorname"
                            type="text"
                            id="rVorname"
                            name="rVorname"
                            placeholder="Vorname"
                            required
                    >

                </div>
              <div class="text-field">
                    <label for="rNachname">Nachname:</label>
                    <input
                            aria-label="Nachname"
                            type="text"
                            id="rNachname"
                            name="rNachname"
                            placeholder="Nachname"
                            required
                    >

                </div>
                <div class="text-field">
                    <%--@declare id="email"--%><label for="rMail">Email:</label>
                    <input
                            aria-label="Email"
                            type="email"
                            id="rMail"
                            name="rMail"
                            placeholder="Your Email"
                            required
                    >
                    <img
                            alt="Email Icon"
                            title="Email Icon"
                            src="email.svg"
                    >
                </div>
                <div class="text-field">
                    <label for="rPassword">Password:</label>
                    <input
                            id="rPassword"
                            type="password"
                            aria-label="Password"
                            name="rPassword"
                            placeholder="Your Password"

                    >
                    <img
                            alt="Password Icon"
                            title="Password Icon"
                            src="password.svg"
                    >
                </div>
              <div class="text-field">
                    <label for="rPassword2">Password:</label>
                    <input
                            id="rPassword2"
                            type="password"
                            aria-label="Password"
                            name="rPassword2"
                            placeholder="Your Password"
                            oninput="checkPasswordMatch()";

                    >
                    <img
                            alt="Password Icon"
                            title="Password Icon"
                            src="password.svg"
                    >
                </div>
               <div class="text-field">
                   <p id="passwordMatchError" style="color: red; display: none;">Die Passwörter stimmen nicht überein</p>
                     <label for="rTelefon">Telefon:</label>
                    <input
                            aria-label="Telefon"
                            type="tel"
                            id="rTelefon"
                            name="rTelefon"
                            placeholder="Telefonnummer"
                            required
                    >

                </div>
                <input type="submit" class="my-form__button" value="Registrieren" />
                <div class="my-form__actions">
                    <div class="my-form__row">
                    </div>

                </div>
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
        </span>
</body>
</body>
</html>
