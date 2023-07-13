package core.framework.browsers.chrome;

import core.framework.browsers.IWebDriver;
import core.framework.driver.DriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class RemoteChromeDriver implements IWebDriver {

    /**
     * Create remote chrome driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            ChromeOptions options = new ChromeOptions();
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
