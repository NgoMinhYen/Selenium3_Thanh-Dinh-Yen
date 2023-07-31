package testcases.Digikey;

import core.framework.wrappers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Digikey.BasePage;
import pageobjects.Digikey.MachineVisionCamerasSensorsPage;
import pageobjects.Digikey.ProductDetailsPage;
import testcases.BaseTest;
import utils.common.constants.Constant;

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
}
