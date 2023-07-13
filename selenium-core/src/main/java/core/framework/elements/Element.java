package core.framework.elements;

import core.framework.commons.Constant;
import core.framework.locator.Locator;
import core.framework.locator.LocatorType;
import core.framework.wrappers.Driver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class Element implements IElement{
    private Logger logger        = LoggerFactory.getLogger(Element.class);
    private long   timeOutSecond = Constant.DEFAULT_TIME_OUT;

    private LocatorType locatorType;
    private Locator     locator;

    private Actions action;
    
    private Locator options;
    
    public Element(Locator locator) {
        this.locator = locator;
    }

    /**
	 * Check if element is displayed in DOM
	 *
	 * @return true if element is enabled. Otherwise, return false.
	 */
    @Override
    public boolean isDisplayed() {
        try {
            waitForVisibility();
            return getElement().isDisplayed();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
	 * Input text into the element
	 *
	 * @param value the value of the text to be entered
	 */
    @Override
    public void enter(String value) {
    	logger.info(String.format("Enter '%s' on %s", value, getElement()));
    	waitForVisibility();
        getElement().clear();
        getElement().sendKeys(value);
    }

    /**
	 * Click on the element
	 */
    @Override
    public void click() {
    	try {
    		logger.info(String.format("Click on %s", getElement()));
    		getElement().click();
    	} catch (Exception e){
    		logger.error(String.format("Has error with control '%s': %s", getElement(), e.getMessage()));
    	}
    }

    /**
	 * Check the element
	 */
    @Override
    public void check() {
        waitForVisibility();
        if (!isChecked()) {
            waitForClickable();
            getElement().click();
        }
    }

    /**
	 * Uncheck the element
	 */
    @Override
    public void uncheck() {
        waitForVisibility();
        if (isChecked()) {
            getElement().click();
        }
    }

    /**
	 * Check if the element checked or unchecked
	 *
	 * @return true if the element is checked. Otherwise, return false if the element is unchecked.
	 */
    @Override
    public boolean isChecked() {
        return getElement().isSelected();
    }

    /**
	 * Check if the element enabled or disabled
	 *
	 * @return true if the element is enabled. Otherwise, return false if the element is disabled.
	 */
    @Override
    public boolean isEnabled() {
        return getElement().isEnabled();
    }


    /**
	 * Get the list of text of elements
	 *
	 * @return List<String> List of string
	 */
    @Override
    public List<String> getTextList() {
        return getElement().findElements(locator.getBy()).stream().map(WebElement::getText).filter(StringUtils::isNoneEmpty).collect(Collectors.toList());
    }

    // xem lai
    @Override
    public List<WebElement> getElements() {
        return Driver.getWebDriver().findElements(locator.getBy());
    }

    /**
	 * Get text value of an element with wait element visible custom time out
	 *
	 * @param timeOut: Seconds timeout to wait for element to displayed
	 * @return text value of text
	 */
    @Override
    public String getText(long timeOut) {
        try {
            this.waitForVisibility(timeOut);
            return this.getElement().getText();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
	 * Get text value of an element with wait element visible default time out
	 *
	 * @return text value of text
	 */
    @Override
    public String getText() {
        return this.getText(timeOutSecond);
    }

    @Override
    public WebElement getElement() {
        try {
            return Driver.getWebDriver().findElement(locator.getBy());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    /**
     * Wait for an element visible in DOM with default time out
     */
    @Override
    public void waitForVisibility() {
        this.waitForVisibility(timeOutSecond);
    }

    /**
     * Wait for an element visible in DOM with custom time out
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

    /**
     * Wait for an element invisible in DOM with default time out
     */
    @Override
    public void waitForInvisibility() {
        this.waitForInvisibility(timeOutSecond);
    }

    /**
     * Wait for an element invisible in DOM with custom time out
     *
     * @param timeOut: Seconds
     */
    @Override
    public void waitForInvisibility(long timeOut) {
        try {
            new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator.getBy()));
        } catch (Exception ex) {
        }
    }


    /**
     * Wait for element clickable with default time out
     */
    @Override
    public void waitForClickable() {
        this.waitForClickable(timeOutSecond);
    }

    /**
     * Wait for element clickable with custom time out
     *
     * @param timeOut: seconds
     */
    @Override
    public void waitForClickable(long timeOut) {
        try {
            new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.elementToBeClickable(locator.getBy()));
        } catch (Exception e) {
        }
    }

    /**
     * Hover into an element
     */
    @Override
    public void hover() {
        waitForVisibility();
        this.action = new Actions(Driver.getWebDriver());
        action.moveToElement(getElement()).perform();
    }

    /**
     * Get DOM value of an element with wait element visible custom time out
     *
     * @param property: DOM property
     * @return text value
     */
    @Override
    public String getDomProperty(String property) {
        return this.getDomProperty(property, timeOutSecond);
    }

    /**
     * Get DOM value of an element with wait element visible custom time out
     *
     * @param property: dom property
     * @return text value
     */
    @Override
    public String getDomProperty(String property, long timeOut) {
        try {
            this.waitForVisibility(timeOut);
            return this.getElement().getDomProperty(property);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * Get DOM value of an element with wait element visible custom time out
     *
     * @param attribute: DOM property
     * @return text value
     */
    @Override
    public String getDomAttribute(String attribute) {
        return this.getDomAttribute(attribute, timeOutSecond);
    }

    /**
     * Get DOM value of an element with wait element visible custom time out
     *
     * @param attribute: dom attribute
     * @return text value
     */
    @Override
    public String getDomAttribute(String attribute, long timeOut) {
        try {
            this.waitForVisibility(timeOut);
            return this.getElement().getDomAttribute(attribute);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pressKey(CharSequence... value) {
        waitForVisibility();
        getElement().sendKeys(value);
    }

//    public void selectText(String value){
//        Select select = new Select(getElement());
//        select.selectByVisibleText(value);
//    }
}
