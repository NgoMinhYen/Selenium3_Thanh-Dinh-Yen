package pageobjects.MyInFo;

import pageobjects.AbstractPage;
import pageobjects.PIM.AddEmployeePage;
import pageobjects.PIM.ConfigurationPage;
import pageobjects.PIM.EmployeeListPage;
import pageobjects.PIM.ReportsPage;

public class MyInfoMenu extends AbstractPage {

    private String InfoMenuItem = "//div[@role='tablist']/div[contains(.,'Immigration')]";

    private <T extends AbstractPage> T getPage(utils.enums.MyInfoMenu menu) {
        switch (menu) {
            case PERSONAL_DETAILS:
                return (T) PersonalDetailPage.getInstance();
            case CONTACT_DETAILS:
                return (T) EmployeeListPage.getInstance();
            case EMERGENCY_CONTACTS:
                return (T) AddEmployeePage.getInstance();
            case DEPENDENTS:
                return (T) ReportsPage.getInstance();
            case IMMIGRATION:
                return (T) ReportsPage.getInstance();
            case JOB:
                return (T) ReportsPage.getInstance();
            case SALARY:
                return (T) ReportsPage.getInstance();
            case TAX_EXEMPTIONS:
                return (T) ReportsPage.getInstance();
            case REPORT_TO:
                return (T) ReportsPage.getInstance();
            case QUALIFICATIONS:
                return (T) ReportsPage.getInstance();
            case MEMBERSHIPS:
                return (T) ReportsPage.getInstance();

            default:
                return null;
        }
    }
}
