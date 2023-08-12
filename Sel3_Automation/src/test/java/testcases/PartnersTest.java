package testcases;

import core.framework.wrappers.Driver;
import dataobjects.Partner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.PartnersPage;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.EntityFields;
import utils.enums.LeftMenu;
import utils.enums.Message;
import utils.enums.UserActions;

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
        partnerPage = homePage.selectPartner(LeftMenu.PARTNERS.getValue());

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.INVITE_NEW_PARTNER.getValue()), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Leave the Name field empty");
        partnerPage.enterValue(UserActions.ENTER_NAME.getValue(), "");

        logger.step("VP Step 4. \"Name is required\" is displayed. User can not click \"Save\"");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.NAME_IS_REQUIRED.getValue()), "\"Name is required\" is displayed");
        Assert.assertFalse(partnerPage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
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
        partnerPage = homePage.selectPartner(LeftMenu.PARTNERS.getValue());

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.INVITE_NEW_PARTNER.getValue()), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Select Expired Date");
        partnerPage.enterForm(EntityFields.EXPIRED_DATE.getValue(), sToday);

        logger.step("Step 5. Select Start Date after Expired Date");
        partnerPage.enterForm(EntityFields.START_DATE.getValue(), sFutureDate);

        logger.step("Step 6. Observe");
        logger.step("VP Step 6. \"Expired date is required\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.EXPIRED_DATE_IS_REQUIRED.getValue()), "\"Expired date is required\" is displayed");
    }

}
