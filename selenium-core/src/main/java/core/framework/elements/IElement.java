package core.framework.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public interface IElement{
    boolean isDisplayed();

    void enter(String value);
//    void clear();
    Element of(Object... content);

    void click();

    void clickByJs();

    void check();

    void uncheck();

    boolean isChecked();

    boolean isEnabled();

    List<String> getTextList();

    List<WebElement> getElements();

    String getText(long timeOut);

    String getText();

    WebElement getElement();

    void waitForVisibility();

    void waitForVisibility(long timeOut);

    void waitForInvisibility();

    void waitForInvisibility(long timeOut);

    void waitForClickable();

    void waitForClickable(long timeOut);

    void hover();

    String getDomProperty(String property);

    String getDomProperty(String property, long timeOut);

    String getDomAttribute(String attribute);

    String getDomAttribute(String attribute, long timeOut);

    void pressKey(CharSequence... value);

    void selectText(String value);

    void selectValue(String value);

    void clear();
}
