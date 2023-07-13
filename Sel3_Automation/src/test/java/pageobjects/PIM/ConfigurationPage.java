package pageobjects.PIM;

import pageobjects.AbstractPage;

public class ConfigurationPage extends AbstractPage {
    private static ConfigurationPage instance = null;

    private ConfigurationPage() {
    }

    public static synchronized ConfigurationPage getInstance() {
        if (instance == null)
            instance = new ConfigurationPage();
        return instance;
    }
}
