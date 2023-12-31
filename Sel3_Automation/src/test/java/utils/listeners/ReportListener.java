package utils.listeners;

import com.aventstack.extentreports.Status;
import core.framework.wrappers.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.common.Utilities;
import utils.email.EmailAttachmentsSender;
import utils.email.EmailConfig;
import utils.extentreports.ExtentTestManager;

import static utils.extentreports.ExtentManager.getExtentReports;

public class ReportListener implements ITestListener {
    private static Logger logger = LogManager.getLogger(ReportListener.class);
    WebDriver driver;

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        driver = Driver.getWebDriver();
        logger.info("Start testing " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("End testing " + iTestContext.getName());
        //Finish and execute Extents Report
        try{
            getExtentReports().flush();
            EmailAttachmentsSender.sendEmailWithAttachments(EmailConfig.HOST, EmailConfig.PORT, EmailConfig.FROM,
                    EmailConfig.PASSWORD, EmailConfig.TO, EmailConfig.SUBJECT,EmailConfig.MESSAGE ,
                    ThreadContext.get("pathFileReportHTML"),
                    ThreadContext.get("pathFileReportPDF"));
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ThreadContext.put("testcaseName", getTestName(iTestResult) + " " + Utilities.toDate("yyyy-MM-dd HH-mm-ss"));
        logger.info(getTestName(iTestResult) + " test is starting...");
        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(getTestName(iTestResult) + " test is passed.");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.logMessage(Status.PASS, getTestDescription(iTestResult));
        ThreadContext.remove("testcaseName");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error(getTestName(iTestResult) + " test is failed.");

        ExtentTestManager.addScreenShot(Status.FAIL, getTestName(iTestResult));

        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.warn(getTestName(iTestResult) + " test is skipped.");
        ExtentTestManager.logMessage(Status.SKIP, getTestName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(iTestResult));
    }
}
