package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PartnerPage;
import utils.common.constants.Constant;

public class PartnerTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    PartnerPage partnerPage = PartnerPage.getInstance();

    @Test(description = "User can not add partner with Empty Name field")
    public void PARTNER_TC002(){
        logger.step("Step 1. Login to the application");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();
        loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 2. Click \"Partners\"");
        homePage.waitForPageLoadingComplete();
        partnerPage = homePage.clickPartner();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.clickAddPartner();
        Assert.assertTrue(partnerPage.isDisplayedInviteNewPartnerPopup(), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Leave the Name field empty");
        partnerPage.enterName("");

        logger.step("VP Step 4. \"Name is required\" is displayed. User can not click \"Save\"");
        Assert.assertTrue(partnerPage.isDisplayedRequiredNameErrorMessage(), "\"Name is required\" is displayed");
        Assert.assertFalse(partnerPage.isButtonSaveEnabled(), "User can not click \"Save\"");
    }

}
