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
}
