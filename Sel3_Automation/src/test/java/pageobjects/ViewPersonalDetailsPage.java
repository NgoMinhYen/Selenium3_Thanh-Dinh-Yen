package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;

public class ViewPersonalDetailsPage extends AbstractPage {
    private static ViewPersonalDetailsPage instance           = null;
    private        IElement                lblEmployeeName    = new Element(Locator.xpath("//div[@class='orangehrm-edit-employee-name']"));
    private        IElement                txtFirstName       = new Element(Locator.xpath("//input[@name='firstName']"));
    private        IElement                txtLastName        = new Element(Locator.xpath("//input[@name='lastName']"));
    private        String                  sEmployeeNameLabel = "//div[@class='orangehrm-edit-employee-name']//h6[text()='%s']";

    private ViewPersonalDetailsPage() {
    }

    public static ViewPersonalDetailsPage getInstance() {
        if (instance == null)
            instance = new ViewPersonalDetailsPage();
        return instance;
    }

    public boolean isDisplayedEmployeeName(String sEmployeeName) {
        IElement lblEmpName = new Element(Locator.xpath(String.format(sEmployeeNameLabel, sEmployeeName)));
        lblEmpName.waitForVisibility();
        return lblEmpName.isDisplayed();
    }

    public String getEmployeeName() {
        return lblEmployeeName.getText(100);
    }

    public String getFirstName() {
        return txtFirstName.getText(10);
    }

    public String getLastName() {
        return txtFirstName.getText(10);
    }
}
