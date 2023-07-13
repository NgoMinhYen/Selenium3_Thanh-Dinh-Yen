package pageobjects;

public class MyInfoPage extends AbstractPage {
    private static MyInfoPage instance = null;

    private MyInfoPage() {
    }

    public static synchronized MyInfoPage getInstance() {
        if (instance == null)
            instance = new MyInfoPage();
        return instance;
    }


}
