package core.framework.browsers.firefox;

import core.framework.browsers.IWebDriver;
import core.framework.commons.Constant;
import core.framework.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class LocalFirefoxDriver implements IWebDriver {

    /**
     * Create local firefox driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            //System.setProperty(Constant.FIREFOX_WEBDRIVER_PROPERTY, property.getDriverPath());
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(property.getArguments());
            options.setHeadless(property.isHeadless());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);

            return new FirefoxDriver(options);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
