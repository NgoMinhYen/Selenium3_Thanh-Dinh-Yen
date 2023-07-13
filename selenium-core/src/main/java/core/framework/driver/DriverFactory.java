package core.framework.driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Create WebDriver from configuration
 *

 */
public class DriverFactory {

    protected static ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<>();
    private static   Logger                 logger          = LoggerFactory.getLogger(DriverFactory.class);

    /**
     * Create web driver by property config
     *
     * @param property: browser, driverPath, remoteUrl, isHeadless, isRemote, arguments, prefs, capabilities
     * @return WebDriver
     */
    public static WebDriver createWebDriver(DriverProperty property) {
        WebDriver driver;
        logger.info(String.format("Create webdriver on %s, remote=%s", property.getBrowser(), property.getMode()));

        String className = String.format("core.framework.browsers.%s.%s%sDriver", StringUtils.lowerCase(property.getBrowser()), StringUtils.capitalize(property.getMode()), StringUtils.capitalize(property.getBrowser()));
        logger.info("Create webdriver " + className);
        try {
            Class<?> clazz  = Class.forName(className);
            Object   obj    = clazz.getDeclaredConstructor().newInstance();
            Method   method = clazz.getDeclaredMethod("createWebDriver", DriverProperty.class);
            driver = (WebDriver) method.invoke(obj, property);
            threadWebDriver.set(driver);
            return threadWebDriver.get();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

}
