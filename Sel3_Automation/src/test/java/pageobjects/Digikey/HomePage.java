package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

@ResourcePage(file = "HomePage.properties")
public class HomePage extends AbstractPage {
    @Find(key = "txtSearch")
    private IElement txtUserName;

}
