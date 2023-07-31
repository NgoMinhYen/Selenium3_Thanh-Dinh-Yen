package core.framework.elements;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IListElement {
    void click();
    void clickAll();

    void click(int index);
    void click(String text);
    List<String> getAllText();

    IElement getElement();
    List<IElement> getElements();

    boolean isEmpty();
    IElement getElement(int index);
}
