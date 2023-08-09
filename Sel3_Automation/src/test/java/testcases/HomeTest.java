package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.common.constants.Constant;

public class HomeTest extends BaseTest {
    HomePage homePage = HomePage.getInstance();
    LoginPage loginPage = LoginPage.getInstance();

    @Test(description = "User can Logout")
    public void LOGOUT_TC001(){
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Login successful with valid account");
        homePage = loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 3. Click Logout");
        homePage.clickLogout();

        logger.step("VP Step 3. \"Do you want to logout?\" popup is displayed");
        Assert.assertTrue(homePage.isDisplayedLogoutPopup(), "The login button cannot be clicked");

        logger.step("Step 4. Click Yes on popup");
        homePage.clickYes();

        logger.step("VP Step 4. Login page is displayed");
        Assert.assertTrue(loginPage.isDisplayedTitleAdminPortal(), "Login page is displayed");
    }
}
