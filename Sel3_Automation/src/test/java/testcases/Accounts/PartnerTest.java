package testcases.Accounts;

import core.framework.wrappers.Driver;
import dataobjects.Admin;
import dataobjects.InvitePartner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testcases.BaseTest;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.EntityFields;
import utils.enums.LeftMenu;
import utils.enums.Message;
import utils.enums.UserRole;

public class PartnerTest extends BaseTest {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    AccountsPage accountsPage = AccountsPage.getInstance();


    @Test(description = "Test case PARTNERS_TC01: Partner can invite User")
    public void PARTNER_TC01(){

        InvitePartner invitePartner = InvitePartner.generateRandomAdmin();
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Enter a valid 'Email address' in the email field");
        logger.step("Step 3. Enter a valid 'Password' in the password field");
        logger.step("Step 4. Click on the \"Login\" button");
        loginPage.login(Constant.USER_ADMIN);

        logger.info("Wait for the page to load");
        logger.step("VP Step 4: Login successfully.");
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()), "Login successfully");

        logger.step("Step 5. Select Account on the left");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);


        logger.step("Step 6. Select user role : partner ");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.selectUserRole(UserRole.PARTNER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Partner");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewPartner(invitePartner);

        logger.step("VP:Verify user create partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()),"Create account success");
    }

    @Test(description = "Test case PARTNERS_TC04: User can edit partner")
    public void PARTNER_TC04(){

        InvitePartner invitePartner = InvitePartner.generateRandomAdmin();
        logger.step("Step 1. Navigate to the login page");
        Driver.navigateTo(Constant.URL);
        loginPage.waitForPageLoadingComplete();

        logger.step("Step 2. Enter a valid 'Email address' in the email field");
        logger.step("Step 3. Enter a valid 'Password' in the password field");
        logger.step("Step 4. Click on the \"Login\" button");
        loginPage.login(Constant.USER_ADMIN);

        logger.info("Wait for the page to load");
        logger.step("VP Step 4: Login successfully.");
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()), "Login successfully");

        logger.step("Step 5. Select Account on the left");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);


        logger.step("Step 6. Select user role : partner ");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.selectUserRole(UserRole.PARTNER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Partner");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewPartner(invitePartner);

        logger.step("VP:Verify user create partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()),"Create account success");

        logger.step("Step 9: Search the new partner created and click icon Edit");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(invitePartner.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Step 10: Edit first name and last name");



    }


}
