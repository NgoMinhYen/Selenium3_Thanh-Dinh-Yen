package testcases;

import core.framework.wrappers.Driver;
import dataobjects.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.PIM.AddEmployeePage;
import pageobjects.LoginPage;
import pageobjects.PIM.EmployeeListPage;
import pageobjects.PIM.PIMPage;
import pageobjects.ViewPersonalDetailsPage;
import utils.common.Utilities;
import utils.common.constants.Constant;
import utils.enums.PIMMenu;

public class PIMTest extends BaseTest {
    private LoginPage loginPage = LoginPage.getInstance();
    private PIMPage pimPage;
    private AddEmployeePage addEmployeePage;
    private ViewPersonalDetailsPage viewPersonalDetailsPage;
    private EmployeeListPage employeeListPage;

    @Test(description = "Verify that user can add new employee")
    public void OHRM_PIM_ADD_NEW_EMPLOYEE_TC011() {
        Employee emp = new Employee(Utilities.getRandomString(5), Utilities.getRandomString(5), null);
        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Select \"Add Employee\" button at main page");
        addEmployeePage = pimPage.selectPIMMenu(PIMMenu.ADD_EMPLOYEE);

        logger.step("Step 4: Select \"Add Employee\" button at main page");
        viewPersonalDetailsPage = addEmployeePage.addNewEmployee(emp.getFirstName(), emp.getLastName());
        viewPersonalDetailsPage.waitForPageLoadingComplete();

        logger.info("Step 4: Verify new employee is created.");
        String sFullName = emp.getFirstName() + " " + emp.getLastName();
        Assert.assertTrue(viewPersonalDetailsPage.isDisplayedEmployeeName(sFullName), "Employee: " + sFullName + " is created successfully");
    }

    @Test(description = "Verify that user can add new employee from Emloyee List page")
    public void OHRM_PIM_ADD_NEW_EMPLOYEE_FROM_EMPLOYEE_LIST_PAGE_TC012() {
        Employee emp = new Employee(Utilities.getRandomString(5), Utilities.getRandomString(5), null);
        logger.step("Step 1: Navigate to OrangeHRM login page");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Login with valid password");
        pimPage = loginPage.login(Constant.USER_ADMIN);

        logger.step("Step 3: Select \"Employee List\" button at main page");
        employeeListPage = pimPage.selectPIMMenu(PIMMenu.EMPLOYEE_LIST);

        logger.step("Step 4: Click \"Add\" button");
        addEmployeePage = employeeListPage.clickAddEmployee();
        addEmployeePage.waitForPageLoadingComplete();

        logger.info("Step 5: Get Employee ID.");
        viewPersonalDetailsPage = addEmployeePage.addNewEmployee(emp.getFirstName(), emp.getLastName());
        viewPersonalDetailsPage.waitForPageLoadingComplete();

        logger.info("Step 6: Verify new employee is created.");
        String sFullName = emp.getFirstName() + " " + emp.getLastName();
        Assert.assertTrue(viewPersonalDetailsPage.isDisplayedEmployeeName(sFullName), "Employee: " + sFullName + " is created successfully");
    }
}
