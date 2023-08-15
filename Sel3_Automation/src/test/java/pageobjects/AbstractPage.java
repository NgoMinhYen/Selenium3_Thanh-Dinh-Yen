package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import core.framework.wrappers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.common.constants.Constant;
import utils.enums.LeftMenu;

import java.time.Duration;

public abstract class AbstractPage {

    private IElement eleLoadingSpinner = new Element(Locator.xpath("//div[@class='oxd-loading-spinner-container']"));

    public void waitForPageLoadingComplete() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(Constant.DEFAULT_TIME_OUT));
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Exception ex) {
        }
    }

    public void waitForLoadingSpinnerDisappear() {
        eleLoadingSpinner.waitForInvisibility();
    }

//    /**
//     * Select left menu item
//     *
//     * @param menu enum LeftMenu
//     */
//    public <T extends AbstractPage> T selectLeftMenu(LeftMenu menu) {
//        IElement eleMenuItem = new Element(Locator.xpath(String.format(leftMenuItem, menu.getValue())));
//        eleMenuItem.click();
//        T page = getPage(menu);
//        return page;
//    }
//    // java generic

    /**
     * Return page by menu selected
     *
     * @param menu left menu selected
     * @param <T>  generic page selected
     * @return page selected
     */
//    private <T extends AbstractPage> T getPage(LeftMenu menu) {
//        switch (menu) {
//            case ADMIN:
//                return (T) PIMPage.getInstance();
//            case PIM:
//                return (T) PIMPage.getInstance();
//            case LEAVE:
//                return (T) LeavePage.getInstance();
//            case TIME:
//                return (T) PIMPage.getInstance();
//            case RECRUITMENT:
//                return (T) RecruitmentPage.getInstance();
//            case MY_INFO:
//                return (T) PIMPage.getInstance();
//            case PERFORMANCE:
//                return (T) PIMPage.getInstance();
//            case DASHBOARD:
//                return (T) PIMPage.getInstance();
//            case DIRECTORY:
//                return (T) PIMPage.getInstance();
//            case MAINTENANCE:
//                return (T) PIMPage.getInstance();
//            case BUZZ:
//                return (T) PIMPage.getInstance();
//            default:
//                return null;
//        }
//    }

    /**
     * Display toast message in left bottom page
     *
     * @return true/false
     */




}
