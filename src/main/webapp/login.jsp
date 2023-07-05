<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCUMENTYP html>
<html>
<header>
    <title>Login Example</title>
    <link rel="stylesheet" href="login.css">
</header>
<body>
<span class="background"></span>
<span class="centering">
            <form class="my-form" method="post" action="login">
                <span class="login-welcome-row">
                    <img
                            class="login-welcome"
                            src="Bild-Bert1.png"
                    />
                    <!-- optimize the image in production -->
                    <h1>LogIn!</h1>
                </span>
                <div class="text-field">
                    <%--@declare id="email"--%><label for="email">Email:</label>
                    <input
                            aria-label="Email"
                            type="email"
                            id="username"
                            name="username"
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
                    <label for="password">Password:</label>
                    <input
                            id="password"
                            type="password"
                            aria-label="Password"
                            name="password"
                            placeholder="Your Password"

                    >
                    <img
                            alt="Password Icon"
                            title="Password Icon"
                            src="password.svg"
                    >
                </div>
                <input type="submit" class="my-form__button" value="Login" />
                <div class="my-form__actions">
                    <div class="my-form__row">
                    </div>
                    <div class="my-form__signup">
                        <a href="register" title="Create Account">Create Account</a>
                    </div>
                </div>
            </form>
        </span>
<script src=""></script>
</body>
</html>
