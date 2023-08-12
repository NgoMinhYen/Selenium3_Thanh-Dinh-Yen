package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "userProfilePage.properties")
public class UserProfilePage extends AbstractPage{

    private static UserProfilePage instance = null;

    @Find(key = "lblTitle")
    private IElement lblTitle;

    @Find(key = "txtUserActions")
    private IElement txtUserActions;

    @Find(key = "btnUserActions")
    private IElement btnUserActions;

    private UserProfilePage() {
        Page.init(this);
    }

    public static synchronized UserProfilePage getInstance(){
        if (instance == null)
            instance = new UserProfilePage();
        return instance;
    }

    public void enter(String fieldName, String value) {
        txtUserActions.of(fieldName).enter(value);
    }

    public boolean isButtonEnabled(String value) {
        btnUserActions.of(value).waitForVisibility();
        return btnUserActions.of(value).isEnabled();
    }

    public boolean isDisplayedTitle(String value) {
        return lblTitle.of(value).isDisplayed();
    }

}
