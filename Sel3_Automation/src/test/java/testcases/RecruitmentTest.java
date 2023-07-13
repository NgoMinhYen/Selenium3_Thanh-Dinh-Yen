package testcases;

import core.framework.wrappers.Driver;
import dataobjects.Recruitment;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.PIM.PIMPage;
import pageobjects.RecruitmentPage;
import pageobjects.RecruitmentPageForm;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.LeftMenu;
import utils.enums.RecruitmentColumnHeader;


public class RecruitmentTest extends BaseTest {
    private LoginPage           loginPage = LoginPage.getInstance();
    private PIMPage             pimPage;
    private RecruitmentPage     recruitmentPage;
    private RecruitmentPageForm recruitmentPageForm;


    @Test(description = "Verify that user can add candidate with required data filled")
    public void OHRM_RECRUITMENT_TC016() {

        Recruitment recruitment = Utilities.generateRecruitment();

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Select menu item \"Recruitment\"");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);

        logger.step("Step 4: Click on \"Add\" button");
        recruitmentPageForm = recruitmentPage.clickAddRecruitmentButton();

        logger.step("Step 5: Fill all required data");
        recruitmentPageForm.fillData(recruitment);

        logger.step("Step 6: Click on \"Save\" button");
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 7: Verify success message displayed, display form detail candidate same with data fill in step 5");
        Assert.assertTrue(recruitmentPageForm.isDisplayedToastMessage(), "Doesn't displayed toast message");
        Assert.assertEquals(recruitmentPageForm.getToastMessageTitle(), "Success", "Toast success message doesn't displayed");

        recruitmentPageForm.waitForLoadingSpinnerDisappear();
        Assert.assertEquals(recruitmentPageForm.getFirstName(), recruitment.getFirstName(), "Firstname displayed incorrect");
        Assert.assertEquals(recruitmentPageForm.getLastName(), recruitment.getLastName(), "Lastname displayed incorrect");
        Assert.assertEquals(recruitmentPageForm.getEmail(), recruitment.getEmail(), "Email displayed incorrect");
    }

    @Test(description = "Verify that user can not add candidate with required data is not completed")
    public void OHRM_RECRUITMENT_TC017() {

        Recruitment recruitment = new Recruitment();
        recruitment.setEmail("test_email@gmail.com");
        String sErrorMessageExpected = "Required";

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Select menu item \"Recruitment\"");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);

        logger.step("Step 4: Click on \"Add\" button");
        recruitmentPageForm = recruitmentPage.clickAddRecruitmentButton();

        logger.step("Step 5: Fill data with at least 1 required field is not complete");
        recruitmentPageForm.fillData(recruitment);

        logger.step("Step 6: Click on \"Save\" button");
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 7: Verify error message \"Required\" under field required is not filled, border color red");
        Assert.assertEquals(recruitmentPageForm.getErrorMessageFirstName(), sErrorMessageExpected, "Doesn't displayed error message " + sErrorMessageExpected);
        Assert.assertEquals(recruitmentPageForm.getErrorMessageLastName(), sErrorMessageExpected, "Doesn't displayed error message " + sErrorMessageExpected);
    }

    @Test(description = "Verify that user can delete a candidate")
    public void OHRM_RECRUITMENT_TC018() {

        Recruitment recruitment = Utilities.generateRecruitment();

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Create new candidate");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);
        recruitmentPageForm = recruitmentPage.clickAddRecruitmentButton();
        recruitmentPageForm.fillData(recruitment);
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 4: Back to candidate list page view");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);

        logger.step("Step 5: Check checkbox to select candidate");
        recruitmentPage.selectCandidate(RecruitmentColumnHeader.CANDIDATE, recruitment.getFullName());

        logger.step("Step 6: Click on \"Delete Selected\" button next to Record Selected label");
        recruitmentPage.clickDeleteSelectedButton();

        logger.step("Step 7: Verify confirm popup displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedConfirmPopup(), "Verify confirm popup is not displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedNoCancelButton(), "Verify No cancel button is not displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedYesDeleteButton(), "Verify Yes delete button is not displayed");

        logger.step("Step 8: Click on \"Yes, Delete\" on confirm popup");
        recruitmentPage.clickYesDeleteButton();

        logger.step("Step 9: Displayed message delete successful, record is not displayed in list page view");
        Assert.assertTrue(recruitmentPage.isDisplayedToastMessage(), "Doesn't displayed toast message");
        Assert.assertEquals(recruitmentPage.getToastMessageTitle(), "Success", "Toast success message doesn't displayed");
        Assert.assertTrue(recruitmentPage.isNotDisplayedCandidate(RecruitmentColumnHeader.CANDIDATE, recruitment.getFullName()), "record is displayed in list page view");

    }

    @Test(description = "Verify that user can search candidates by Date of Application(from, to)")
    public void OHRM_RECRUITMENT_TC019() {

        Recruitment recruitment = Utilities.generateRecruitment();

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Create new candidate");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);
        recruitmentPageForm = recruitmentPage.clickAddRecruitmentButton();
        recruitmentPageForm.fillData(recruitment);
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 4: Back to candidate list page view");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);

        logger.step("Step 5: Check checkbox to select candidate");
        recruitmentPage.selectCandidate(RecruitmentColumnHeader.CANDIDATE, recruitment.getFullName());

        logger.step("Step 6: Click on \"Delete Selected\" button next to Record Selected label");
        recruitmentPage.clickDeleteSelectedButton();

        logger.step("Step 7: Verify confirm popup displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedConfirmPopup(), "Verify confirm popup is not displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedNoCancelButton(), "Verify No cancel button is not displayed");
        Assert.assertTrue(recruitmentPage.isDisplayedYesDeleteButton(), "Verify Yes delete button is not displayed");

        logger.step("Step 8: Click on \"Yes, Delete\" on confirm popup");
        recruitmentPage.clickYesDeleteButton();

        logger.step("Step 9: Displayed message delete successful, record is not displayed in list page view");
        Assert.assertTrue(recruitmentPage.isDisplayedToastMessage(), "Doesn't displayed toast message");
        Assert.assertEquals(recruitmentPage.getToastMessageTitle(), "Success", "Toast success message doesn't displayed");
        Assert.assertTrue(recruitmentPage.isNotDisplayedCandidate(RecruitmentColumnHeader.CANDIDATE, recruitment.getFullName()), "record is displayed in list page view");

    }

    @Test(description = "Verify that user can update information candidate")
    public void OHRM_RECRUITMENT_TC020() {

        Recruitment recruitment = Utilities.generateRecruitment();

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Create new candidate");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);
        recruitmentPageForm = recruitmentPage.clickAddRecruitmentButton();
        recruitmentPageForm.fillData(recruitment);
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 4: Back to candidate list page view");
        recruitmentPage = pimPage.selectLeftMenu(LeftMenu.RECRUITMENT);

        logger.step("Step 5: Click icon update in action column");
        recruitmentPage.clickIconViewDetailCandidate(RecruitmentColumnHeader.CANDIDATE, recruitment.getFullName());

        logger.step("Step 6: Update some field form");
        recruitmentPageForm.clickSwitchEditIcon();
        recruitment.setFirstName(recruitment.getFirstName() + "Updated");
        recruitmentPageForm.updateFirstName(recruitment.getFirstName());

        logger.step("Step 7: Click on \"Save\" button");
        recruitmentPageForm.clickSaveButton();

        logger.step("Step 8: Verify message success displayed");
        Assert.assertTrue(recruitmentPageForm.isDisplayedToastMessage(), "Doesn't displayed toast message");
        Assert.assertEquals(recruitmentPageForm.getToastMessageTitle(), "Success", "Toast success message doesn't displayed");

    }
}
