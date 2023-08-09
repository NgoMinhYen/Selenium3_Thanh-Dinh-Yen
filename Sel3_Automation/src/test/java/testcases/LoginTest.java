package testcases;

import core.framework.wrappers.Driver;
import dataobjects.User;
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

    @Test(description = "Test case 002: Login with Invalid Email")
    public void LOGIN_TC002(){
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Enter an invalid email address (e.g., missing \"@\" symbol) in the email field.");
        loginPage.enterEmailAddress("abc");

        logger.step("Step 3. Enter a valid 'Password' in the password field");
        loginPage.enterPassword(Constant.USER_ADMIN.getPassword());

        logger.step("Step 4. The login button cannot be clicked");
        Assert.assertFalse(loginPage.isButtonLoginEnabled(), "The login button cannot be clicked");

        logger.step("VP Step 4. Verify that an error message is displayed \"Username invalid format\"");
        Assert.assertTrue(loginPage.isDisplayedLblInvalidUsernameErrorMessage(), "An error message is displayed \"Username invalid format\"");
    }

    @Test(description = "Test case 003: Login with Invalid Password")
    public void LOGIN_TC003(){
        User invalidUser = new User(Constant.USER_ADMIN.getUsername(), "invaliduser");

        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Enter a valid email address in the email field.");
        logger.step("Step 3. Enter an incorrect password in the password field");
        logger.step("Step 4. Click on the \"Login\" button\n Wait for the page to load");
        loginPage.login(invalidUser);

        logger.step("VP Step 4. Verify that an error message is displayed, \"Login fail \n Login credentials not valid\"");
        Assert.assertTrue(loginPage.isDisplayedLoginFailPopup(), "An error message is displayed \n \"Login fail \n Login credentials not valid\"");
    }

    @Test(description = "Test case 004: Login with Empty Fields")
    public void LOGIN_TC004(){
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Leave the email field and password field empty.");
        loginPage.enterEmailAddress("");
        loginPage.enterPassword("");
        loginPage.clickTitleAdminPortal();

        logger.step("VP Step 2. Verify that an error message is displayed indicating that both fields are required.");
        Assert.assertTrue(loginPage.isDisplayedLblRequiredUsernameErrorMessage(), "'Username is required' is displayed");
        Assert.assertTrue(loginPage.isDisplayedLblRequiredPasswordErrorMessage(), "'Password is required' is displayed");

        logger.step("Step 3. The login button cannot be clicked");
        Assert.assertFalse(loginPage.isButtonLoginEnabled(), "The login button cannot be clicked");
    }
}
