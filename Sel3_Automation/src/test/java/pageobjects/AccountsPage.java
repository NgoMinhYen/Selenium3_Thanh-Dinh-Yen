package pageobjects;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@ResourcePage(file = "accountsPage.properties")
public class AccountsPage extends AbstractPage {
    private static AccountsPage instance = null;
    @Find(key = "eleInviteUser")
    private IElement inviteUser;

    @Find(key = "eleSelectRole")
    private IElement selectOptionRole;

    @Find(key = "eleUploadFile")
    private IElement btnUploadFile;

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
        inviteUser.click();
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


}
