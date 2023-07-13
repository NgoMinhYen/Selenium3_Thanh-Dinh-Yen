package core.framework.browsers;

import core.framework.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public interface IWebDriver {
    Logger logger = LogManager.getLogger();

    /**
     * Create web driver from driver property
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    WebDriver createWebDriver(DriverProperty property);
}
