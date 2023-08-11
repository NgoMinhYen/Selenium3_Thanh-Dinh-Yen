package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.common.constants.Constant;
import utils.enums.LeftMenu;
import utils.enums.Message;
import utils.enums.UserActions;

public class HomePageTest extends BaseTest {
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
        homePage.selectTitle(LeftMenu.LOGOUT.getValue());

        logger.step("VP Step 3. \"Do you want to logout?\" popup is displayed");
        Assert.assertTrue(homePage.isDisplayedEleOnPopup(Message.DO_YOU_WANT_TO_LOGOUT.getValue()), "The login button cannot be clicked");

        logger.step("Step 4. Click Yes on popup");
        homePage.clickElement(UserActions.YES.getValue());

        logger.step("VP Step 4. Login page is displayed");
        Assert.assertTrue(loginPage.isDisplayedTitleAdminPortal(), "Login page is displayed");
    }
}
