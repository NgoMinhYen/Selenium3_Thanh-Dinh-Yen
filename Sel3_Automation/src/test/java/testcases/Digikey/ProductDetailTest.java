package testcases.Digikey;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Digikey.BasePage;
import pageobjects.Digikey.MachineVisionCamerasSensorsPage;
import pageobjects.Digikey.ProductDetailsPage;
import testcases.BaseTest;
import utils.common.constants.Constant;

import java.util.List;

public class ProductDetailTest extends BaseTest {
    BasePage basePage = BasePage.getInstance();

    @Test(description = "User can view product details")
    public void ProductDetail_TC001() {
        logger.step("Step 1: Navigate to Digi-Key website, url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Select 'Products' ->'Automation and Control'-> 'Machine Vision - Camera/Sensors'");
        basePage.hoverElementProduct();
        basePage.hoverElementAutomationAndControlOfProduct();
        MachineVisionCamerasSensorsPage machineVisionCamerasSensorsPage = basePage.clickElementMachineVisionCamerasSensors();

        logger.info("Get Product Count on Page: " + machineVisionCamerasSensorsPage.getProductCountOnPage());
        logger.step("Step 3: Click on a Product name, (e.g 'VE201G1A')");
        String nameOfFirstProduct = machineVisionCamerasSensorsPage.getNameOfFirstProduct();
        logger.info("Name of First Product: " + nameOfFirstProduct);
        ProductDetailsPage productDetailsPage = machineVisionCamerasSensorsPage.clickFirstProduct();

        logger.step("VP: Check data on product details page match with data on table\n" +"- Name Product");
        logger.info("Name of product detail: " + productDetailsPage.getNameProduct());
        Assert.assertEquals(nameOfFirstProduct, productDetailsPage.getNameProduct(), "Name product on product details page match with data on table");
    }

    @Test(description = "User can search product")
    public void ProductDetail_TC002() {
        String sNameProduct = "FQ2-S10050F";
        logger.step("Step 1: Navigate to Digi-Key website, url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: 2. In Search area on top page\n" +
                "- Select: All Products\n" +
                "- Enter: name of product (e.g \"FQ2-S10050F\")\n" +
                "- Click search icon");
        ProductDetailsPage productDetailsPage = basePage.searchWithAllProducts(sNameProduct);
        productDetailsPage.waitForPageLoadingComplete();

        logger.step("Search Result shows details of product with information:\n" +
                "VP: Check data on product details page match with data on table\n" +
                "- Name Product");
        Assert.assertEquals(sNameProduct, productDetailsPage.getNameProduct(), "Name Product details page match with data on table");
    }

    @Test(description = "User can filter similar products in the product detail page")
    public void ProductDetail_TC003() {
        String sNameProduct = "VE201G1A";
        logger.step("Step 1: Navigate to Digi-Key website, url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Go to page detail of product with any product by search (e.g \"VE201G1A\")");
        ProductDetailsPage productDetailsPage = basePage.searchWithAllProducts(sNameProduct);
        productDetailsPage.waitForPageLoadingComplete();

        logger.step("Step 3: From Product Attribute area, select \"on\" to filter\n" +
                "-Category: Machine Vision - Cameras/Sensors ->On\n" +
                "- Mft: Banner Engineering Corporatio ->On\n" +
                "- Series: VE ->On\n" +
                "- Package: Bulk ->On");
        productDetailsPage.clickCheckboxBanerEngineer();
        productDetailsPage.clickCheckboxVE();
        productDetailsPage.clickCheckboxBulk();
        String searchCountRemaining = productDetailsPage.getSearchCountRemaining();

        logger.step("Step 4: Click \"View Similar\" button");
        MachineVisionCamerasSensorsPage machineVisionCamerasSensorsPage = productDetailsPage.clickBtnViewSimilar();
        machineVisionCamerasSensorsPage.waitForPageLoadingComplete();

        logger.step("Direct to the filter page, VP: Page display \"Results: 4\"");
        String productCount = machineVisionCamerasSensorsPage.getProductCount();

        Assert.assertEquals(searchCountRemaining, productCount, String.format("Direct to the filter page, VP: Page display \"Results: %s\"", productCount));
    }

    @Test(description = "User can sort column with Ascending and Descending")
    public void ProductDetail_TC004() throws InterruptedException {
        String sNameProduct = "VE201G1A";
        logger.step("Step 1: Navigate to Digi-Key website, url: https://www.digikey.com/");
        Driver.navigateTo(Constant.URL);

        logger.step("Step 2: Go to page detail of product with any product by search (e.g \"VE201G1A\")");
        ProductDetailsPage productDetailsPage = basePage.searchWithAllProducts(sNameProduct);
        productDetailsPage.waitForPageLoadingComplete();

        logger.step("Step 3: From Product Attribute area, select \"on\" to filter\n" +
                "-Category: Machine Vision - Cameras/Sensors ->On\n" +
                "- Mft: Banner Engineering Corporatio ->On\n" +
                "- Series: VE ->On\n" +
                "- Package: Bulk ->On");
        productDetailsPage.clickCheckboxBanerEngineer();
        productDetailsPage.clickCheckboxVE();
        productDetailsPage.clickCheckboxBulk();
        String searchCountRemaining = productDetailsPage.getSearchCountRemaining();

        logger.step("Step 4: Click \"View Similar\" button");
        MachineVisionCamerasSensorsPage machineVisionCamerasSensorsPage = productDetailsPage.clickBtnViewSimilar();
        machineVisionCamerasSensorsPage.waitForPageLoadingComplete();

        logger.step("Step 5: Click on icon \"Sort Ascending\" to sort with \"Mfr Part\" column");
        List<String> listNameOfFirstProduct = machineVisionCamerasSensorsPage.getListNameProduct();
        logger.info("List Name Product: " + listNameOfFirstProduct.toString());

        machineVisionCamerasSensorsPage.clickBtnMfrPartAsc();
        machineVisionCamerasSensorsPage.waitForPageLoadingComplete();
        List<String> listNameOfFirstProduct2 = machineVisionCamerasSensorsPage.getListNameProduct();


        logger.info("List Name Product after Click on icon \"Sort Ascending\" to sort with \"Mfr Part\" column: " + listNameOfFirstProduct2.toString());
        logger.step("Verify data the sorting correctly");
        Assert.assertTrue(machineVisionCamerasSensorsPage.isCheckSortNameProductList(listNameOfFirstProduct), "Verify data the sorting correctly");
    }

}
