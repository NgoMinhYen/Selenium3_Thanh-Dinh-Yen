package core.framework.browsers.chrome;

import core.framework.browsers.IWebDriver;
import core.framework.commons.Constant;
import core.framework.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class LocalChromeDriver implements IWebDriver {

    /**
     * Create local chrome driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {

        try {
            //System.setProperty(Constant.CHROME_SYSTEM_PROPERTY, property.getDriverPath());
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(property.getArguments());
            options.setHeadless(property.isHeadless());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            for (String key : property.getCapabilities().keySet()) {
                capabilities.setCapability(key, property.getCapabilities().get(key));
            }
            options.merge(capabilities);

            return new ChromeDriver(options);

        } catch (Exception ex) {
            logger.error("Create local chrome driver error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
