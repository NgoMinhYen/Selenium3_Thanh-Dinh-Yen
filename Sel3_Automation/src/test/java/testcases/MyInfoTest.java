package testcases;

import core.framework.wrappers.Driver;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.MyInfoPage;
import pageobjects.PIM.PIMPage;
import utils.common.constants.Constant;
import utils.enums.LeftMenu;

import static utils.common.constants.Constant.USER_ADMIN;

public class MyInfoTest extends BaseTest {
    private LoginPage loginPage = LoginPage.getInstance();
    PIMPage pimPage;
    MyInfoPage myInfoPage;

    @Test(description = "Verify that user can add new employee")

    public void OHRM_EDIT_MY_PROFILE_TC012() {
        logger.step("Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);
        pimPage =loginPage.login(USER_ADMIN);

        logger.step("On left panel, click on My Profile.");
        pimPage.selectLeftMenu(LeftMenu.MY_INFO);

        logger.step("Click Immigration button");



    }

}
