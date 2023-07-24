package pageobjects;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import dataobjects.User;
import pageobjects.PIM.PIMPage;


@ResourcePage(file = "loginPage.properties")
public class LoginPage extends AbstractPage {

    private static LoginPage instance = null;

    @Find(key = "txtUserName")
    private IElement txtUserName;

    @Find(key = "txtPassword")
    private IElement txtPassword;

    @Find(key = "btnLogin")
    private IElement btnLogin;
    @Find(key = "iconProfile")
    private IElement iconProfile;
    @Find(key = "listDropdownMenu")
    private IListElement listDropdownMenu;

    @Find(key = "test")
    private IElement test;

    private LoginPage() {
        Page.init(this);
    }

    public static synchronized LoginPage getInstance() {
        if (instance == null)
            instance = new LoginPage();
        return instance;
    }

    public PIMPage login(String username, String password) {
        test.of("submit", "Abc").click();
        txtUserName.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
        waitForPageLoadingComplete();
        return PIMPage.getInstance();
    }

    /**
     * Login to application
     *
     * @param user
     * @return
     */
    public PIMPage login(User user) {
        txtUserName.waitForVisibility(5);
        txtUserName.enter(user.getUsername());
        txtPassword.enter(user.getPassword());
        btnLogin.click();
        waitForPageLoadingComplete();
        return PIMPage.getInstance();
    } public void clickIconProfile(){
        iconProfile.click();
        listDropdownMenu.click(2);
    }

}


