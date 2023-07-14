package testcases;


import core.framework.commons.Utilities;
import core.framework.driver.DriverProperty;
import core.framework.wrappers.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.common.constants.Constant;
import utils.listeners.ReportListener;
import utils.logs.Logger;

import java.io.IOException;

@Listeners(ReportListener.class)
public class BaseTest {

    protected     Logger logger                  = new Logger();
    private final String DEFAULT_BROWSER_SETTING = "windows.chrome.local";

    private ThreadLocal<DriverProperty> thDriverProperty = new ThreadLocal<>();


    @Parameters({Constant.BROWSER_SETTING})
    @BeforeMethod(alwaysRun = true)
    public void createWebDriver(
            @Optional(DEFAULT_BROWSER_SETTING) String browserSetting) {

        DriverProperty property = Utilities.loadBrowserSetting(Constant.BROWSER_SETTING_PATH, browserSetting);
        thDriverProperty.set(property);
        Driver.initWebDriver(property);
        Driver.maximize();
//        Driver.navigateTo(Constant.URL);
    }

    public void openBrowser() {
        Driver.initWebDriver(thDriverProperty.get());
        Driver.maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void quiteBrowser(ITestResult result) throws IOException {
        Driver.quitBrowser();
    }


}
