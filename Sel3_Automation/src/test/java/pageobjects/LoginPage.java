package pageobjects;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import dataobjects.User;
import pageobjects.Digikey.HomePage;


@ResourcePage(file = "loginPage.properties")
public class LoginPage extends AbstractPage {

    private static LoginPage instance = null;

    @Find(key = "txtEmailAddress")
    private IElement txtEmailAddress;

    @Find(key = "txtPassword")
    private IElement txtPassword;

    @Find(key = "btnLogin")
    private IElement btnLogin;

    private LoginPage() {
        Page.init(this);
    }

    public static synchronized LoginPage getInstance() {
        if (instance == null)
            instance = new LoginPage();
        return instance;
    }


    /**
     * Login to application
     *
     * @param user
     * @return
     */
    public HomePage login(User user) {
        txtEmailAddress.waitForVisibility(5);
        txtEmailAddress.enter(user.getUsername());
        txtPassword.enter(user.getPassword());
        btnLogin.click();
        waitForPageLoadingComplete();
        return HomePage.getInstance();
    }

}


