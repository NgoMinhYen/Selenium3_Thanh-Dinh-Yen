package utils.listeners;

import core.framework.wrappers.Driver;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.getLifecycle;

public class AllureReportListener implements ITestListener {
    private static Logger logger = LogManager.getLogger(AllureReportListener.class);

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Attachment(type = "image/png")
    public void saveScreenshotPNG() {
        try {
            File file = Driver.takesScreenshot();
            addAttachment("screenshots", FileUtils.openInputStream(file));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Start testing " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("End testing " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(getTestName(iTestResult) + " test is starting...");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(getTestName(iTestResult) + " test is passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error(getTestName(iTestResult) + " test is failed.");
        saveTextLog(getTestName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.warn(getTestName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
    }
}
