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
}
