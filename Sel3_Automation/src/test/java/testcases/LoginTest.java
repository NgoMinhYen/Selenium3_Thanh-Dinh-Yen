package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.PIM.PIMPage;
import utils.common.constants.Constant;

public class LoginTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    PIMPage pimPage;
    @Test(description = "Test case 001: Verify that user can login successfully with correct credentials")
    public void OHRM_LOGIN_TC001() {
        
        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Enter valid username and password");
        logger.step("Step 3: Click on \"Login\" button");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 4: Verify that OrangeHRM Mainpage appears");
        Assert.assertTrue(pimPage.isDisplayedHeader(), "Dashboard Mainpage doesn't appear");
    }
}
