package testcases;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PartnersPage;
import utils.common.Utilities;
import utils.common.constants.Constant;

public class PartnersTest extends BaseTest{
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    PartnersPage partnerPage = PartnersPage.getInstance();

    @Test(description = "User can not add partner with Empty Name field")
    public void PARTNER_TC002(){
        logger.step("Step 1. Login to the application");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Click \"Partners\"");
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

    @Test(description = "Error message is played when user add partner with Expired date before start date")
    public void PARTNER_TC004(){
        String sToday = Utilities.toDate("M/dd/YYYY");
        String sFutureDate = Utilities.fromDate("M/dd/YYYY", 2);

        logger.step("Step 1. Login to the application");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Click \"Partners\"");
        partnerPage = homePage.clickPartner();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.clickAddPartner();
        Assert.assertTrue(partnerPage.isDisplayedInviteNewPartnerPopup(), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Select Expired Date");
        partnerPage.enterExpiredDate(sToday);

        logger.step("Step 5. Select Start Date after Expired Date");
        partnerPage.enterStartDate(sFutureDate);

        logger.step("Step 6. Observe");
        logger.step("VP Step 6. \"Expired date is required\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedRequiredExpiredDateErrorMessage(), "\"Expired date is required\" is displayed");
    }

}
