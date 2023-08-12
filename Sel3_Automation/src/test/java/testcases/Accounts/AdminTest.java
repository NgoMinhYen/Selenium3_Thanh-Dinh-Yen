package testcases.Accounts;

import dataobjects.Admin;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testcases.BaseTest;
import utils.common.constants.Constant;
import utils.enums.EntityFields;
import utils.enums.LeftMenu;
import utils.enums.UserRole;

public class AdminTest extends BaseTest {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage;
    AccountsPage accountsPage;
    @Test(description = "User can invite a valid Admin user (Non-Upload Profile)")
    public void ADMIN_TC_01(){
        Admin admin = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile)");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be enable");
        Assert.assertTrue(accountsPage.isSaveButtonEnable(),
                "Save button should be enable");

        logger.step("Step 6: Click 'Save'");
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickSave();

        logger.step("Verify step 6: New Admin should invite successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "New admin should be displayed");
    }
    @Test(description = "User can NOT invite an invalid Admin user (invalid First Name)")
    public void ADMIN_TC_02(){
        Admin admin = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile and First Name field)");
        admin.setFirstName("");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be disable");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT invite an invalid Admin user (invalid Last Name)")
    public void ADMIN_TC_03(){
        Admin admin = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile and Last Name field)");
        admin.setLastName("");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be disable");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT invite an invalid Admin user (invalid User Name)")
    public void ADMIN_TC_04(){
        Admin admin = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile and UserName field)");
        admin.setUserName("");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be disable");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT invite an invalid Admin user (invalid Phone)")
    public void ADMIN_TC_05(){
        Admin admin = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile and Phone field)");
        admin.setPhone("");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be disable");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can invite a valid Admin user (Upload Profile)")
    public void ADMIN_TC_06(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin = Admin.generateRandomAdmin(sImage);
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile)");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be enable");
        Assert.assertTrue(accountsPage.isSaveButtonEnable(),
                "Save button should be enable");

        logger.step("Step 6: Click 'Save'");
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickSave();

        logger.step("Verify step 6: New Admin should invite successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "New admin should be displayed");
    }
    @Test(description = "User update admin with data (First Name)")
    public void ADMIN_TC_07(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = Admin.generateRandomAdmin();
        logger.step("Step 1: Login to home page (Admin Role)");
        homePage = loginPage.login(Constant.USER_ADMIN);
        Assert.assertTrue(homePage.isDisplayedTitle(EntityFields.WELCOME_TO_VOUCHER_PARADISE.getValue()),
                "Home Page should be displayed");

        logger.step("Step 2: Select Accounts tab");
        homePage.waitForLoadingSpinnerDisappear();
        accountsPage = homePage.openTab(LeftMenu.ACCOUNT);

        logger.step("Step 3: Select 'Admin'");
        accountsPage.waitForLoadingSpinnerDisappear();
        accountsPage.selectUserRole(UserRole.ADMIN.getValue());

        logger.step("Step 4: Click 'Invite'");
        accountsPage.clickInviteUser();
        accountsPage.waitForInvitePopupDisplayed();

        logger.step("Step 5: Fill the pop up (Not upload profile)");
        accountsPage.fillInvitePopup(admin);

        logger.step("Verify step 5: Save button should be enable");
        Assert.assertTrue(accountsPage.isSaveButtonEnable(),
                "Save button should be enable");

        logger.step("Step 6: Click 'Save'");
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickSave();

        logger.step("Verify step 6: New Admin should invite successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "New admin should be displayed");

        logger.step("Step 7: Update Admin - First Name");
//        accountsPage.clickEditOfAdmin(admin);

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "New admin should be displayed");
    }
}
