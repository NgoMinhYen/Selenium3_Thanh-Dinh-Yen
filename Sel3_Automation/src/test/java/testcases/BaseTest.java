package testcases;


import core.framework.commons.Utilities;
import core.framework.driver.DriverManager;
import core.framework.driver.DriverProperty;
import core.framework.wrappers.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.common.constants.Constant;
import utils.listeners.ReportListener;
import utils.logs.Logger;

@Listeners(ReportListener.class)
public class BaseTest {

    protected     Logger logger                  = new Logger();
    private final String DEFAULT_BROWSER_SETTING = "windows.chrome.local";
    private final String FF_BROWSER_SETTING = "windows.firefox.local";
    public final String BROWSER_1 = "browser1";
    public final String BROWSER_2 = "browser2";

    public ThreadLocal<DriverProperty> thDriverProperty = new ThreadLocal<>();
    public DriverProperty property;
    public DriverProperty propertyFF;


    @Parameters({Constant.BROWSER_SETTING})
    @BeforeMethod(alwaysRun = true)
    public synchronized void createWebDriver(
            @Optional(DEFAULT_BROWSER_SETTING) String browserSetting) {

        property = Utilities.loadBrowserSetting(Constant.BROWSER_SETTING_PATH, browserSetting);

        Driver.initWebDriver(String.valueOf(Thread.currentThread().getId()), BROWSER_1, property);
        Driver.maximize();

        Driver.navigateTo(Constant.URL);
    }

//    public void openBrowser() {
//        Driver.initWebDriver(thDriverProperty.get());
//        Driver.maximize();
//    }

    @AfterMethod(alwaysRun = true)
    public void quiteBrowser(ITestResult result) {
        DriverManager.clear(String.valueOf(Thread.currentThread().getId()));
//        Driver.quitBrowser();
    }


}
