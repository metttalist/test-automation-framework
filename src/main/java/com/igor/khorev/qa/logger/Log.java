package com.igor.khorev.qa.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by metttalist on 8/14/18.
 */
public class Log {

   private final Logger logger;

    public Log(String logName) {
        this.logger = LoggerFactory.getLogger(logName);
    }

    public Log(Class clazz) {
        this(clazz.getName());
    }

    /**
     * Logs a message object with DEBUG level.
     *
     * @param message - text message to log for debug.
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * Logs a message object with DEBUG level including the stack trace of the Throwable passed as argument.
     *
     * @param message   - text message to log for debug.
     * @param throwable - exception to log ,including its stacktrace.
     */
    public void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    /**
     * Logs a message object with DEBUG level.
     *
     * @param message - text message to log for debug.
     * @param args    - list of arguments.
     */
    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    /**
     * Logs a message object with ERROR level.
     *
     * @param message - text message to log for error.
     */
    public void error(String message) {
        logger.error(message);
    }

    /**
     * Logs a message object with ERROR level including the stack trace of the Throwable passed as argument.
     *
     * @param message   - text message to log for error.
     * @param throwable - exception to log ,including its stacktrace.
     */
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    /**
     * Logs a message object with ERROR level.
     *
     * @param message - text message to log for error.
     * @param args    -
     */
    public void error(String message, Object... args) {
        logger.error(message, args);
    }

    /**
     * Logs a message object with INFO level.
     *
     * @param message - text message to log for info.
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     *  Logs a message object with INFO level including the stack trace of the Throwable passed as argument.
     *
     * @param message   - text message to log for debug.
     * @param throwable - exception to log ,including its stacktrace.
     */
    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    /**
     * Logs a message object with INFO level.
     *
     * @param message - text message to log for info.
     * @param args    -
     */
    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    /**
     * Logs a message object with TRACE level.
     *
     * @param message - text message to log for trace.
     */
    public void trace(String message) {
        logger.trace(message);
    }

    /**
     * Logs a message object with TRACE level including the stack trace of the Throwable passed as argument.
     *
     * @param message   - text message for debug.
     * @param throwable - exception to log ,including its stacktrace.
     */
    public void trace(String message, Throwable throwable) {
        logger.trace(message, throwable);
    }

    /**
     * Logs a message object with TRACE level.
     *
     * @param message - text message to log for trace.
     * @param args    -
     */
    public void trace(String message, Object... args) {
        logger.trace(message, args);
    }

    /**
     * Logs a message object with WARN level.
     *
     * @param message - text message to log for warn.
     */
    public void warn(String message) {
        logger.debug(message);
    }

    /**
     * Logs a message object with WARN level including the stack trace of the Throwable passed as argument.
     *
     * @param message   - text message to log for warn.
     * @param throwable - exception to log ,including its stacktrace.
     */
    public void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    /**
     * Logs a message object with WARN level.
     *
     * @param message - text message to log for debug.
     * @param args    - list of arguments.
     */
    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }
}
