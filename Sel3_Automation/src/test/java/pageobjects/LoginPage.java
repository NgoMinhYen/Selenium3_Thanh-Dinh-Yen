package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import dataobjects.User;


@ResourcePage(file = "loginPage.properties")
public class LoginPage extends AbstractPage {

    private static LoginPage instance = null;

    @Find(key = "txtEmailAddress")
    private IElement txtEmailAddress;

    @Find(key = "txtPassword")
    private IElement txtPassword;

    @Find(key = "lblStringErrorMessage")
    private IElement lblErrorMessage;

    @Find(key = "lblStringRequiredErrorMessage")
    private IElement lblRequiredErrorMessage;

    @Find(key = "titleAdminPortal")
    private IElement titleAdminPortal;

    @Find(key = "btnLogin")
    private IElement btnLogin;

    @Find(key = "eleLoginFailPopup")
    private IElement eleLoginFailPopup;

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
        enterEmailAddress(user.getUsername());
        enterPassword(user.getPassword());
        clickButtonLogin();
        waitForPageLoadingComplete();
        return HomePage.getInstance();
    }

    public void enterEmailAddress(String sEmailAddress) {
        txtEmailAddress.enter(sEmailAddress);
    }

    public void enterPassword(String sPassword) {
        txtPassword.enter(sPassword);
    }

    public void clickTitleAdminPortal() {
        titleAdminPortal.click();
    }

    public void clickButtonLogin() {
        if (btnLogin.isEnabled()) {
            btnLogin.click();
        }
    }

    /**
     * Check if Button Login enabled or disabled
     *
     * @return true if Button Login is enabled. Otherwise, return false if Button Login is disabled.
     */
    public boolean isButtonLoginEnabled() {
        return btnLogin.isEnabled();
    }

    public boolean isDisplayedErrorMessage(String value) {
        return lblErrorMessage.of(value).isDisplayed();
    }

    public boolean isDisplayedLblErrorMessage(String value) {
        return lblRequiredErrorMessage.of(value).isDisplayed();
    }

    public boolean isDisplayedLoginFailPopup() {
        return eleLoginFailPopup.isDisplayed();
    }

    public boolean isDisplayedTitleAdminPortal() {
        return titleAdminPortal.isDisplayed();
    }
}


