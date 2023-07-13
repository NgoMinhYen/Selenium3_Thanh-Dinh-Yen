package pageobjects.PIM;

import core.framework.elements.Element;
import core.framework.locator.Locator;
import pageobjects.AbstractPage;

public class PIMMenu extends AbstractPage {
    private String PIMMenuItem = "//nav[@aria-label='Topbar Menu']//a[text()='%s']";

    /**
     * Return page by menu selected
     *
     * @param menu left menu selected
     * @param <T>  generic page selected
     * @return page selected
     */
    private <T extends AbstractPage> T getPage(utils.enums.PIMMenu menu) {
        switch (menu) {
            case CONFIGURATION:
                return (T) ConfigurationPage.getInstance();
            case EMPLOYEE_LIST:
                return (T) EmployeeListPage.getInstance();
            case ADD_EMPLOYEE:
                return (T) AddEmployeePage.getInstance();
            case REPORT:
                return (T) ReportsPage.getInstance();
            default:
                return null;
        }
    }

    public <T extends AbstractPage> T selectPIMMenu(utils.enums.PIMMenu menu) {
        Element eleMenuItem = new Element(Locator.xpath(String.format(PIMMenuItem, menu.getValue())));
        eleMenuItem.click();
        T page = getPage(menu);
        return page;
    }
}
