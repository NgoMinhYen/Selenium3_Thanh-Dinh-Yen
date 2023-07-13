package testcases;

import core.framework.wrappers.Driver;
import dataobjects.DataAssignLeave;
import org.testng.annotations.Test;
import pageobjects.LeavePage;
import pageobjects.LoginPage;
import pageobjects.PIM.PIMPage;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.LeftMenu;

public class LeaveTest extends BaseTest{
    private LoginPage loginPage = LoginPage.getInstance();
    private PIMPage pimPage;
    private LeavePage leavePage;

    @Test(description = "Verify that user can submit leave request.")
    public void OHRM_LEAVE_TC006() {
        DataAssignLeave dataAssignLeave = new DataAssignLeave("Jasmine  Morgan", "CAN - Bereavement", Utilities.toDate("yyyy-MM-dd"),Utilities.fromDate("yyyy-MM-dd",2));

        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Enter valid username and password");
        logger.step("Step 3: Click on \"Login\" button");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 4: Go to Leave -> Assign Leave page");
        leavePage = pimPage.selectLeftMenu(LeftMenu.LEAVE);
        leavePage.clickAssignLeavePage();

        logger.step("Step 5: Enter Page Assign field");
        leavePage.enterAssignFrom(dataAssignLeave);

    }

}
