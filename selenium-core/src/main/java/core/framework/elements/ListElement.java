package core.framework.elements;

import core.framework.commons.Constant;
import core.framework.locator.Locator;
import core.framework.locator.LocatorType;
import core.framework.wrappers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Override
    public void click() {
        getElement().click();
    }

    @Override
    public void clickAll() {
        getElements().forEach(e -> e.click());
    }

    @Override
    public void click(int index) {
        getElements().get(index).click();
    }

    @Override
    public void click(String text) {
        getElements().stream().filter(e -> e.getText().equalsIgnoreCase(text)).forEach(e -> e.click());
    }

    @Override
    public List<String> getAllText() {
        return getElements().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    @Override
    public IElement getElement() {
        return new Element(locator);
    }

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

    @Override
    public IElement getElement(int index) {
        IElement iElement = getElements().get(index);
        return iElement;
    }
}
