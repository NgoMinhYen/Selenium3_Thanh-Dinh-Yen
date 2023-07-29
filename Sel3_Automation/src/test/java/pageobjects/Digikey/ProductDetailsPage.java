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

}
