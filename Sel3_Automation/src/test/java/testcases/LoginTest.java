package testcases;

import core.framework.wrappers.Driver;
import org.testng.annotations.Test;

import pageobjects.Digikey.BasePage;
import pageobjects.Digikey.HomePage;
import pageobjects.LoginPage;
import utils.common.constants.Constant;

public class LoginTest extends BaseTest{
    BasePage basePage = BasePage.getInstance();
    HomePage homePage = HomePage.getInstance();

    @Test(description = "Test case 001: User can login with valid account")
    public void LOGIN_TC001() throws InterruptedException {
        
        logger.step("Step 1. Navigate to Digi-Key website\n url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);
        basePage.waitForPageLoadingComplete();
        Thread.sleep(1000);

        logger.step("Step 2. Navigate to Login page by hover on \"Login or REGISTER\" link on top menu");
        basePage.hoverBtnLoginOrRegister();
        LoginPage loginPage = basePage.clickBtnLogin();

        logger.step("Step 3. Login\n" +
                            "- Enter valid Username, \n" +
                            "- Enter valid Password\n" +
                            "- Click Login.");
        loginPage.login(Constant.USER_ADMIN);

        logger.step("Login successfully.\n VP: Username/Email displays on page");
        String userName = "Yen Ngo";
        //homePage.getUserName();



    }
}
