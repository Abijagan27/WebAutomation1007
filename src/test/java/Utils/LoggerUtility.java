package Utils;


import java.util.logging.Logger;

public class LoggerUtility {

    // Creating a static logger instance for this class
    private static final Logger logger = Logger.getLogger(String.valueOf(LoggerUtility.class));

    // Log an INFO message
    public static void logInfo(String message) {
        logger.info(message);
    }

}
