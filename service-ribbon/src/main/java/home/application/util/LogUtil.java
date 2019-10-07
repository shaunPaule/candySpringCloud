package home.application.util;

import java.util.logging.Logger;

public class LogUtil {
    private LogUtil(){}

    public static void logDebug(Class clz,String msg){
        Logger logger = Logger.getLogger(clz.getName());
        logger.warning(msg);
    }
}
