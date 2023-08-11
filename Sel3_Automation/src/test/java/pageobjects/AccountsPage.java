package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
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
    public AccountsPage uploadProfile(String path){

        btnUploadFile.waitForVisibility();
        btnUploadFile.enter(path);
        return AccountsPage.getInstance();
    }


}
