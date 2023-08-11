package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import elementTest.Select;
import pageobjects.AccountPage.PartnerPage;

@ResourcePage(file = "accountsPage.properties")
public class AccountsPage extends AbstractPage {
    private static AccountsPage instance = null;
    @Find(key = "eleSelectRole")
    private IElement selectRole;

    @Find(key = "eleSelectOption")
    private IElement selectOptionRole;

    private AccountsPage() {
        Page.init(this);
    }

    public static synchronized AccountsPage getInstance() {
        if (instance == null)
            instance = new AccountsPage();
        return instance;
    }
    public void selectUserRole(String role){
        selectOptionRole.click();
        //Select select = new Select()


    }

}
