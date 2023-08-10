package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "partnerPage.properties")
public class PartnerPage extends AbstractPage{

    private static PartnerPage instance = null;

    @Find(key = "btnAddPartner")
    private IElement btnAddPartner;

    @Find(key = "btnSave")
    private IElement btnSave;

    @Find(key = "eleInviteNewPartnerPopup")
    private IElement eleInviteNewPartnerPopup;

    @Find(key = "lblRequiredNameErrorMessage")
    private IElement lblRequiredNameErrorMessage;

    @Find(key = "txtName")
    private IElement txtName;

    private PartnerPage() {
        Page.init(this);
    }

    public static synchronized PartnerPage getInstance(){
        if (instance == null)
            instance = new PartnerPage();
        return instance;
    }

    public void enterName(String sName) {
        txtName.enter(sName);
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

    public boolean isButtonSaveEnabled() {
        btnSave.waitForVisibility();
        return btnSave.isEnabled();
    }

}
