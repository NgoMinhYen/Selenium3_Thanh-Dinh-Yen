package utils.logs;

import org.apache.logging.log4j.LogManager;
import utils.extentreports.ExtentTestManager;
import com.aventstack.extentreports.Status;

/**
 * Custom logger
 *
 */
public class Logger {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    public void step(String message) {
        logger.info(message);
        ExtentTestManager.logMessage(message);
    }

    public void info(String message) {
        ExtentTestManager.logMessage(message);
        logger.info(message);
    }

    public void warn(String message) {
        ExtentTestManager.logMessage(Status.WARNING,message);
        logger.warn(message);
    }

    public void error(String message) {
        ExtentTestManager.logMessage(Status.FAIL, message);
        logger.error(message);
    }

    public void fatal(String message) {
        ExtentTestManager.logMessage(message);
        logger.fatal(message);
    }

    public void debug(String message) {
        ExtentTestManager.logMessage(message);
        logger.debug(message);
    }

}
