package cn.tj.baseextweb.fw.helper;

import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtil {

    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARN = 2;
    public static final int ERROR = 3;

    public static final Object[] emptyParams = new Object[0];

    public static final Level[] levelObjs = { Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR };

    public static final String defaultModule = "cn.tj.baseextweb";

    public static void log(int level, Throwable t, String msg, String module, Object... params) {
        Logger logger = Logger.getLogger(module);
        String finalMsg = MessageFormat.format(msg, params);
        logger.log(levelObjs[level], finalMsg, t);
    }

    public static void logDebug(String msg) {
        log(DEBUG, null, msg, defaultModule, emptyParams);
    }

    public static void logDebug(String msg, String module) {
        log(DEBUG, null, msg, module, emptyParams);
    }

    public static void logDebug(String msg, String module, Object... params) {
        log(DEBUG, null, msg, module, params);
    }

    public static void logInfo(String msg) {
        log(INFO, null, msg, defaultModule, emptyParams);
    }

    public static void logInfo(String msg, String module) {
        log(INFO, null, msg, module, emptyParams);
    }

    public static void logInfo(String msg, String module, Object... params) {
        log(INFO, null, msg, module, params);
    }

    public static void logWarn(String msg) {
        log(WARN, null, msg, defaultModule, emptyParams);
    }

    public static void logWarn(String msg, String module) {
        log(WARN, null, msg, module, emptyParams);
    }

    public static void logWarn(String msg, String module, Object... params) {
        log(WARN, null, msg, module, params);
    }

    public static void logError(String msg) {
        log(ERROR, null, msg, defaultModule, emptyParams);
    }

    public static void logError(String msg, String module) {
        log(ERROR, null, msg, module, emptyParams);
    }

    public static void logErrorWithException(String msg, String module) {
        Exception e = new Exception(msg);
        log(ERROR, e, msg, module, emptyParams);
    }

    public static void logError(String msg, String module, Throwable t) {
        log(ERROR, t, msg, module, emptyParams);
    }

    public static void logError(String msg, String module, Object... params) {
        log(ERROR, null, msg, module, params);
    }

    public static void logError(String msg, String module, Throwable t, Object... params) {
        log(ERROR, t, msg, module, params);
    }
}
