package com.example.ipwa02netz;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

    public static void logInfo(String message) {
        LOGGER.log(Level.INFO, message);
    }

    public static void logError(String message, Throwable throwable) {
        LOGGER.log(Level.SEVERE, message, throwable);
    }
}
