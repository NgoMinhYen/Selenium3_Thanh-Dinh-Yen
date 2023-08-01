package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;
import pageobjects.LoginPage;

@ResourcePage(file = "basePage.properties")
public class BasePage extends AbstractPage {
    private static BasePage basePage = null;

    @Find(key = "eleProduct")
    private IElement eleProduct;

    @Find(key = "eleAutomationAndControlOfProduct")
    private IElement eleAutomationAndControlOfProduct;

    @Find(key = "eleMachineVisionCamerasSensors")
    private IElement eleMachineVisionCamerasSensors;

    @Find(key = "eleAllProducts")
    private IElement eleAllProducts;

    @Find(key = "eleAllContent")
    private IElement eleAllContent;

    @Find(key = "eleSearchType")
    private IElement eleSearchType;

    @Find(key = "txtKeyWords")
    private IElement txtKeyWords;

    @Find(key = "btnKeyWords")
    private IElement btnKeyWords;

    @Find (key = "btnLoginOrRegister")
    private IElement btnLoginOrRegister;

    @Find (key = "btnLogin")
    private IElement btnLogin;

    public void clickAllProducts() {
        eleAllProducts.waitForVisibility();
        eleAllProducts.click();
    }

    public void clickAllContent() {
        eleAllContent.waitForVisibility();
        eleAllContent.click();
    }

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

    public ProductDetailsPage searchWithAllProducts(String sNameProduct) {
        eleSearchType.waitForVisibility();
        eleSearchType.click();
        clickAllProducts();
        enterKeyWord(sNameProduct);
        btnKeyWords.waitForVisibility();
        btnKeyWords.click();
        return ProductDetailsPage.getInstance();
    }

    public void enterKeyWord(String sNameProduct){
        txtKeyWords.waitForVisibility();
        txtKeyWords.click();
        txtKeyWords.enter(sNameProduct);
    }

    public void hoverBtnLoginOrRegister(){
        btnLoginOrRegister.waitForVisibility();
        btnLoginOrRegister.hover();
    }

    public LoginPage clickBtnLogin(){
        btnLogin.waitForVisibility();
        btnLogin.click();
        return LoginPage.getInstance();
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
