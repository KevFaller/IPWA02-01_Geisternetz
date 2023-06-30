package com.example.ipwa02netz;

public class sqlScriptCreat {

    public static String getSQLScript() {
        StringBuilder sqlScript = new StringBuilder();

        // Erstelle die Tabelle "Status"
        sqlScript.append("CREATE TABLE Status (")
                .append("Status_ID SERIAL PRIMARY KEY,")
                .append("Statusname VARCHAR(255)")
                .append(");\n");

        // Erstelle die Tabelle "Geisternetz"
        sqlScript.append("CREATE TABLE Geisternetz (")
                .append("Geisternetz_ID SERIAL PRIMARY KEY,")
                .append("Standort POINT,")
                .append("GeschaetzteGroesse VARCHAR(255),")
                .append("Status_ID INT,")
                .append("FOREIGN KEY (Status_ID) REFERENCES Status(Status_ID)")
                .append(");\n");

        // Erstelle die Tabelle "Person"
        sqlScript.append("CREATE TABLE Person (")
                .append("Person_ID SERIAL PRIMARY KEY,")
                .append("Vorname VARCHAR(255),")
                .append("Nachname VARCHAR(255),")
                .append("Mailadresse VARCHAR(255),")
                .append("Password VARCHAR(255),")
                .append("Telefonnummer VARCHAR(255)")
                .append(");\n");

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
