package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "partnersPage.properties")
public class PartnersPage extends AbstractPage{

    private static PartnersPage instance = null;

    @Find(key = "btnAddPartner")
    private IElement btnAddPartner;

    @Find(key = "btnSave")
    private IElement btnSave;

    @Find(key = "eleInviteNewPartnerPopup")
    private IElement eleInviteNewPartnerPopup;

    @Find(key = "lblRequiredNameErrorMessage")
    private IElement lblRequiredNameErrorMessage;

    @Find(key = "lblRequiredExpiredDateErrorMessage")
    private IElement lblRequiredExpiredDateErrorMessage;

    @Find(key = "txtName")
    private IElement txtName;

    @Find(key = "txtExpiredDate")
    private IElement txtExpiredDate;

    @Find(key = "txtStartDate")
    private IElement txtStartDate;

    private PartnersPage() {
        Page.init(this);
    }

    public static synchronized PartnersPage getInstance(){
        if (instance == null)
            instance = new PartnersPage();
        return instance;
    }

    public void enterName(String sName) {
        txtName.enter(sName);
    }

    public void enterExpiredDate(String sExpiredDate) {
        txtExpiredDate.enter(sExpiredDate);
    }

    public void enterStartDate(String sStartDate) {
        txtStartDate.enter(sStartDate);
    }

    public void clickAddPartner() {
        btnAddPartner.waitForVisibility();
        btnAddPartner.click();
    }

    public boolean isDisplayedInviteNewPartnerPopup() {
        return eleInviteNewPartnerPopup.isDisplayed();
    }

    public boolean isDisplayedRequiredNameErrorMessage() {
        return lblRequiredNameErrorMessage.isDisplayed();
    }

    public boolean isDisplayedRequiredExpiredDateErrorMessage() {
        return lblRequiredExpiredDateErrorMessage.isDisplayed();
    }

    public boolean isButtonSaveEnabled() {
        btnSave.waitForVisibility();
        return btnSave.isEnabled();
    }

}
