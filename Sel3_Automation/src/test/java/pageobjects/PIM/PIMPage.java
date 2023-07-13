package pageobjects.PIM;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;

public class PIMPage extends PIMMenu {
    private static PIMPage  instance = null;
    private        IElement btnAdd   = new Element(Locator.xpath("//div[@class='orangehrm-header-container']/button[//text()[normalize-space() = 'Add']]"));

    private PIMPage() {
    }

    public static synchronized PIMPage getInstance() {
        if (instance == null)
            instance = new PIMPage();
        return instance;
    }

    public AddEmployeePage clickAddEmployeeButton() {
        btnAdd.click();
        return AddEmployeePage.getInstance();
    }
}
