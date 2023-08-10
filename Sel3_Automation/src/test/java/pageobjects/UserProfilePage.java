package pageobjects;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;

@ResourcePage(file = "userProfilePage.properties")
public class UserProfilePage extends AbstractPage{

    private static UserProfilePage instance = null;

    @Find(key = "titleUserProfile")
    private IElement titleUserProfile;

    @Find(key = "txtFirstName")
    private IElement txtFirstName;

    @Find(key = "txtPhone")
    private IElement txtPhone;

    @Find(key = "btnSave")
    private IElement btnSave;

    private UserProfilePage() {
        Page.init(this);
    }

    public static synchronized UserProfilePage getInstance(){
        if (instance == null)
            instance = new UserProfilePage();
        return instance;
    }

    public void enterFirstName(String sFirstName) {
        txtFirstName.enter(sFirstName);
    }

    public void enterPhone(String sPhone) {
        txtPhone.enter(sPhone);
    }

    public boolean isButtonSaveEnabled() {
        btnSave.waitForVisibility();
        return btnSave.isEnabled();
    }

    public boolean isDisplayedUserProfilePage() {
        return titleUserProfile.isDisplayed();
    }

}
