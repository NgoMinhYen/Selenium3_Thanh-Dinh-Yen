package pageobjects.PIM;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import pageobjects.AbstractPage;

public class EmployeeListPage extends AbstractPage {
    private        IElement         btnAddEmployee = new Element(Locator.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
    private static EmployeeListPage instance       = null;

    private EmployeeListPage() {
    }

    public static synchronized EmployeeListPage getInstance() {
        if (instance == null)
            instance = new EmployeeListPage();
        return instance;
    }

    public AddEmployeePage clickAddEmployee() {
        btnAddEmployee.waitForClickable();
        btnAddEmployee.click();
        return AddEmployeePage.getInstance();
    }
}
