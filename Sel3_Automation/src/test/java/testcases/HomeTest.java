package testcases;

import org.testng.annotations.Test;
import pageobjects.Digikey.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test(description = "Test case 005: User can download datasheet of product")
    public void TC_005() {
        logger.step("Step 1: Navigate to Digi-Key website\n" +
                "url: https://www.digikey.com/");
        logger.step("Step 2: Select 'Products' " +
                "-> 'Automation and Control'" +
                "-> 'Machine Vision - Camera/Sensors'");
        homePage.hoverHeaderMenu("Products");
        homePage.hoverHeaderMenuItemLevel1("Automation and Control");
    }
}
