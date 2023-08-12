package pageobjects;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import core.framework.wrappers.Driver;
import dataobjects.InvitePartner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataobjects.Admin;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.enums.LeftMenu;

@ResourcePage(file = "accountsPage.properties")
public class AccountsPage extends AbstractPage {
    private static AccountsPage instance = null;
    @Find(key = "eleInviteUser")
    private IElement inviteUser;

    @Find(key = "eleSelectRole")
    private IElement selectOptionRole;

    @Find(key = "eleAdminUserPanel")
    private IElement eleAdminUserPanel;
    @Find(key = "eleAdminNameList")
    private IElement eleAdminNameList;
    @Find(key = "eleAdminUserNameList")
    private IElement eleAdminUserNameList;
    @Find(key = "eleAdminPhoneList")
    private IElement eleAdminPhoneList;

    @Find(key = "btnEdit")
    private IElement btnEdit;

    @Find(key = "btnNextPage")
    private IElement btnNextPage;

    /// Section Invite Popup
    @Find(key = "invitePopUp")
    private IElement invitePopUp;
    @Find(key = "txtFirstNamePopUp")
    private IElement txtFirstNamePopUp;
    @Find(key = "txtLastNamePopUp")
    private IElement txtLastNamePopUp;
    @Find(key = "txtUserNamePopUp")
    private IElement txtUserNamePopUp;
    @Find(key = "txtPhoneNamePopUp")
    private IElement txtPhoneNamePopUp;

    @Find(key = "eleUploadFile")
    private IElement btnUploadFile;
    @Find(key = "btnSave")
    private IElement btnSave;
    @Find(key = "btnCancel")
    private IElement btnCancel;
    ///


    @Find(key = "eleSearchPartner")
    private IElement eleSearchPartner;

    @Find(key = "elePartners")
    private IElement getPartners;

    @Find(key = "eleFirstName")
    private IElement eleFirstName;

    @Find(key = "eleLastName")
    private IElement eleLastName;

    @Find(key = "eleUserName")
    private IElement eleUserName;

    @Find(key = "eleSubmit")
    private IElement submit;

    @Find(key = "userDetail")
    private IElement userDetail;

    @Find(key = "eleNoticeMessage")
    private IElement noticeMessage;

    @Find(key = "eleSearch")
    private IElement txtSearch;
    @Find(key = "btnSearch")
    private IElement btnSearch;
    @Find(key = "iconEdit")
    private IElement iconEdit;


    private AccountsPage() {
        Page.init(this);
    }

    public static synchronized AccountsPage getInstance() {
        if (instance == null)
            instance = new AccountsPage();
        return instance;
    }
    public AccountsPage selectUserRole(String role){
        selectOptionRole.waitForVisibility();
        selectOptionRole.selectValue(role);
        return AccountsPage.getInstance();

    }
    public void waitForUserDetailDisplayed(){
        userDetail.waitForVisibility();
    }
    public AccountsPage clickInviteUser(){
        inviteUser.waitForVisibility();
        inviteUser.click();
        return AccountsPage.getInstance();
    }
    public void waitForInvitePopupDisplayed(){
        invitePopUp.waitForVisibility();
    }
    public AccountsPage fillInvitePopup(Admin admin){
        txtPhoneNamePopUp.waitForVisibility();
        txtFirstNamePopUp.enter(admin.getFirstName());
        txtLastNamePopUp.enter(admin.getLastName());
        txtUserNamePopUp.enter(admin.getUserName());
        txtPhoneNamePopUp.enter(admin.getPhone());
        if(admin.getProfile() != null){
            uploadProfile(admin.getProfile());
        }
        return AccountsPage.getInstance();
    }
    public void uploadProfile(String path){
        btnUploadFile.waitForVisibility();
        btnUploadFile.enter(path);

    }
    public void searchPartnerInPopup(String partner){
        eleSearchPartner.click();
        //getPartners.waitForVisibility();
        getPartners.of(partner).click();

    }
    public AccountsPage inviteNewPartner(InvitePartner invitePartner){
        eleFirstName.enter(invitePartner.getFirstName());
        eleLastName.enter(invitePartner.getLastName());
        eleUserName.enter(invitePartner.getUserName());
        uploadProfile(invitePartner.getProfile());
        searchPartnerInPopup(invitePartner.getPartner());
        submit.click();
        return AccountsPage.getInstance();
    }
    public boolean isSaveButtonEnable(){
        btnSave.waitForVisibility();
        return btnSave.isEnabled();
    }
    public AccountsPage clickSave(){
        btnSave.waitForClickable();
        btnSave.click();
        return AccountsPage.getInstance();
    }
    public AccountsPage clickCancel(){
        btnCancel.waitForClickable();
        btnCancel.click();
        return AccountsPage.getInstance();
    }
    public boolean isAdminDetailDisplayed(Admin admin){
        boolean result = false;
        do {
            result = checkAdminDetailDisplayed(admin);
            if(result == true) return result;
            if(btnNextPage.isEnabled()) btnNextPage.click();
            waitForPageLoadingComplete();
            result = checkAdminDetailDisplayed(admin);
        }
        while (btnNextPage.isEnabled());
        return result;
    }
    public boolean checkAdminDetailDisplayed(Admin admin){
        boolean result = true;
        result = result && eleAdminNameList.of(admin.getFirstName() + " " + admin.getLastName())
                .isDisplayed();
        result = result && eleAdminUserNameList.of(admin.getUserName()).isDisplayed();
        result = result && eleAdminPhoneList.of(admin.getPhone()).isDisplayed();
        return result;
    }

    public boolean isNoticeMessageDisplayed(String value){
        return noticeMessage.of(value).isDisplayed();
    }

    public void waitNoticeMessageNotDisplayed(String value){
        noticeMessage.of(value).waitForInvisibility();
    }

    public AccountsPage searchPartner(String name){
        txtSearch.enter(name);
        //btnSearch.click();
        return AccountsPage.getInstance();
    }
    public AccountsPage clickIconEdit(){
        userDetail.waitForVisibility();
        Actions actions = new Actions(Driver.getWebDriver());
        actions.moveToElement(userDetail.getElement())
                .pause(Duration.ofSeconds(2))
                .moveToElement(iconEdit.getElement())
                .click()
                .build().perform();
        return AccountsPage.getInstance();

    }
    //public void editFirstName

}
