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
    @Test(description = "User update admin with data (Except UserName and Profile)")
    public void ADMIN_TC_07(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = Admin.generateRandomAdmin();
        adminUpdate.setUserName(admin.getUserName());

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickSave();

        logger.step("Verify step 7: New Admin should update successfully");
        accountsPage.searchPartner(adminUpdate.getFirstName());
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(adminUpdate),
                "New admin should be displayed");
    }
    @Test(description = "User update admin with data (Except UserName)")
    public void ADMIN_TC_08(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        String sImage2 = Constant.UPLOAD_PATH + "upload_02.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = Admin.generateRandomAdmin(sImage2);
        adminUpdate.setUserName(admin.getUserName());

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickSave();

        logger.step("Verify step 7: New Admin should update successfully");
        accountsPage.searchPartner(adminUpdate.getFirstName());
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(adminUpdate),
                "New admin should be displayed");
    }
    @Test(description = "User can NOT update admin with invalid data (First Name)")
    public void ADMIN_TC_09(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = new Admin();
        adminUpdate.setFirstName(" ");
//        adminUpdate.setLastName(" ");
        adminUpdate.setUserName(admin.getUserName());
//        adminUpdate.setPhone(" ");

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT update admin with invalid data (Last Name)")
    public void ADMIN_TC_10(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = new Admin();
//        adminUpdate.setFirstName(" ");
        adminUpdate.setLastName(" ");
        adminUpdate.setUserName(admin.getUserName());
//        adminUpdate.setPhone(" ");

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT update admin with invalid data (User Name)")
    public void ADMIN_TC_11(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin;
        admin  = Admin.generateRandomAdmin(sImage);

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();

        logger.step("Verify step 7: UserName field should be disable");
        Assert.assertFalse(accountsPage.isUserNameFieldEditable(),
                "Save button should be disable");
    }
    @Test(description = "User can NOT update admin with invalid data (First Name)")
    public void ADMIN_TC_12(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = new Admin();
//        adminUpdate.setFirstName(" ");
//        adminUpdate.setLastName(" ");
        adminUpdate.setUserName(admin.getUserName());
        adminUpdate.setPhone(" ");

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertFalse(accountsPage.isSaveButtonEnable(),
                "Save button should be disable");
    }
    @Test(description = "User can search by First Name")
    public void ADMIN_TC_13(){
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

        logger.step("Step 7: Search Admin by FirstName");
        accountsPage.searchPartner(admin.getFirstName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
    @Test(description = "User can search by Last Name")
    public void ADMIN_TC_14(){
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

        logger.step("Step 7: Search Admin by Last Name");
        accountsPage.searchPartner(admin.getLastName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
    @Test(description = "User can search by User Name")
    public void ADMIN_TC_15(){
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

        logger.step("Step 7: Search Admin by UserName");
        accountsPage.searchPartner(admin.getUserName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
    @Test(description = "User can search by Phone")
    public void ADMIN_TC_16(){
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

        logger.step("Step 7: Search Admin by Phone");
        accountsPage.searchPartner(admin.getPhone());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
    @Test(description = "User can search by Full Name")
    public void ADMIN_TC_17(){
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

        logger.step("Step 7: Search Admin by Full name");
        accountsPage.searchPartner(admin.getFullName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
    @Test(description = "User can delete an Admin")
    public void ADMIN_TC_18(){
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

        logger.step("Step 7: Search Admin by First Name");
        accountsPage.searchPartner(admin.getFirstName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");

        logger.step("Step 8: Delete admin");
        accountsPage.clickIconEdit();
        accountsPage.clickDeleteAdmin();
        accountsPage.clickYesDeleteAdminPopup();

        logger.step("Verify step 8: Admin should delete successfully");
        accountsPage.waitForDisableAdminDetail(admin);
        Assert.assertFalse(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should NOT be displayed");
    }
    @Test(description = "User can cancel invite a valid Admin user (Non-Upload Profile)")
    public void ADMIN_TC_19(){
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
        accountsPage.clickCancel();

        logger.step("Verify step 6: New Admin should invite successfully");
        Assert.assertFalse(accountsPage.isAdminDetailDisplayed(admin),
                "New admin should be displayed");
    }
    @Test(description = "User cancel Update Admin")
    public void ADMIN_TC_20(){
        String sImage = Constant.UPLOAD_PATH + "upload_01.png";
        String sImage2 = Constant.UPLOAD_PATH + "upload_02.png";
        Admin admin, adminUpdate ;
        admin  = Admin.generateRandomAdmin(sImage);
        adminUpdate = Admin.generateRandomAdmin(sImage2);
        adminUpdate.setUserName(admin.getUserName());

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
        accountsPage.searchPartner(admin.getFirstName());
        accountsPage.clickIconEdit();
        accountsPage.updateInvitePopup(adminUpdate);
        accountsPage.waitForPageLoadingComplete();
        accountsPage.clickCancel();

        logger.step("Verify step 7: New Admin should update successfully");
        accountsPage.searchPartner(adminUpdate.getFirstName());
        Assert.assertFalse(accountsPage.isAdminDetailDisplayed(adminUpdate),
                "New admin should be displayed");
    }

    @Test(description = "User can cancel delete an Admin")
    public void ADMIN_TC_21(){
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

        logger.step("Step 7: Search Admin by First Name");
        accountsPage.searchPartner(admin.getFirstName());

        logger.step("Verify step 7: New Admin should update successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");

        logger.step("Step 8: Delete admin");
        accountsPage.clickIconEdit();
        accountsPage.clickDeleteAdmin();
        accountsPage.clickNoDeleteAdminPopup();

        logger.step("Verify step 8: Admin should cancel delete successfully");
        Assert.assertTrue(accountsPage.isAdminDetailDisplayed(admin),
                "Admin should be displayed");
    }
}
