package core.framework.browsers.edge;

import core.framework.browsers.IWebDriver;
import core.framework.driver.DriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class RemoteEdgeDriver implements IWebDriver {

    /**
     * Create remote edge driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            EdgeOptions options = new EdgeOptions();
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
