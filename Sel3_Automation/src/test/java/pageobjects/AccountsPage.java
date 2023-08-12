package pageobjects;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import org.openqa.selenium.WebElement;
import dataobjects.Admin;
import org.openqa.selenium.support.ui.Select;
import utils.enums.LeftMenu;

@ResourcePage(file = "accountsPage.properties")
public class AccountsPage extends AbstractPage {
    private static AccountsPage instance = null;
    @Find(key = "eleInviteUser")
    private IElement inviteUser;

    @Find(key = "eleSelectRole")
    private IElement selectOptionRole;

    @Find(key = "eleAdminNameList")
    private IElement eleAdminNameList;
    @Find(key = "eleAdminUserNameList")
    private IElement eleAdminUserNameList;
    @Find(key = "eleAdminPhoneList")
    private IElement eleAdminPhoneList;

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
    public void searchPartner(String partner){
        eleSearchPartner.click();
        getPartners.waitForVisibility();
        getPartners.of(partner).click();

    }
    public AccountsPage inviteNewPartner(String firstName, String lastName, String userName, String path, String partner){
        eleFirstName.enter(firstName);
        eleLastName.enter(lastName);
        eleUserName.enter(userName);
        uploadProfile(path);
        searchPartner(partner);
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
        boolean result;
        do {
            result = checkAdminDetailDisplayed(admin);
            if(btnNextPage.isEnabled()) btnNextPage.click();
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
}
