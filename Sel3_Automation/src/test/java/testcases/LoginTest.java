package testcases;

import core.framework.wrappers.Driver;
import org.testng.annotations.Test;

import pageobjects.Digikey.BasePage;
import pageobjects.LoginPage;
import pageobjects.PIM.PIMPage;
import utils.common.constants.Constant;

public class LoginTest extends BaseTest{
    BasePage basePage = BasePage.getInstance();

    @Test(description = "Test case 001: User can login with valid account")
    public void LOGIN_TC001() {
        
        logger.step("Step 1. Navigate to Digi-Key website\n url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);
        basePage.waitForPageLoadingComplete();

        logger.step("Step 2. Navigate to Login page by hover on \"Login or REGISTER\" link on top menu");
        basePage.hoverBtnLoginOrRegister();
        LoginPage loginPage = basePage.clickBtnLogin();

        logger.step("Step 3. Login\n" +
                            "- Enter valid Username, \n" +
                            "- Enter valid Password\n" +
                            "- Click Login.");
        loginPage.login(Constant.USER_ADMIN);

        logger.step("Login successfully.\n VP: Username/Email displays on page");
        //cmt

    }
}
