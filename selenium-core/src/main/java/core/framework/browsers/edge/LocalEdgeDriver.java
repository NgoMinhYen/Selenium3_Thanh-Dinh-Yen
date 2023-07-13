package core.framework.browsers.edge;

import core.framework.browsers.IWebDriver;
import core.framework.commons.Constant;
import core.framework.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class LocalEdgeDriver implements IWebDriver {
    /**
     * Create local edge driver
     *
     * @param property:DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            //System.setProperty(Constant.EDGE_WEBDRIVER_PROPERTY, property.getDriverPath());
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
