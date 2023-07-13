package pageobjects.PIM;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import pageobjects.AbstractPage;

public class ReportsPage extends AbstractPage {
    private IElement txtReportName = new Element(Locator.xpath("//input[@placeholder='Type for hints...']"));

    private static ReportsPage instance = null;

    private ReportsPage() {
    }

    public static synchronized ReportsPage getInstance() {
        if (instance == null)
            instance = new ReportsPage();
        return instance;
    }

    public void enterReportName(String name){
        txtReportName.enter(name);

    }


}
