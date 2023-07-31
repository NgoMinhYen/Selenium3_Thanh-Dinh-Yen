package testcases;

import org.testng.annotations.Test;
import pageobjects.Digikey.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage = HomePage.getInstance();
    @Test(description = "Test case 005: User can download datasheet of product")
    public void TC_005() {
        logger.step("Step 1: Navigate to Digi-Key website\n" +
                "url: https://www.digikey.com/");
        logger.step("Step 2: Select 'Products' " +
                "-> 'Automation and Control'" +
                "-> 'Machine Vision - Camera/Sensors'");
        homePage.hoverHeaderMenu("Products")
                .hoverHeaderMenuItemLevel1("Automation and Control")
                .clickHeaderMenuItemLevel2("Machine Vision - Camera/Sensors");
        logger.step("Step 3: Click on icon pdf to save file datasheet of product \"VE201G1A\"");
        logger.step("Verify step 3: Content of PDF datasheet file display");

        logger.step("Step 4: Click on icon pdf to save files datasheet of product \"IVU2PRGW08\" " +
                "and \"IVU2PRCW12\"Click on icon pdf to save files datasheet of product \"IVU2PRGW08\" " +
                "and \"IVU2PRCW12\"");
        logger.step("Verify step 4: 2 downloaded PDF files is same (compare file PDF)");
    }
    public void TC_006() {
        logger.step("Step 6: Click \"Download Table\" ");
        logger.step("Step 7: Select \"Currently Visible Results\"");
        logger.step("Step 8: Click Download");
        logger.step("Step 9: Save as file\n" +
                "- Click Save as \n" +
                "- Browser to local location\n" +
                "- Name file \n" +
                "- Click Save");
        logger.step("Verify step 9: Row number in excel = 2, " +
                "check all data in excel match with table in webpage");
    }
    public void TC_007() {
        logger.step("Step 1: Navigate to Digi-Key website\n" +
                "url: https://www.digikey.com/");
        logger.step("Step 2: Navigate to Register page by hover on \"Login or REGISTER\" link " +
                "on top menu then click on Register");
        logger.step("Step 3: Select \"For a business\"");
        logger.step("Verify step 3: Content of PDF datasheet file display");

        logger.step("Step 4: Input data as below:\n" +
                "Enter First name -> random text\n" +
                "Enter Last name -> random text\n" +
                "Enter Company name-> random text\n" +
                "Select Job Title: Owner/ President\n" +
                "Enter text in Phone->-> random characters including number and text (e.g \"0900text\" \n" +
                "Enter an actived email \n" +
                "Enter Password: 123\n" +
                "Enter Confirm Password:123");
        logger.step("Verify step 4: Verify message: \n" +
                "- Invalid phone number \n" +
                "- A registration already exists with this email address. Please login to the existing registration or enter an alternate email address.\n" +
                "- Password must be at least 8 characters long.\n" +
                "+ Contain at least 8 characters\n" +
                "+ Cannot contain common or guessable text");
    }
}
