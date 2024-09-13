package com.inf5153.logger;

/**
 * Implementation of the Logger interface that logs messages to the console.
 */
public class ConsoleLogger implements Logger {

    /**
     * Logs an informational message to the console.
     *
     * @param message The message to log
     */
    @Override
    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    /**
     * Logs a warning message to the console.
     *
     * @param message The message to log
     */
    @Override
    public void warn(String message) {
        System.out.println("[WARN] " + message);
    }

    /**
     * Logs a debug message to the console.
     *
     * @param message The message to log
     */
    @Override
    public void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }

    /**
     * Logs an error message to the console.
     *
     * @param message The message to log
     */
    @Override
    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }

}
