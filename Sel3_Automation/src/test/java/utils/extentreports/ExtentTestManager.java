package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import core.framework.wrappers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.common.Utilities;
import utils.common.constants.Constant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static core.framework.browsers.IWebDriver.logger;

public class ExtentTestManager {
    /*
    Integer: ThreadId
    ExtentTest: object has been created to be used for recording test results and information
     */
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getExtentReports();

    /*
    This function is used to retrieve the ExtentTest associated with the current thread
     */
    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    /*
    This function creates an ExtentTest with the current thread ID and stores it in a extentTestMap
    The function returns the ExtentTest, allowing you to record test results and information
     */
    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public WebDriver getDriver() {
        WebDriver driver = Driver.getWebDriver();
        return driver;
    }

    public static void addScreenShot(String message) {
        String base64Image = "data:image/png;base64," + ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.INFO, message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    /*
     Add a screenshot to the test report along with a corresponding message and status
     */
    public static void addScreenShot(Status status, String message) {
        try {
            getTest().log(status,message, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotAbsolutePath(message)).build());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    /*
    Capture a screenshot and return the file path of the image
     */
    public static String getScreenshotAbsolutePath(String screenshotName) {
        //Use the Toolkit object to get the screen size, then use that size to create a Rectangle object
        Rectangle allScreenBounds = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        String sDate = Utilities.toDate("yyyy-MM-dd HH-mm-ss");
        //The captured screen will be saved into the BufferedImage object
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(allScreenBounds);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        String path = Constant.TARGET + "/ExtentReports/Images";
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String filePath = path + File.separator + screenshotName +" " + sDate + ".png";

        File file = new File(filePath);
        try {
            //Save the image data from the BufferedImage object to the file "screenshot.png" in PNG format
            ImageIO.write(image, "PNG", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filePath;
    }

    /*
     Add message to the test report
     */
    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }

    /*
     Add message and status to the test report
     */
    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }
}
