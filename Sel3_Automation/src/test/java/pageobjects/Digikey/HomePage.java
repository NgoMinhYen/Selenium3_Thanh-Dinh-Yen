package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;
import pageobjects.LoginPage;

@ResourcePage(file = "homePage.properties")
public class HomePage extends AbstractPage {
    private static HomePage instance = null;
    @Find(key = "ccbHeaderMenu")
    private IElement ccbHeaderMenu;

    @Find(key = "lbItemLevel1")
    private IElement lbItemLevel1;

    @Find(key = "lbItemLevel2")
    private IElement lbItemLevel2;


    private HomePage() {
        Page.init(this);
    }
    public static synchronized HomePage getInstance(){
        if (instance == null)
            instance = new HomePage();
        return instance;
    }
    public HomePage hoverHeaderMenu(String value){
        ccbHeaderMenu.of(value).hover();
        return instance;
    }
    public HomePage hoverHeaderMenuItemLevel1(String value){
        lbItemLevel1.of(value).hover();
        return instance;
    }
    public HomePage clickHeaderMenuItemLevel2(String value){
        lbItemLevel2.of(value).hover();
        return instance;
    }
}
