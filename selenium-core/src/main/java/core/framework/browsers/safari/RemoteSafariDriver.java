package core.framework.browsers.safari;

import core.framework.browsers.IWebDriver;
import core.framework.driver.DriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;


public class RemoteSafariDriver implements IWebDriver {


    /**
     * Create remote safari driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            SafariOptions options = new SafariOptions();
            URL url = new URL(property.getRemoteUrl());
            return new RemoteWebDriver(url, options);
        } catch (Exception ex) {
            logger.error("Create remote safari driver error: " + ex.getMessage());
        }
        return null;
    }
}
