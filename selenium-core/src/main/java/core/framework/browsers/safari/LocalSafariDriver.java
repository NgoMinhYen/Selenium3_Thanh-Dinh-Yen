package core.framework.browsers.safari;

import core.framework.browsers.IWebDriver;
import core.framework.commons.Constant;
import core.framework.driver.DriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class LocalSafariDriver implements IWebDriver {

    /**
     * Create local safari driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            System.setProperty(Constant.SAFARI_WEBDRIVER_PROPERTY, property.getDriverPath());
            SafariOptions options = new SafariOptions();
            return new SafariDriver(options);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
