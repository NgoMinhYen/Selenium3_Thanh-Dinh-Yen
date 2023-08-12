package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import dataobjects.Partner;
import utils.enums.EntityFields;
import utils.enums.UserActions;

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

    @Find(key = "eleTextOfSpan")
    private IElement eleTextOfSpan;

    @Find(key = "elePartner")
    private IElement elePartner;

    @Find(key = "eleImg")
    private IElement eleImg;

    @Find(key = "lblErrorMessage")
    private IElement lblErrorMessage;

    @Find(key = "txtUserActions")
    private IElement txtUserActions;

    @Find(key = "textareaUserActions")
    private IElement textareaUserActions;

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

    public void enterTextarea(String fieldName, String value) {
        textareaUserActions.of(fieldName).enter(value);
    }

    public void enterForm(String fieldName, String value) {
        txtFormcontrolname.of(fieldName).enter(value);
    }

    public void selectButton(String value) {
        btnUserActions.of(value).waitForVisibility();
        btnUserActions.of(value).click();
    }

    public void select(String value) {
        eleImg.of(value).waitForVisibility();
        eleImg.of(value).click();
    }

    public void click(String fieldName) {
        txtUserActions.of(fieldName).click();
    }

    public boolean isDisplayedTitle(String value) {
        return eleTitle.of(value).isDisplayed();
    }

    public boolean isDisplayedTextOfSpan(String value) {
        return eleTextOfSpan.of(value).isDisplayed();
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
        enterTextarea(UserActions.ENTER_DESCRIPTION.getValue(), partner.getDescription());
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

    /*
        index is the position of the partner to be updated
        The index starts from 0, meaning the index of the first partner is 0
     */
    public void selectEditPartner(int index) {
        if(getListPartnerOnAPage()>0) {
            String name = getTextPartner(index);
            elePartner.of(name).waitForVisibility();
            elePartner.of(name).hover();
            btnActionOnPartner.of(name).hover();
            btnActionOnPartner.of(name).click();
        }
    }

    public void searchPartner(String partner){
        click(UserActions.SEARCH.getValue());
        enterValue(UserActions.SEARCH.getValue(), partner);
    }

}
