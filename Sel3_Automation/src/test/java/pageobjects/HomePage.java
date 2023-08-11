package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "homePage.properties")
public class HomePage extends AbstractPage{
    private static HomePage instance = null;
    @Find(key = "titleWelcome")
    private IElement titleWelcome;

    @Find(key = "eleUserProfile")
    private IElement eleUserProfile;

    @Find(key = "elePartner")
    private IElement elePartner;

    @Find(key = "eleLogout")
    private IElement eleLogout;

    @Find(key = "eleLogoutPopup")
    private IElement eleLogoutPopup;

    @Find(key = "btnYes")
    private IElement btnYes;

    @Find(key = "eleAccount")
    private IElement eTitleAccount;


    private HomePage() {
        Page.init(this);
    }

    public static synchronized HomePage getInstance(){
        if (instance == null)
            instance = new HomePage();
        return instance;
    }

    public boolean isDisplayedHomePage() {
        return titleWelcome.isDisplayed();
    }

    public boolean isDisplayedLogoutPopup() {
        return eleLogoutPopup.isDisplayed();
    }

    public void clickLogout() {
        eleLogout.waitForVisibility();
        eleLogout.click();
    }

    public void clickYes() {
        if (btnYes.isEnabled()) {
            btnYes.click();
        }
    }

    public UserProfilePage clickUserProfile() {
        eleUserProfile.waitForVisibility();
        eleUserProfile.click();
        return UserProfilePage.getInstance();
    }

    public PartnersPage clickPartner() {
        elePartner.waitForVisibility();
        elePartner.click();
        return PartnersPage.getInstance();
    }

    //Coi lai
    public AccountsPage clickAccounts() {
        String title = "Accounts";
        eTitleAccount.waitForVisibility();
        eTitleAccount.click();
        return AccountsPage.getInstance();
    }
}
