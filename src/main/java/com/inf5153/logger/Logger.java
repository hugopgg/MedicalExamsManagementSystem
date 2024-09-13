package com.inf5153.logger;

/**
 * Interface for logging messages with different severity levels.
 */
public interface Logger {

    /**
     * Logs an informational message.
     *
     * @param message The message to log
     */
    void info(String message);

    /**
     * Logs a warning message.
     *
     * @param message The message to log
     */
    void warn(String message);

    /**
     * Logs a debug message.
     *
     * @param message The message to log
     */
    void debug(String message);

    /**
     * Logs an error message.
     *
     * @param message The message to log
     */
    void error(String message);
}
