package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UserProfilePage;
import utils.common.constants.Constant;
import utils.enums.EntityFields;
import utils.enums.UserActions;

public class UserProfileTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    UserProfilePage userProfilePage = UserProfilePage.getInstance();

    @Test(description = "User can not update profile with empty name field")
    public void USER_PROFILE_TC001(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Navigate to the User Profile page");
        userProfilePage = homePage.clickUserProfile();
        Assert.assertTrue(userProfilePage.isDisplayedTitle(EntityFields.USER_PROFILE.getValue()), "User Profile page is displayed");

        logger.step("Step 3. Leave the firstname field empty");
        userProfilePage.enter(EntityFields.FIRST_NAME.getValue(), "");

        logger.step("Step 4. Observe");
        logger.step("VP Step 4. User can not click \"Save\"");
        Assert.assertFalse(userProfilePage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
    }

    @Test(description = "User can not update profile with Invalid Phone field")
    public void USER_PROFILE_TC002(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Navigate to the User Profile page");
        userProfilePage = homePage.clickUserProfile();
        Assert.assertTrue(userProfilePage.isDisplayedTitle(EntityFields.USER_PROFILE.getValue()), "User Profile page is displayed");

        logger.step("Step 3. Enter a invalid phone number in the phone field");
        userProfilePage.enter(EntityFields.PHONE.getValue(), "-1234567");

        logger.step("Step 4. Observe");
        logger.step("VP Step 4. User can not click \"Save\"");
        Assert.assertFalse(userProfilePage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
    }
}
