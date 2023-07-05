package com.example.ipwa02netz;

public class sqlScriptCreat {

    public static String getSQLScript() {
        StringBuilder sqlScript = new StringBuilder();

        // Erstelle die Tabelle "Status"
        sqlScript.append("CREATE TABLE Status (")
                .append("Status_ID SERIAL PRIMARY KEY,")
                .append("Statusname VARCHAR(255)")
                .append(");\n");

        // Füge Daten in die Tabelle "Status" ein
        sqlScript.append("INSERT INTO Status (Statusname) VALUES ")
                .append("('Gemeldet'), ")
                .append("('Bergung bevorstehend'), ")
                .append("('Geborgen'), ")
                .append("('Verschollen');");

        // Erstelle die Tabelle "Geisternetz"
        sqlScript.append("CREATE TABLE Geisternetz (")
                .append("Geisternetz_ID SERIAL PRIMARY KEY,")
                .append("Geolocation VARCHAR(255),")
                .append("GeschaetzteGroesse VARCHAR(255),")
                .append("Status_ID INT,")
                .append("FOREIGN KEY (Status_ID) REFERENCES Status(Status_ID)")
                .append(");\n");

        // Füge Datensätze in die Tabelle "Geisternetz" ein
        sqlScript.append("INSERT INTO Geisternetz (Geolocation, GeschaetzteGroesse, Status_ID) VALUES ")
                .append("('POINT(35.0000 15.0000)', '3x3qm', 1), ")
                .append("('POINT(0.0000 -25.0000)', '4x4qm', 2), ")
                .append("('POINT(54.0000 3.0000)', '5x5qm', 4);\n");

        // Erstelle die Tabelle "Person"
        sqlScript.append("CREATE TABLE Person (")
                .append("Person_ID SERIAL PRIMARY KEY,")
                .append("Vorname VARCHAR(255),")
                .append("Nachname VARCHAR(255),")
                .append("Mailadresse VARCHAR(255),")
                .append("Password VARCHAR(255),")
                .append("Telefonnummer VARCHAR(255)")
                .append(");\n");

        // Füge Datensätze in die Tabelle "Person" ein
        sqlScript.append("INSERT INTO Person (Vorname, Nachname, Mailadresse, Password, Telefonnummer) VALUES ")
                .append("('admin', 'admin', 'admin@admin.de', 'admin', '123456');");

        // Erstelle die Tabelle "Bergung"
        sqlScript.append("CREATE TABLE Bergung (")
                .append("Bergung_ID SERIAL PRIMARY KEY,")
                .append("Geisternetz_ID INT,")
                .append("Person_ID INT,")
                .append("FOREIGN KEY (Geisternetz_ID) REFERENCES Geisternetz(Geisternetz_ID),")
                .append("FOREIGN KEY (Person_ID) REFERENCES Person(Person_ID)")
                .append(");\n");

        MyLogger.logInfo("** INFO **  Der SQL-String wurde erstellt");
        return sqlScript.toString();
    }
}
