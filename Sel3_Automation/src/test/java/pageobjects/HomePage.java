package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import utils.enums.LeftMenu;

@ResourcePage(file = "homePage.properties")
public class HomePage extends AbstractPage{
    private static HomePage instance = null;
    @Find(key = "eleHomepageTitle")
    private IElement eleHomeTitle;

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
        eleHomeTitle.waitForVisibility();
        return eleHomeTitle.of(value).isDisplayed();
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
        eleStringTitle.of(title).waitForVisibility();
        eleStringTitle.of(title).click();
        return PartnersPage.getInstance();
    }

    //Coi lai
    public HomePage selectTitle(String title) {
        eleStringTitle.of(title).waitForVisibility();
        eleStringTitle.of(title).click();
        return HomePage.getInstance();
    }

    public <T extends AbstractPage> T openTab( LeftMenu tab) {
        T page = getTab(tab);

        if (page == null)
            return null;

//        if (isActiveTab(tab))
//            return page;
//        waitForLoadingSpinnerDisappear();
        eleStringTitle.of(tab.getValue()).waitForVisibility();
        eleStringTitle.of(tab.getValue()).click();
        page.waitForPageLoadingComplete();
        return page;
    }
    @SuppressWarnings("unchecked")
    private <T extends AbstractPage> T getTab( LeftMenu tab) {
        switch (tab) {
            case ACCOUNT:
                return (T) AccountsPage.getInstance();
            case PARTNERS:
                return (T) PartnersPage.getInstance();
            default:
                return null;
        }
    }
}
