package core.framework.wrappers;

import core.framework.driver.DriverFactory;
import core.framework.driver.DriverProperty;
import core.framework.elements.Element;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Set;


public class Driver extends DriverFactory {
	
	private static Logger logger        = LoggerFactory.getLogger(Element.class);

    public static void initWebDriver(DriverProperty property) {
        createWebDriver(property);
    }

    /**
     * Get WebDriver stored in ThreadLocal
     *
     * @return WebDriver
     */
    public static WebDriver getWebDriver() {
        return threadWebDriver.get();
    }

    /**
     * Set maximize chrome window size
     */
    public static void maximize() {
        getWebDriver().manage().window().maximize();
    }

    /**
     * Navigate browser to a url
     *
     * @param url: <a href="https://example.com">example.com</a>
     */
    public static void navigateTo(String url) {
    	logger.info(String.format("Navigating to '%s'", url));
        getWebDriver().get(url);
    }

    /**
     * Goes to the previous page in your browsing history for the tab.
     */
    public static void back() {
        getWebDriver().navigate().back();
    }

    /**
     * Reload current page
     */
    public static void refresh() {
        getWebDriver().navigate().refresh();
    }

    /**
     * The driver.close() command is used to close the current browser window having focus.
     * In case there is only one browser open then calling driver.close() quits the whole browser session.
     */
    public static void closeBrowser() {
        getWebDriver().close();
    }

    /**
     * The driver.quit() is used to quit the whole browser session along with all the associated browser windows, tabs and pop-ups.
     */
    public static void quitBrowser() {
        getWebDriver().quit();
    }

    /**
     * The method getTitle() is used to obtain the present page title and then we can get the result in the console.
     *
     * @return title current page
     */
    public static String getTile() {
        return getWebDriver().getTitle();
    }

    /**
     * Switch to new tab
     */
    public static void switchToNewTab() {
        String[] windowHandles = getWindowHandles();
        getWebDriver().switchTo().window(windowHandles[windowHandles.length - 1]);
    }

    /**
     * Switch to first tab
     */
    public static void switchToFirstTab() {
        String[] windowHandles = getWindowHandles();
        getWebDriver().switchTo().window(windowHandles[0]);
    }

    /**
     * Switch to new window browser
     */
    public static void switchToNewWindow() {
        getWebDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    /**
     * Get window handles
     *
     * @return String array hashcode for each browser
     */
    public static String[] getWindowHandles() {
        Set<String> windowHandles = Driver.getWebDriver().getWindowHandles();
        return windowHandles.toArray(new String[windowHandles.size()]);
    }

    public static File takesScreenshot(){
        File file = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        return file;
    }


}
