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
import utils.enums.*;

public class PartnerTest extends BaseTest {

    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    AccountsPage accountsPage = AccountsPage.getInstance();

    @Test(description = "Test case PARTNERS_TC01: Partner can invite User")
    public void PARTNER_TC01(){

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        String newFirstName = Utilities.generateString(6);

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        accountsPage.waitForInvitePopupDisplayed();
        accountsPage.editFirstName(newFirstName);
        accountsPage.clickSave();

        logger.step("VP:Verify user update partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.UPDATE_ACCOUNT_SUCCESSFULLY.getValue()),"Update account success");


    }
    @Test(description = "Test case PARTNERS_TC02: Delete partner")
    public void PARTNER_TC02() {

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()), "Create account success");

        logger.step("Step 9: Search the new partner created and click icon Edit");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(invitePartner.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Step 10: Click delete ");
        accountsPage.deleteAccount(UserActions.YES.getValue());

        logger.step("VP: Verify user delete partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.DELETE_ACCOUNT_SUCCESSFULLY.getValue()), "Account have been deleted successfully");


    }

    @Test(description = "Test case PARTNERS_TC05: User can change partner for account")
    public void PARTNER_TC05() {

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()), "Create account success");

        logger.step("Step 9: Search the new partner created and click icon Edit");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(invitePartner.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Step 10: Click search box and select new partner for account ");
        accountsPage.searchPartnerInPopup("adidas");
        accountsPage.clickSave();

        logger.step("VP: Verify user delete partner is successful");
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.UPDATE_ACCOUNT_SUCCESSFULLY.getValue()), "Update account success");

    }
    @Test(description = "Test case PARTNERS_TC06: User can search partner")
    public void PARTNER_TC06() {

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        Assert.assertTrue(accountsPage.isNoticeMessageDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue()), "Create account success");

        logger.step("Step 9: Search the new partner created ");
        accountsPage.waitNoticeMessageNotDisplayed(Message.CREATED_ACCOUNT_SUCCESSFULLY.getValue());
        accountsPage.waitForUserDetailDisplayed();
        accountsPage.searchPartner(invitePartner.getFirstName());

        logger.step("VP: Partner with new name appear");
        Assert.assertTrue(accountsPage.isCarUserInfoDetailDisplayed(invitePartner.getFirstName()));

    }
    @Test(description = "Test case PARTNERS_TC07: Invite Partner with invalid username")
    public void PARTNER_TC07() {
        String userNameInvalid = Utilities.generateString(8);

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        accountsPage.inviteNewPartnerWithInvalidUsername(userNameInvalid);

        logger.step("VP:Username invalid format appear");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Username invalid format"), "Username invalid format");

    }
    @Test(description = "Test case PARTNERS_TC08: Invite Partner with empty first name")
    public void PARTNER_TC08() {

        InvitePartner invitePartner = InvitePartner.generateRandomPartner();
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
        accountsPage.inviteNewUserWithInvalidFirstname("");

        logger.step("VP:First name is required  appear");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("First name is required "), "First name is required ");

    }

    @Test(description = "Test case PARTNERS_TC09: Invite Partner with empty last name")
    public void PARTNER_TC09() {

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
        accountsPage.inviteNewUserWithInvalidLastname("");

        logger.step("VP:Last name is required ");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Last name is required "), "Last name is required ");

    }
    @Test(description = "Test case PARTNERS_TC10: Invite Partner with empty username")
    public void PARTNER_TC10() {

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
        accountsPage.inviteNewPartnerWithInvalidUsername("");

        logger.step("VP:Username is required");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Username is required"), "Username is required");

    }
    @Test(description = "Test case PARTNERS_TC11: Invite Partner with empty partner")
    public void PARTNER_TC11() {

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
        accountsPage.inviteNewPartnerWithInvalidPartner();

        logger.step("VP:Username is required");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Partner is required "), "Partner is required ");

    }

    @Test(description = "Test case PARTNERS_TC12: Invite partner with first name invalid format")
    public void PARTNER_TC12() {

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
        accountsPage.inviteNewUserWithInvalidFirstname("first name");

        logger.step("VP:Username is required");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("First name invalid format"), "First name invalid format");

    }

    @Test(description = "Test case PARTNERS_TC13: Invite partner with last name invalid format")
    public void PARTNER_TC13() {

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
        accountsPage.inviteNewUserWithInvalidLastname("last name");

        logger.step("VP:Username is required");
        Assert.assertTrue(accountsPage.isErrorMessageOnPopupDisplayed("Last name invalid format"), "Last name invalid format");

    }



}
