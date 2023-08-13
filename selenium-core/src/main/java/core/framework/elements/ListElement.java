package core.framework.elements;

import core.framework.commons.Constant;
import core.framework.locator.Locator;
import core.framework.locator.LocatorType;
import core.framework.wrappers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListElement  implements IListElement  {

    private Logger logger        = LoggerFactory.getLogger(ListElement.class);
    private long   timeOutSecond = Constant.DEFAULT_TIME_OUT;

    private LocatorType locatorType;
    private Locator locator;


    public ListElement(Locator locator) {
        this.locator = locator;
    }

    /**
     * Click element đầu tiền trong ListElement
     */
    @Override
    public void click() {
        getElement().click();
    }

    /**
     * Click all element
     */
    @Override
    public void clickAll() {
        getElements().forEach(e -> e.click());
    }

    /**
     * CLick theo index của element trong list element
     * @param index
     */
    @Override
    public void click(int index) {
        getElements().get(index).click();
    }

    /**
     * CLick theo text
     * @param text
     */
    @Override
    public void click(String text) {
        getElements().stream().filter(e -> e.getText().equalsIgnoreCase(text)).forEach(e -> e.click());
    }

    /**
     * Get all text của list trả về danh sách text
     * @return
     */
    @Override
    public List<String> getAllText() {
        return getElements().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    /**
     * Get element đầu tiên
     * @return
     */
    @Override
    public IElement getElement() {
        return new Element(locator);
    }

    /**
     * Get all elements
     * @return
     */
    @Override
    public List<IElement> getElements() {
        List<IElement> result = new ArrayList<>();
        for (WebElement e: Driver.getWebDriver().findElements(locator.getBy())) {
            result.add(new Element(e));
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return getElements().size() == 0;
    }

    /**
     * Get element theo index
     * @param index
     * @return
     */
    @Override
    public IElement getElement(int index) {
        IElement iElement = getElements().get(index);
        return iElement;
    }

    /**
     * Wait for list element visible in DOM with default time out
     */
    @Override
    public void waitForVisibility() {
        this.waitForVisibility(timeOutSecond);
    }

    /**
     * Wait for list element visible in DOM with custom time out
     *
     * @param timeOut: Seconds
     */
    @Override
    public void waitForVisibility(long timeOut) {
        try {
            new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator.getBy()));
        } catch (Exception ex) {
        }
    }
}
