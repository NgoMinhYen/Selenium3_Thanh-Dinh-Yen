package pageobjects.AccountPage;

import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.HomePage;

//@ResourcePage(file = "partnerPage.properties")
public class PartnerPage {
    private static PartnerPage instance = null;
    private PartnerPage() {
        Page.init(this);
    }

    public static synchronized PartnerPage getInstance(){
        if (instance == null)
            instance = new PartnerPage();
        return instance;
    }
}
