package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

@ResourcePage(file = "machineVisionCamerasSensorsPage.properties")
public class MachineVisionCamerasSensorsPage extends AbstractPage {
    private static MachineVisionCamerasSensorsPage machineVisionCamerasSensorsPage = null;

    @Find(key = "listProductOnAPage")
    private IListElement listProductOnAPage;

    public int getProductCountOnPage() {
        return listProductOnAPage.getElements().size();
    }

    public String getNameOfFirstProduct() {
        return listProductOnAPage.getElement(0).getText();
    }

    private MachineVisionCamerasSensorsPage() {
        Page.init(this);
    }

    public static synchronized MachineVisionCamerasSensorsPage getInstance() {
        if (machineVisionCamerasSensorsPage == null)
            machineVisionCamerasSensorsPage = new MachineVisionCamerasSensorsPage();
        return machineVisionCamerasSensorsPage;
    }

    public ProductDetailsPage clickFirstProduct() {
        waitForPageLoadingComplete();
        IElement eleFirstProduct = listProductOnAPage.getElements().get(0);
        eleFirstProduct.waitForVisibility();
        eleFirstProduct.clickByJs();
        return ProductDetailsPage.getInstance();
    }
}
