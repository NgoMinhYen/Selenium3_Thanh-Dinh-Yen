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

    @Test(description = "User can add partner with valid information")
    public void PARTNER_TC001(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.selectPartner(LeftMenu.PARTNERS.getValue());

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.INVITE_NEW_PARTNER.getValue()), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Enter Name");
        logger.step("Step 5. Enter Website");
        logger.step("Step 6. Select valid Start Date");
        logger.step("Step 6. Select valid Expired Date");
        logger.step("Step 7. Enter Description");
        logger.step("Step 8. Select Profile");
        logger.step("Step 9. Click Save");
        partnerPage.addPartnerWithRandomInfo(partner);

        logger.step("VP Step 9. Verify user add partner is successful");
        Assert.assertTrue(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
    }

    @Test(description = "User can not add partner with Empty Name field")
    public void PARTNER_TC002(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.INVITE_NEW_PARTNER.getValue()), "'Invite New Partner' popup is displayed");

        logger.step("Step 4. Leave the Name field empty");
        partnerPage.enterValue(UserActions.ENTER_NAME.getValue(), "");

        logger.step("VP Step 4. \"Name is required\" is displayed. User can not click \"Save\"");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.NAME_IS_REQUIRED.getValue()), "\"Name is required\" is displayed");
        Assert.assertFalse(partnerPage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
    }

    @Test(description = "User can not add partner with Invalid website")
    public void PARTNER_TC003(){
        Partner partner = Partner.generateRandomPartner();
        partner.setWebsite("xyzcorp.com");

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Enter Name");
        logger.step("Step 5. Enter \"xyzcorp.com\" in the Website field");
        logger.step("Step 6. Select valid Start Date");
        logger.step("Step 6. Select valid Expired Date");
        logger.step("Step 7. Enter Description");
        logger.step("Step 8. Select Profile");
        partnerPage.enterDataIntoAddPartnerForm(partner);

        logger.step("Step 9. Observe");
        logger.step("VP Step 9. User can not click \"Save\"");
        Assert.assertFalse(partnerPage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
    }

    @Test(description = "Verify Error message is played when user add partner with Expired date before start date")
    public void PARTNER_TC004(){
        String sToday = Utilities.toDate("M/dd/YYYY");
        String sFutureDate = Utilities.fromDate("M/dd/YYYY", 2);

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

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

    @Test(description = "User can not add partner with Empty description field")
    public void PARTNER_TC005(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Leave the Description field empty");
        partnerPage.enterTextarea(UserActions.ENTER_DESCRIPTION.getValue(), "");

        logger.step("VP Step 4. \"Description is required\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.DESCRIPTION_IS_REQUIRED.getValue()), "\"Description is required\" is displayed");
    }

    @Test(description = "User can not add partner without profile")
    public void PARTNER_TC006(){
        Partner partner = Partner.generateRandomPartner();
        partner.setProfile("");

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Enter Name");
        logger.step("Step 5. Enter Website");
        logger.step("Step 6. Select valid Start Date");
        logger.step("Step 6. Select valid Expired Date");
        logger.step("Step 7. Enter Description");
        partnerPage.enterDataIntoAddPartnerForm(partner);

        logger.step("Step 8. Observe");
        logger.step("VP Step 8.  User can not click \"Save\"");
        Assert.assertFalse(partnerPage.isButtonEnabled(UserActions.SAVE.getValue()), "User can not click \"Save\"");
    }

    @Test(description = "User can not add partner with invalid profile")
    public void PARTNER_TC007(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Upload the image file \"testpdf.pdf\"");
        partnerPage.uploadProfile(Constant.PATH_TESTPDF);

        logger.step("Step 5. Observe");
        logger.step("VP Step 5. \"File upload support .png/.jpg\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.FILE_UPLOAD_SUPPORT.getValue()), "\"File upload support .png/.jpg\" is displayed");
    }

    @Test(description = "User can not add partner successfully when user click cancel")
    public void PARTNER_TC008(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Enter Name");
        logger.step("Step 5. Enter Website");
        logger.step("Step 6. Select valid Start Date");
        logger.step("Step 6. Select valid Expired Date");
        logger.step("Step 7. Enter Description");
        logger.step("Step 8. Select Profile");
        partnerPage.enterDataIntoAddPartnerForm(partner);

        logger.step("Step 9. Click Cancel");
        partnerPage.selectButton(UserActions.CANCEL.getValue());

        logger.step("VP Step 9. Add partner is not successfull");
        Assert.assertFalse(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is not successful");
    }

    @Test(description = "Verify Error message is played when user add partner with start date before today")
    public void PARTNER_TC009(){
        String sYesterday = Utilities.fromDate("M/dd/YYYY", -1);

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Select valid Start Date before today");
        partnerPage.enterForm(EntityFields.START_DATE.getValue(), sYesterday);

        logger.step("Step 5. Observe");
        logger.step("VP Step 5. \"Start date is required\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedErrorMessage(Message.START_DATE_IS_REQUIRED.getValue()), "\"Start date is required\" is displayed");
    }

    @Test(description = "User can update partner successfully with valid information")
    public void PARTNER_TC010(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Add a partner if list is empty");
        if(partnerPage.getListPartnerOnAPage()<0) {
            partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
            partnerPage.addPartnerWithRandomInfo(partner);
            Assert.assertTrue(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
        }

        logger.step("Step 4. Select a partner");
        logger.step("Step 5. Click edit partner");
        partnerPage.selectEditPartner(0);
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.UPDATE_PARTNER.getValue()), "'Update Partner' popup is displayed");

        logger.step("Step 6. Enter new name");
        partnerPage.enterValue(UserActions.ENTER_NAME.getValue(), "Update " + partner.getName());

        logger.step("Step 7. Click Save");
        partnerPage.selectButton(UserActions.SAVE.getValue());

        logger.step("VP Step 7. Verify user update partner is successful");
        Assert.assertTrue(partnerPage.isDisplayedTitle(Message.UPDATED_PARTNER_SUCCESSFULLY.getValue()), "User update partner is successful");
    }

    @Test(description = "User can Update Partner popup is displayed")
    public void PARTNER_TC011(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Add a partner if list is empty");
        if(partnerPage.getListPartnerOnAPage()<0) {
            partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
            partnerPage.addPartnerWithRandomInfo(partner);
            Assert.assertTrue(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
        }

        logger.step("Step 4. Select a partner");
        logger.step("Step 5. Click edit partner");
        partnerPage.selectEditPartner(0);

        logger.step("Step 6. Observe");
        logger.step("VP Step 6. Update Partner popup is displayed");
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.UPDATE_PARTNER.getValue()), "'Update Partner' popup is displayed");
    }

    @Test(description = "Verify Invite New Partner popup is displayed")
    public void PARTNER_TC012(){
        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Observe");
        logger.step("Step 4. \"Invite New Partner\" popup is displayed");
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.INVITE_NEW_PARTNER.getValue()), "'Invite New Partner' popup is displayed");
    }

    @Test(description = "User cannot add two partners with the same name")
    public void PARTNER_TC013(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();
        partner.setName(partnerPage.getTextPartner(0));

        logger.step("Step 3. Click \"Add Partner\"");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());

        logger.step("Step 4. Enter a name that already exists");
        logger.step("Step 5. Enter Website");
        logger.step("Step 6. Select valid Start Date");
        logger.step("Step 6. Select valid Expired Date");
        logger.step("Step 7. Enter Description");
        logger.step("Step 8. Select Profile");
        logger.step("Step 9. Click Save");
        partnerPage.addPartnerWithRandomInfo(partner);

        logger.step("Step 10. Observe");
        logger.step("VP Step 10. Verify user add partner is not successful");
        Assert.assertFalse(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
    }

    @Test(description = "Verify \"Are you sure delete this partner?\" is displayed when User click delete Partner")
    public void PARTNER_TC014(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Add a partner if list is empty");
        if(partnerPage.getListPartnerOnAPage()<0) {
            partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
            partnerPage.addPartnerWithRandomInfo(partner);
            Assert.assertTrue(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
        }

        logger.step("Step 4. Select a partner");
        logger.step("Step 6. Click edit partner");
        partnerPage.selectEditPartner(0);

        logger.step("Step 7. Click Delete");
        partnerPage.select(UserActions.DELETE_PARTNER.getValue());

        logger.step("Step 8. Observe");
        logger.step("VP Step 8. \"Are you sure delete this partner?\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedTextOfSpan(Message.ARE_YOU_SURE_DELETE_THIS_PARTNER.getValue()), "\"Are you sure delete this partner?\" is displayed");
    }

    @Test(description = "User can delete Partner")
    public void PARTNER_TC015(){
        Partner partner = Partner.generateRandomPartner();

        logger.step("Step 1. Login to the application");
        loginPage.login(Constant.USER_ADMIN);
        homePage.waitForPageLoadingComplete();

        logger.step("Step 2. Select \"Partners\"");
        partnerPage = homePage.openTab(LeftMenu.PARTNERS);
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 3. Add a partner if list is empty");
        partnerPage.selectButton(UserActions.ADD_PARTNER.getValue());
        partnerPage.addPartnerWithRandomInfo(partner);
        Assert.assertTrue(partnerPage.isDisplayedTitle(Message.CREATED_PARTNER_SUCCESSFULLY.getValue()), "User add partner is successful");
        Driver.refresh();
        partnerPage.waitForPageLoadingComplete();

        logger.step("Step 4. Select a partner");
        logger.step("Step 6. Click edit partner");
        partnerPage.searchPartner(partner.getName());
        partnerPage.selectEditPartner(0);
        Assert.assertTrue(partnerPage.isDisplayedTitle(EntityFields.UPDATE_PARTNER.getValue()), "'Update Partner' popup is displayed");


        logger.step("Step 7. Click Delete");
        partnerPage.select(UserActions.DELETE_PARTNER.getValue());

        logger.step("Step 8. Observe");
        logger.step("VP Step 8. \"Are you sure delete this partner?\" is displayed");
        Assert.assertTrue(partnerPage.isDisplayedTextOfSpan(Message.ARE_YOU_SURE_DELETE_THIS_PARTNER.getValue()), "\"Are you sure delete this partner?\" is displayed");

        logger.step("Step 9. Click Yes");
        partnerPage.selectButton(UserActions.YES.getValue());

        logger.step("VP Step 9. Partner is deleted");
        Assert.assertTrue(partnerPage.isDisplayedTitle(Message.PARTNER_HAVE_BEEN_DELETED_SUCCESSFULLY.getValue()), "Partner is deleted");
    }

    @Test(description = "User can cancel delete Partner")
    public void PARTNER_TC016(){
        logger.step("Step 1. Login to the application");
        logger.step("Step 2. Select \"Partners\"");
        logger.step("Step 3. Add a partner if list is empty");
        logger.step("Step 4. Select a partner");
        logger.step("Step 6. Click edit partner");
        logger.step("Step 7. Click Delete");
        logger.step("Step 8. Observe");
        logger.step("VP Step 8. \"Are you sure delete this partner?\" is displayed");
        logger.step("Step 9. Click No");
        logger.step("VP Step 9. Partner is displayed");
    }

}
