package core.framework.locator;

import org.openqa.selenium.By;

public class Locator {

    private LocatorType locatorType;
    private String      value;

    /**
     * Get element by xpath return locator (bọc cái by lại)
     */
    public static Locator xpath(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.XPath;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by name return locator
     */
    public static Locator name(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.Name;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by id return locator
     */
    public static Locator id(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.ID;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by linkText return locator
     */
    public static Locator linkText(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.LinkText;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by partialLinkText return locator
     */
    public static Locator partialLinkText(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.PartialLinkText;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by className return locator
     */
    public static Locator className(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.ClassName;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by tagName return locator
     */
    public static Locator tagName(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.TagName;
        locator.value = value;
        return locator;
    }
    /**
     * Get element by cssSelector return locator
     */
    public static Locator cssSelector(String value) {
        Locator locator = new Locator();
        locator.locatorType = LocatorType.CssSelector;
        locator.value = value;
        return locator;
    }

    public static Locator dynamicXPath(String xpath, Object... objects){
        Locator locator = new Locator();
        locator.locatorType = LocatorType.DynamicXPath;
        locator.value = String.format(xpath, objects);
        return locator;
    }


    public By getBy() {
        By by;
        switch (locatorType) {
            case ID:
                by = By.id(value);
                break;
            case Name:
                by = By.name(value);
                break;
            case XPath:
            case DynamicXPath:
                by = By.xpath(value);
                break;
            case PartialLinkText:
                by = By.partialLinkText(value);
                break;
            case TagName:
                by = By.tagName(value);
                break;
            case LinkText:
                by = By.linkText(value);
                break;
            case ClassName:
                by = By.className(value);
                break;
            case CssSelector:
                by = By.cssSelector(value);
                break;
            default:
                by = null;
        }

        return by;
    }


}
