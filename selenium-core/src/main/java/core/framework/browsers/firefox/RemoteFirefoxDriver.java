package core.framework.browsers.firefox;

import core.framework.browsers.IWebDriver;
import core.framework.driver.DriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class RemoteFirefoxDriver implements IWebDriver {

    /**
     * Create remote firefox driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(property.getArguments());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            for (String key : property.getCapabilities().keySet()) {
                capabilities.setCapability(key, property.getCapabilities().get(key));
            }
            options.merge(capabilities);
            URL url = new URL(property.getRemoteUrl());
            return new RemoteWebDriver(url, options);
        } catch (Exception ex) {
            logger.error("Create remote chrome driver error: " + ex.getMessage());
        }
        return null;
    }
}
