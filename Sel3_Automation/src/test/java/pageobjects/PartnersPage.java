package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import dataobjects.Partner;
import org.openqa.selenium.WebElement;
import utils.enums.EntityFields;
import utils.enums.UserActions;
import utils.logs.Logger;

@ResourcePage(file = "partnersPage.properties")
public class PartnersPage extends AbstractPage{

    private static PartnersPage instance = null;

    @Find(key = "eleListPartner")
    private IElement eleListPartner;

    @Find(key = "btnUserActions")
    private IElement btnUserActions;

    @Find(key = "btnActionOnPartner")
    private IElement btnActionOnPartner;

    @Find(key = "eleUploadFile")
    private IElement btnUploadFile;

    @Find(key = "eleTitle")
    private IElement eleTitle;

    @Find(key = "elePartner")
    private IElement elePartner;

    @Find(key = "lblErrorMessage")
    private IElement lblErrorMessage;

    @Find(key = "txtUserActions")
    private IElement txtUserActions;

    @Find(key = "txtDescription")
    private IElement txtDescription;

    @Find(key = "txtFormcontrolname")
    private IElement txtFormcontrolname;

    private PartnersPage() {
        Page.init(this);
    }

    public static synchronized PartnersPage getInstance(){
        if (instance == null)
            instance = new PartnersPage();
        return instance;
    }

    public void enterValue(String fieldName, String value) {
        txtUserActions.of(fieldName).enter(value);
    }

    public void enterDescription(String sDescription) {
        txtDescription.enter(sDescription);
    }

    public void enterForm(String fieldName, String value) {
        txtFormcontrolname.of(fieldName).enter(value);
    }

    public void selectButton(String value) {
        btnUserActions.of(value).waitForVisibility();
        btnUserActions.of(value).click();
    }

    public boolean isDisplayedTitle(String value) {
        return eleTitle.of(value).isDisplayed();
    }

    public boolean isDisplayedErrorMessage(String value) {
        return lblErrorMessage.of(value).isDisplayed();
    }

    public boolean isButtonEnabled(String value) {
        btnUserActions.of(value).waitForVisibility();
        return btnUserActions.of(value).isEnabled();
    }

    public void addPartnerWithRandomInfo(Partner partner) {
        enterDataIntoAddPartnerForm(partner);
        selectButton(UserActions.SAVE.getValue());
    }

    public void enterDataIntoAddPartnerForm(Partner partner) {
        enterValue(UserActions.ENTER_NAME.getValue(), partner.getName());
        enterValue(UserActions.ENTER_WEBSITE.getValue(), partner.getWebsite());
        enterForm(EntityFields.START_DATE.getValue(), partner.getStartDate());
        enterForm(EntityFields.EXPIRED_DATE.getValue(), partner.getExpiredDate());
        enterDescription(partner.getDescription());
        if(!partner.getProfile().isEmpty()) {
            uploadProfile(partner.getProfile());
        }
    }

    public void uploadProfile(String path){
        btnUploadFile.waitForVisibility();
        btnUploadFile.enter(path);
    }

    public int getListPartnerOnAPage() {
        eleListPartner.waitForVisibility();
        return eleListPartner.getElements().size();
    }

    public String getTextPartner(int index) {
        eleListPartner.waitForVisibility();
        return eleListPartner.getElements().get(index).getText();
    }

    public void selectEditFirstPartner() {
        if(getListPartnerOnAPage()>0) {
            String name = getTextPartner(0);
            elePartner.of(name).waitForVisibility();
            elePartner.of(name).hover();
            btnActionOnPartner.of(name).hover();
            btnActionOnPartner.of(name).click();
        }
    }

}
