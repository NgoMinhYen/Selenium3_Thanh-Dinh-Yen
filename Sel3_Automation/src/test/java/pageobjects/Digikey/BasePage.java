package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

@ResourcePage(file = "basePage.properties")
public class BasePage extends AbstractPage {
    private static BasePage basePage = null;

    @Find(key = "eleProduct")
    private IElement eleProduct;

    @Find(key = "eleAutomationAndControlOfProduct")
    private IElement eleAutomationAndControlOfProduct;

    @Find(key = "eleMachineVisionCamerasSensors")
    private IElement eleMachineVisionCamerasSensors;

    public void hoverElementProduct(){
        eleProduct.waitForVisibility();
        eleProduct.hover();
    }

    public void hoverElementAutomationAndControlOfProduct(){
        eleAutomationAndControlOfProduct.waitForVisibility();
        eleAutomationAndControlOfProduct.hover();
    }

    public MachineVisionCamerasSensorsPage clickElementMachineVisionCamerasSensors(){
        eleMachineVisionCamerasSensors.waitForVisibility();
        eleMachineVisionCamerasSensors.click();
        waitForPageLoadingComplete();
        return MachineVisionCamerasSensorsPage.getInstance();
    }
    private BasePage() {
        Page.init(this);
    }

    public static synchronized BasePage getInstance() {
        if (basePage == null)
            basePage = new BasePage();
        return basePage;
    }

}
