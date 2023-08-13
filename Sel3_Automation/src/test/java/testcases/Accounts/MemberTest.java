package testcases.Accounts;

import core.framework.wrappers.Driver;
import dataobjects.InviteMember;
import dataobjects.InvitePartner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testcases.BaseTest;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.*;

public class MemberTest extends BaseTest {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    AccountsPage accountsPage = AccountsPage.getInstance();

    @Test(description = "Test case MEMBER_TC01: Account can invite Partner")
    public void MEMBER_TC01(){
        InviteMember inviteMember = InviteMember.generateRandomMember();
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
        accountsPage.selectUserRole(UserRole.MEMBER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Member");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewMember(inviteMember);

        logger.step("VP:Verify user create partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()),"Create account success");

    }

    @Test(description = "Test case MEMBER_TC02: User can delete member")
    public void MEMBER_TC02(){
        InviteMember inviteMember = InviteMember.generateRandomMember();
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
        accountsPage.selectUserRole(UserRole.MEMBER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Member");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewMember(inviteMember);

        logger.step("VP:Verify user create partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()),"Create account success");

        logger.step("Step 9: Search the new member created and click icon Edit");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(inviteMember.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Step 10: Click delete ");
        accountsPage.deleteAccount(UserActions.YES.getValue());

        logger.step("VP: Verify user delete partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.DELETE_ACCOUNT_SUCCESSFULLY.getValue()), "Account have been deleted successfully");


    }
    @Test(description = "Test case MEMBER_TC03: User can not update member with phone invalid format")
    public void MEMBER_TC03() {
        InviteMember inviteMember = InviteMember.generateRandomMember();
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
        accountsPage.selectUserRole(UserRole.MEMBER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Member");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewPartnerWithInvalidPhone("0124012121212");

        logger.step("VP:Username invalid format appear");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Phone invalid format"), "Phone invalid format");

    }

    @Test(description = "Test case MEMBER_TC04: User can update birthday with future day")
    public void MEMBER_TC04() {
        InviteMember inviteMember = InviteMember.generateRandomMember();
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
        accountsPage.selectUserRole(UserRole.MEMBER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Member");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewPartnerWithInvalidBirthday(Utilities.fromDate("MM/dd/yyyy", 3));

        logger.step("VP:Birthday invalid format appear");
        Assert.assertTrue(accountsPage.isErrorBirthdayOnPopupDisplayed("Birthday invalid"), "Birthday invalid");

    }

    @Test(description = "Test case MEMBER_TC05: User can update address for member")
    public void MEMBER_TC05() {
        InviteMember inviteMember = InviteMember.generateRandomMember();
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
        accountsPage.selectUserRole(UserRole.MEMBER.getValue());

        logger.step("Step 7: Click Invite User");
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.clickInviteUser();

        logger.step("Step 8: Enter invite New Member");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.inviteNewMember(inviteMember);

        logger.step("VP:Verify user create partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()),"Create account success");

        logger.step("Step 9: Search the new member created and click icon Edit");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(inviteMember.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Step 10: Update Address");
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.updateAddressForMember(Utilities.generateString(10));
        accountsPage.clickSave();

        logger.step("VP:Verify user update partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.UPDATE_ACCOUNT_SUCCESSFULLY.getValue()),"Update account success");

    }


}
