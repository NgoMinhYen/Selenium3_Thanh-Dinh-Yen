package elementTest;

import core.framework.elements.Element;
import core.framework.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Select extends Element {
    private Locator options;
    public Select(Locator combobox, Locator options) {
        super(combobox);
        this.options = options;
    }

    /**
     * Get element options and return WebElement
     */
    private List<WebElement> getOptions(){
        return getElement().findElements(options.getBy());
    }
    /**
     * from element options get text and compare with value
     */
    public void selectText(String value){
        for (WebElement option : getOptions()){
            if (option.getText().equals(value)){
                option.click();
            }
        }
    }
}
