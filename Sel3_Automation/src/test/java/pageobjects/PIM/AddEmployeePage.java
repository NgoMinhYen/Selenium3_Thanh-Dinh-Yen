package pageobjects.PIM;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import dataobjects.User;
import org.apache.commons.lang3.StringUtils;
import pageobjects.AbstractPage;
import pageobjects.ViewPersonalDetailsPage;

public class AddEmployeePage extends AbstractPage {
    private static AddEmployeePage instance     = null;
    private        IElement        txtFirstName = new Element(Locator.xpath("//input[@name='firstName']"));
    private        IElement        txtLastName  = new Element(Locator.xpath("//input[@name='lastName']"));
    private        IElement        btnSave      = new Element(Locator.xpath("//button[@type='submit']"));
    private        IElement        chbCreateLoginDetail = new Element(Locator.xpath("//input[@type='checkbox']/following-sibling::span"));
    private IElement txtUsername = new Element(Locator.xpath("//label[contains(.,'Username')]/parent::div/following-sibling::div"));
    private IElement txtPassword = new Element(Locator.xpath("//label[.='Password']/parent::div/following-sibling::div"));
    private IElement txtConfirmPassword = new Element(Locator.xpath("//label[.='Confirm Password']/parent::div/following-sibling::div"));
    private String sCreateLoginDetail = "//label[.='%s']/parent::div/following-sibling::div" ;


    private AddEmployeePage() {
    }

    public static synchronized AddEmployeePage getInstance() {
        if (instance == null)
            instance = new AddEmployeePage();
        return instance;
    }

    public void enterFirstName(String sFirstName) {
        if (StringUtils.isNoneEmpty(sFirstName))
            txtFirstName.enter(sFirstName);
    }

    public void enterLastName(String sLastName) {
        if (StringUtils.isNoneEmpty(sLastName))
            txtLastName.enter(sLastName);
    }

    public void clickCreateLoginDetail(){
        chbCreateLoginDetail.click();
    }

    public void enterUsername(User user){
       IElement eleUsername = new Element(Locator.dynamicXPath(sCreateLoginDetail,"Username")) ;
       eleUsername.enter(user.getUsername());
    }

    public void enterPassword(User user){
        IElement elePassword = new Element(Locator.dynamicXPath(sCreateLoginDetail,"Password")) ;
        elePassword.enter(user.getPassword());
    }
    public void enterConfirmPassword(User user){
        IElement eleConfirmPassword = new Element(Locator.dynamicXPath(sCreateLoginDetail,"Confirm Password")) ;
        eleConfirmPassword.enter(user.getPassword());
    }

    public ViewPersonalDetailsPage clickSaveButton() {
        btnSave.waitForClickable();
        btnSave.click();
        return ViewPersonalDetailsPage.getInstance();
    }

    public ViewPersonalDetailsPage addNewEmployee(String sFirstName, String sLastName) {
        enterFirstName(sFirstName);
        enterLastName(sLastName);
        return clickSaveButton();
    }

}
