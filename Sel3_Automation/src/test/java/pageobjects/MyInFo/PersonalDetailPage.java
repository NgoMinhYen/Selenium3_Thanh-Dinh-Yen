package pageobjects.MyInFo;

import pageobjects.AbstractPage;
import pageobjects.PIM.ConfigurationPage;

public class PersonalDetailPage extends AbstractPage {
    private static PersonalDetailPage instance = null;

    private PersonalDetailPage() {
    }

    public static synchronized PersonalDetailPage getInstance() {
        if (instance == null)
            instance = new PersonalDetailPage();
        return instance;
    }
}
