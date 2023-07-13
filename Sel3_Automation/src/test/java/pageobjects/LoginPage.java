package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import dataobjects.User;
import pageobjects.PIM.PIMPage;


public class LoginPage extends AbstractPage {

    private static LoginPage instance = null;

    private IElement txtUserName = new Element(Locator.name("username"));
    private IElement txtPassword = new Element(Locator.name("password"));
    private IElement btnLogin    = new Element(Locator.xpath("//button[@type = 'submit']"));

    private LoginPage() {
    }

    public static synchronized LoginPage getInstance() {
        if (instance == null)
            instance = new LoginPage();
        return instance;
    }

    public PIMPage login(String username, String password) {
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
        txtUserName.enter(user.getUsername());
        txtPassword.enter(user.getPassword());
        btnLogin.click();
        waitForPageLoadingComplete();
        return PIMPage.getInstance();
    }

}


