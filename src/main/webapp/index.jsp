<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<header>
<h1><%= "Geisternetze" %></h1><br>

<%//so laesst sich javacode schreiben
    if (request.getAttribute("Hallo") != null) {
        String esel = (String) request.getAttribute("Hallo");
        out.println("Hallo Lord: " + esel);
    }
%>
<%@ page import="com.example.ipwa02netz.DatabaseInitialization" %>
<%
    // Datenbank initialisieren
    DatabaseInitialization.initializeDatabase();
%>

<br/>
<a href="login">Login</a>
<a href="world">Weltkarte</a><br>

    <button class="button-link" onclick="window.location.href='login'">Login</button>
    <button class="button-link" onclick="window.location.href='world'">Weltkarte</button><br>

</header>
</div id=artikel>
<p>Geisternetze sind ein ernstes Problem, das die Meeres<a href="world">Welt</a> plagt. Diese verlorenen oder absichtlich zurückgelassenen Fischernetze können jahrelang in den Ozeanen treiben und verursachen erhebliche Schäden für die marinen Ökosysteme.</p>
<p>Einer der Hauptgründe ist, dass sie zu einer unsichtbaren Falle für Meereslebewesen werden. Fische, Meeressäuger, Schildkröten und andere Tiere können sich in den Netzen verfangen und dadurch ertrinken oder schwer verletzt werden. Dies führt zu einem dramatischen Rückgang der Artenvielfalt und einer Störung des natürlichen Gleichgewichts in den Ozeanen.</p>
<p>Ein weiteres Problem ist die langfristige Verschmutzung der Meeresumwelt. Geisternetze bestehen oft aus nicht biologisch abbaubaren Materialien wie Kunststoff, die Jahrzehnte oder sogar Jahrhunderte benötigen, um zu zerfallen. Währenddessen setzen sie Mikroplastikpartikel frei, die von Meeresorganismen aufgenommen werden und letztendlich in die Nahrungskette gelangen können. Dies hat weitreichende Auswirkungen auf die Gesundheit der Tiere und letztendlich auch auf den Menschen.</p>
<p>Es ist daher von größter Bedeutung, dass die <a href="world">Welt</a> sich gemeinsam bemüht, dieses Problem anzugehen. Maßnahmen wie die verstärkte Überwachung der Fischereiaktivitäten, die Förderung von umweltfreundlicheren Fischereimethoden und die verstärkte Aufräumaktionen zur Entfernung von Geisternetzen aus den Ozeanen sind dringend erforderlich. Nur durch eine kollektive Anstrengung kann die <a href="world">Welt</a> den Schutz der Meeresumwelt und die Erhaltung der Artenvielfalt gewährleisten.</p>
</div>


<footer>

</footer>
</body>
</html>
