package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import dataobjects.Recruitment;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;


public class RecruitmentPageForm extends AbstractPage {
    private static RecruitmentPageForm instance                 = null;
    private        IElement            txtFirstName             = new Element(Locator.xpath("//input[@name='firstName']"));
    private        IElement            txtLastName              = new Element(Locator.xpath("//input[@name='lastName']"));
    private        IElement            txtEmail                 = new Element(Locator.xpath("//div[label[text()='Email']]/following-sibling::div/input"));
    private        IElement            btnSave                  = new Element(Locator.xpath("//button[@type='submit' and text()[normalize-space() = 'Save']]"));
    private        IElement            eleErrorMessageFirstName = new Element(Locator.xpath("//div[input[@name='firstName']]/following-sibling::span[contains(@class, 'error-message')]"));
    private        IElement            eleErrorMessageLastName  = new Element(Locator.xpath("//div[input[@name='lastName']]/following-sibling::span[contains(@class, 'error-message')]"));
    private        IElement            eleSwitchEdit            = new Element(Locator.xpath("//div[@class='oxd-switch-wrapper']/label[text()='Edit']/span"));


    private RecruitmentPageForm() {
    }

    public static synchronized RecruitmentPageForm getInstance() {
        if (instance == null)
            instance = new RecruitmentPageForm();
        return instance;
    }

    public void fillData(Recruitment recruitment) {
        if (StringUtils.isNoneEmpty(recruitment.getFirstName())) {
            txtFirstName.enter(recruitment.getFirstName());
        }
        if (StringUtils.isNoneEmpty(recruitment.getLastName())) {
            txtLastName.enter(recruitment.getLastName());
        }
        if (StringUtils.isNoneEmpty(recruitment.getEmail())) {
            txtEmail.enter(recruitment.getEmail());
        }
    }

    public void clickSaveButton() {
        btnSave.click();
    }

    public String getFirstName() {
        return txtFirstName.getDomProperty("_value");
    }

    public String getBorderColorFirstName() {
        return txtFirstName.getDomAttribute("border");
    }

    public String getLastName() {
        return txtLastName.getDomProperty("_value");
    }

    public String getBorderColorLastName() {
        return txtLastName.getDomAttribute("border");
    }

    public String getEmail() {
        return txtEmail.getDomProperty("_value");
    }

    public String getErrorMessageFirstName() {
        return eleErrorMessageFirstName.getText();
    }

    public String getErrorMessageLastName() {
        return eleErrorMessageLastName.getText();
    }

    public void clickSwitchEditIcon() {
        eleSwitchEdit.click();
    }

    public void updateFirstName(String value) {
        txtFirstName.pressKey(Keys.CONTROL + "a");
        txtFirstName.pressKey(Keys.DELETE);
        txtFirstName.enter(value);
    }
}
