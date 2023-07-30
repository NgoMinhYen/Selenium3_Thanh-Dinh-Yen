package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

@ResourcePage(file = "homePage.properties")
public class HomePage extends AbstractPage {
    @Find(key = "ccbHeaderMenu")
    private IElement ccbHeaderMenu;

    @Find(key = "lbItemLevel1")
    private IElement lbItemLevel1;

    @Find(key = "lbItemLevel2")
    private IElement lbItemLevel2;

    public void hoverHeaderMenu(String value){
        ccbHeaderMenu.of(value).hover();
    }
    public void hoverHeaderMenuItemLevel1(String value){
        lbItemLevel1.of(value).hover();
    }
}
