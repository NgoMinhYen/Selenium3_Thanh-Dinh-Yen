package testcases.Accounts;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testcases.BaseTest;
import utils.common.constants.Constant;
import utils.enums.UserRole;

public class PartnerTest extends BaseTest {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    AccountsPage accountsPage = AccountsPage.getInstance();


    @Test(description = "Test case PARTNERS_TC01: Partner can invite User")
    public void PARTNER_TC01(){
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

        logger.step("Step 5. Select Account on the left");
        homePage.selectTitle("Accounts");

        logger.step("Step 6. Select user role : partner ");
        accountsPage.selectUserRole(UserRole.PARTNER.getValue());






    }


}
