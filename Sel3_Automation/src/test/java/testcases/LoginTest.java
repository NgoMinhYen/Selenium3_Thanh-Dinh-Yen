package testcases;

import core.framework.wrappers.Driver;
import dataobjects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.common.constants.Constant;
import utils.enums.EntityFields;
import utils.enums.Message;

public class LoginTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();

    @Test(description = "User can login with valid account")
    public void LOGIN_TC001(){
        logger.step("Step 1. Navigate to the login page");
        logger.step("Step 2. Enter a valid 'Email address' in the email field");
        logger.step("Step 3. Enter a valid 'Password' in the password field");
        logger.step("Step 4. Click on the \"Login\" button");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.info("Wait for the page to load");
        logger.step("VP Step 4: Login successfully.");
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()), "Login successfully");
    }

    @Test(description = "User can Login with Invalid Email")
    public void LOGIN_TC002(){
        logger.step("Step 1. Navigate to the login page");
        logger.step("Step 2. Enter an invalid email address (e.g., missing \"@\" symbol) in the email field.");
        loginPage.enterEmailAddress("abc");

        logger.step("Step 3. Enter a valid 'Password' in the password field");
        loginPage.enterPassword(Constant.USER_ADMIN.getPassword());

        logger.step("Step 4. The login button cannot be clicked");
        Assert.assertFalse(loginPage.isButtonLoginEnabled(), "The login button cannot be clicked");

        logger.step("VP Step 4. Verify that an error message is displayed \"Username invalid format\"");
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(Message.USERNAME_INVALID_FORMAT.getValue()), "An error message is displayed \"Username invalid format\"");
    }

    @Test(description = "User can Login with Invalid Password")
    public void LOGIN_TC003(){
        User invalidUser = new User(Constant.USER_ADMIN.getUsername(), "invaliduser");

        logger.step("Step 1. Navigate to the login page");
        logger.step("Step 2. Enter a valid email address in the email field.");
        logger.step("Step 3. Enter an incorrect password in the password field");
        logger.step("Step 4. Click on the \"Login\" button\n Wait for the page to load");
        loginPage.login(invalidUser);

        logger.step("VP Step 4. Verify that an error message is displayed, \"Login fail \n Login credentials not valid\"");
        Assert.assertTrue(loginPage.isDisplayedLoginFailPopup(), "An error message is displayed \n \"Login fail \n Login credentials not valid\"");
    }

    @Test(description = "User can Login with Empty Fields")
    public void LOGIN_TC004(){
        logger.step("Step 1. Navigate to the login page");
        logger.step("Step 2. Leave the email field and password field empty.");
        loginPage.enterEmailAddress("");
        loginPage.enterPassword("");
        loginPage.clickTitleAdminPortal();

        logger.step("VP Step 2. Verify that an error message is displayed indicating that both fields are required.");
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(Message.USERNAME_IS_REQUIRED.getValue()), "'Username is required' is displayed");
        Assert.assertTrue(loginPage.isDisplayedLblErrorMessage(Message.PASSWORD_IS_REQUIRED.getValue()), "'Password is required' is displayed");

        logger.step("Step 3. The login button cannot be clicked");
        Assert.assertFalse(loginPage.isButtonLoginEnabled(), "The login button cannot be clicked");
    }

    @Test(description = "User can Login with password less than 8 characters")
    public void LOGIN_TC005(){
        logger.step("Step 1. Navigate to the login page");
        logger.step("Step 2. Enter a valid 'Email address' in the email field");
        loginPage.enterEmailAddress(Constant.USER_ADMIN.getUsername());

        logger.step("Step 3. Enter  'Password' less than 8 characters");
        loginPage.enterPassword("123");
        loginPage.clickTitleAdminPortal();

        logger.step("VP Step 3. Verify that an error message is displayed \n" +
                "\"Password min length 8 characters\"\n" +
                "- The login button cannot be clicked");
        Assert.assertTrue(loginPage.isDisplayedLblErrorMessage(Message.PASSWORD_CHARACTERS.getValue()), "'Password min length 8 characters' is displayed");
        Assert.assertFalse(loginPage.isButtonLoginEnabled(), "The login button cannot be clicked");
    }
}
