package utils.logs;

import core.framework.wrappers.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import static io.qameta.allure.Allure.getLifecycle;

/**
 * Custom logger
 *
 */
public class Logger {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    public void step(String message) {
        logger.info(message);

        final String uuid = UUID.randomUUID().toString();
        getLifecycle().startStep(uuid, new StepResult().setName(message).setStatus(Status.PASSED));

        try {
            File src = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);
            getLifecycle().addAttachment(uuid, "image/png", ".png", Files.readAllBytes(src.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getLifecycle().stopStep(uuid);

    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

}
