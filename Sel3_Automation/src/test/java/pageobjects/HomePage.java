package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import utils.enums.LeftMenu;

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

    public <T extends AbstractPage> T openTab( LeftMenu tab) {
        T page = getTab(tab);

        if (page == null)
            return null;

//        if (isActiveTab(tab))
//            return page;
//        waitForLoadingSpinnerDisappear();
        eleTitle.of(tab.getValue()).waitForVisibility();
        eleTitle.of(tab.getValue()).click();
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
