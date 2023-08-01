package pageobjects.Digikey;

import core.framework.elements.IElement;
import core.framework.elements.IListElement;
import core.framework.source.Find;
import core.framework.source.Page;
import core.framework.source.ResourcePage;
import pageobjects.AbstractPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static core.framework.browsers.IWebDriver.logger;

@ResourcePage(file = "machineVisionCamerasSensorsPage.properties")
public class MachineVisionCamerasSensorsPage extends AbstractPage {
    private static MachineVisionCamerasSensorsPage machineVisionCamerasSensorsPage = null;

    @Find(key = "listProductOnAPage")
    private IListElement listProductOnAPage;

    @Find(key = "eleProductCount")
    private IElement eleProductCount;

    @Find(key = "btnMfrPartAsc")
    private IElement btnMfrPartAsc;

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

    public void clickBtnMfrPartAsc() {
        btnMfrPartAsc.waitForVisibility();
        btnMfrPartAsc.clickByJs();
    }

    public int getProductCountOnPage() {
        return listProductOnAPage.getElements().size();
    }

    public String getNameOfFirstProduct() {
        return listProductOnAPage.getElement(0).getText();
    }

    public String getProductCount() {
        eleProductCount.waitForVisibility();
        return eleProductCount.getText();
    }

    public List<String> getListNameProduct() {
        listProductOnAPage.waitForVisibility();
        return listProductOnAPage.getAllText();
    }

    public boolean isCheckSortNameProductList(List<String> listNameProduct) throws InterruptedException {
        //Lay ds ten san pham sau khi click sort asc
        List<String> listNameProductAfterClickSort = getListNameProduct();
        // Tạo một bản sao của danh sách gốc
        List<String> sortedList = new ArrayList<>(listNameProduct);
        // Sắp xếp danh sách sao chép
        Collections.sort(sortedList);
        logger.info("Expected sorted list: " + listNameProductAfterClickSort.toString() + "\nActual sorted list: " + sortedList.toString());
        // So sánh danh sách sao chép với danh sách gốc
        return sortedList.equals(listNameProductAfterClickSort);
    }
}
