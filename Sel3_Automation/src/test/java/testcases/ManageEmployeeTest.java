package testcases;

import dataobjects.Employee;
import dataobjects.User;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.PIM.AddEmployeePage;
import pageobjects.PIM.EmployeeListPage;
import pageobjects.PIM.PIMPage;
import pageobjects.PIM.ReportsPage;
import pageobjects.ViewPersonalDetailsPage;
import utils.common.Utilities;
import utils.common.constants.Constant;
import core.framework.wrappers.Driver;
import utils.enums.LeftMenu;
import utils.enums.PIMMenu;

import static utils.common.constants.Constant.USER_ADMIN;

public class ManageEmployeeTest extends BaseTest {
	LoginPage loginPage = LoginPage.getInstance();
	PIMPage pimPage;
	private AddEmployeePage addEmployeePage;
	private EmployeeListPage employeeListPage;
	private ViewPersonalDetailsPage viewPersonalDetailsPage;
	ReportsPage reportsPage;

	@Test(description = "Verify that admin can add new employee with login details")

	public void OHRM_MANAGE_EMPLOYEE_TC002() {
		Employee emp = new Employee(Utilities.getRandomString(5), Utilities.getRandomString(5), null);
		User user = new User("Admin", "admin123");

		logger.step("Step 1: Navigate to OrangeHRM login page");
		Driver.navigateTo(Constant.URL);

		logger.step("Step 2: Login with valid account");
		pimPage = loginPage.login(USER_ADMIN);
		
		logger.step("Step 3: Go to PIM tab");
		pimPage.selectLeftMenu(LeftMenu.PIM);

		logger.step("Step 4: Click on Add button");

		addEmployeePage = employeeListPage.clickAddEmployee();
		
		logger.step("Step 5: Enter employee First name and Last Name");
		addEmployeePage.enterFirstName(emp.getFirstName());
		addEmployeePage.enterLastName(emp.getLastName());

		logger.step("Step 6: Toggle the \"Create Login Details\"");
		addEmployeePage.clickCreateLoginDetail();
		
		logger.step("Step 7: Enter Username, Password and Confirm password");
		addEmployeePage.enterUsername(user);
		addEmployeePage.enterPassword(user);
		addEmployeePage.enterConfirmPassword(user);
		
		logger.step("Step 8: Click on Save button");
		
		logger.step("VP: Verify that Personal Details page with employee name appears");

	}
	@Test(description = "Verify that admin can add a report template")

	public void OHRM_MANAGE_EMPLOYEE_TC003() {
		logger.step("Step 1: Navigate to OrangeHRM login page");
		Driver.navigateTo(Constant.URL);

		logger.step("Step 2: Login with valid account");
		pimPage = loginPage.login(USER_ADMIN);

		logger.step("Step 3: Go to PIM tab");
		pimPage.selectLeftMenu(LeftMenu.PIM);

		logger.step("Go to PIM tab > Reports");
		reportsPage = pimPage.selectPIMMenu(PIMMenu.REPORT);

		logger.step("Enter Report name");
		reportsPage.enterReportName("");


	}


}
