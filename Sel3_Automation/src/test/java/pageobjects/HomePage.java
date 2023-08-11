package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "homePage.properties")
public class HomePage extends AbstractPage{
    private static HomePage instance = null;
    @Find(key = "eleTitle")
    private IElement eleTitle;

    @Find(key = "eleUserProfile")
    private IElement eleUserProfile;

    @Find(key = "eleStringOnPopup")
    private IElement eleStringOnPopup;

    @Find(key = "eleStringTitle")
    private IElement eleStringTitle;


    private HomePage() {
        Page.init(this);
    }

    public static synchronized HomePage getInstance(){
        if (instance == null)
            instance = new HomePage();
        return instance;
    }

    public boolean isDisplayedTitle(String value) {
        return eleTitle.of(value).isDisplayed();
    }

    public boolean isDisplayedEleOnPopup(String value) {
        return eleStringOnPopup.of(value).isDisplayed();
    }

    public void clickElement(String value) {
        eleStringOnPopup.of(value).click();
    }

    public UserProfilePage clickUserProfile() {
        eleUserProfile.waitForVisibility();
        eleUserProfile.click();
        return UserProfilePage.getInstance();
    }

    public PartnersPage selectPartner(String title) {
        eleTitle.of(title).waitForVisibility();
        eleTitle.of(title).click();
        return PartnersPage.getInstance();
    }

    //Coi lai
    public AccountsPage selectTitle(String title) {
        eleTitle.of(title).waitForVisibility();
        eleTitle.of(title).click();
        return AccountsPage.getInstance();
    }
}
