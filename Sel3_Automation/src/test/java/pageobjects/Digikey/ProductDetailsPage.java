package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

@ResourcePage(file = "productDetailsPage.properties")
public class ProductDetailsPage extends AbstractPage {
    private static ProductDetailsPage productDetailsPage = null;

    @Find(key = "eleNameProduct")
    private IElement eleNameProduct;

    @Find(key = "checkboxBanerEngineer")
    private IElement checkboxBanerEngineer;

    @Find(key = "checkboxVE")
    private IElement checkboxVE;

    @Find(key = "checkboxBulk")
    private IElement checkboxBulk;

    @Find(key = "eleSearchCountRemaining")
    private IElement eleSearchCountRemaining;

    @Find(key = "btnViewSimilar")
    private IElement btnViewSimilar;

    private ProductDetailsPage() {
        Page.init(this);
    }

    public static synchronized ProductDetailsPage getInstance() {
        if (productDetailsPage == null)
            productDetailsPage = new ProductDetailsPage();
        return productDetailsPage;
    }

    public String getNameProduct() {
        eleNameProduct.waitForVisibility();
        return eleNameProduct.getText();
    }

    public String getSearchCountRemaining () {
        eleSearchCountRemaining.waitForVisibility();
        return eleSearchCountRemaining.getText();
    }

    public void clickCheckboxBanerEngineer() {
        checkboxBanerEngineer.waitForVisibility();
        checkboxBanerEngineer.check();
    }

    public void clickCheckboxVE() {
        checkboxVE.waitForVisibility();
        checkboxVE.check();
    }

    public void clickCheckboxBulk() {
        checkboxBulk.waitForVisibility();
        checkboxBulk.check();
    }

    public MachineVisionCamerasSensorsPage clickBtnViewSimilar() {
        btnViewSimilar.waitForVisibility();
        btnViewSimilar.click();
        return MachineVisionCamerasSensorsPage.getInstance();
    }

}
