package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import dataobjects.DataAssignLeave;
import elementTest.Select;

public class LeavePage extends AbstractPage {
    private static LeavePage instance = null;
    String sTopMenu = "//nav[@aria-label='Topbar Menu']//a[contains(text(),'%s')]";
    private IElement btnAssignLeave  = new Element(Locator.xpath(String.format(sTopMenu, "Assign Leave")));
    private IElement txtEmployeeName = new Element(Locator.xpath("//input[@placeholder='Type for hints...']"));
    private IElement txtFromdate     = new Element(Locator.xpath("(//div[@class='oxd-date-input']//input)[1]"));
    private IElement txtTodate       = new Element(Locator.xpath("(//div[@class='oxd-date-input']//input)[2]"));

    private LeavePage() {
    }

    public static synchronized LeavePage getInstance() {
        if (instance == null)
            instance = new LeavePage();
        return instance;
    }

    public void clickAssignLeavePage() {
        btnAssignLeave.click();
        waitForPageLoadingComplete();
    }

    public void enterAssignFrom(DataAssignLeave dataAssignLeave) {
        txtEmployeeName.enter(dataAssignLeave.getEmployeeName());
        Select select = new Select(Locator.xpath("//div[@class='oxd-select-wrapper']"), Locator.xpath("//*[@role='option']"));
        select.selectText(dataAssignLeave.getLeaveType());
        txtFromdate.enter(dataAssignLeave.getFromDate());
        txtTodate.enter(dataAssignLeave.getToDate());

    }

//   public void selectLeaveType(DataAssignLeave dataAssignLeave){
//       Select select = new Select(Locator.xpath("//div[@class='oxd-select-wrapper']"), Locator.xpath("//*[@role='option']"));
//       select.selectText(dataAssignLeave.getLeaveType());
//
//   }
//   public void selectFromDate(DataAssignLeave dataAssignLeave){
//        txtFromdate.enter(dataAssignLeave.getFromDate());
//
//   }


}
