package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.common.constants.Constant;

public class LoginTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();

    @Test(description = "Test case 001: User can login with valid account")
    public void LOGIN_TC001(){
        
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Enter a valid 'Email address' in the email field");
        logger.step("Step 3. Enter a valid 'Password' in the password field");
        logger.step("Step 4. Click on the \"Login\" button");
        loginPage.login(Constant.USER_ADMIN);

        logger.info("Wait for the page to load");
        logger.step("VP Step 4: Login successfully.");
        Assert.assertTrue(homePage.isDisplayedHomePage(), "Login successfully");
    }
}
