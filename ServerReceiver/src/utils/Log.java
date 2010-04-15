package utils;

import model.Errors;

/**
 * Wrapper of Logger class
 * @author riza
 */
public class Log {
    public static void warning(Errors pError, String pMessage) {
        System.out.println(pError + " " + pMessage);
    }

    public static void severe(Errors pError, String pMessage) {
        System.out.println(pError + " " + pMessage);
    }

    public static void warning(Errors pError, String pMessage, Exception ex) {
        System.out.println(pError + " " + pMessage);
    }

    public static void severe(Errors pError, String pMessage, Exception ex) {
        System.out.println(pError + " " + pMessage);
    }

    public static void info(String pMessage) {
        System.out.println(pMessage);
    }

    public static void write(String pMessage) {
        System.out.println(pMessage);
    }
}
