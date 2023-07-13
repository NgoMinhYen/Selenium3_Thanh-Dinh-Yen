package pageobjects;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.locator.Locator;
import utils.enums.RecruitmentColumnHeader;


public class RecruitmentPage extends AbstractPage {
    private static RecruitmentPage instance                 = null;
    private        IElement        btnAdd                   = new Element(Locator.xpath("//div[@class='orangehrm-header-container']/button[//text()[normalize-space() = 'Add']]"));
    private        String          sCheckboxCandidate       = "//div[@role='cell'][count(//div[@role='row']//div[@role='columnheader' and text()='%s']/preceding-sibling::div) + 1]/div[text()='%s']/parent::div/preceding-sibling::div//span";
    private        IElement        btnDeleteSelected        = new Element(Locator.xpath("//button[text()=' Delete Selected ']"));
    private        String          sCandidate               = "//div[@role='cell'][count(//div[@role='row']//div[@role='columnheader' and text()='%s']/preceding-sibling::div) + 1]/div[text()='%s']";
    private        String          sIconViewDetailCandidate = "//div[@role='cell'][count(//div[@role='row']//div[@role='columnheader' and text()='%s']/preceding-sibling::div) + 1]/div[text()='%s']/parent::div/following-sibling::div//button[i[@class='oxd-icon bi-eye-fill']]";

    private RecruitmentPage() {
    }

    public static synchronized RecruitmentPage getInstance() {
        if (instance == null)
            instance = new RecruitmentPage();
        return instance;
    }

    public RecruitmentPageForm clickAddRecruitmentButton() {
        btnAdd.click();
        return RecruitmentPageForm.getInstance();
    }

    public void selectCandidate(RecruitmentColumnHeader candidate, String value) {
        IElement eleCheckboxCandidate = new Element(Locator.dynamicXPath(sCheckboxCandidate, candidate.getValue(), value));
        eleCheckboxCandidate.check();
    }

    public void clickDeleteSelectedButton() {
        btnDeleteSelected.click();
    }

    public boolean isNotDisplayedCandidate(RecruitmentColumnHeader candidate, String value) {
        IElement eleCandidate = new Element(Locator.dynamicXPath(sCandidate, candidate.getValue(), value));
        return !eleCandidate.isDisplayed();

    }

    public RecruitmentPageForm clickIconViewDetailCandidate(RecruitmentColumnHeader candidate, String value) {
        IElement icViewDetailCandidate = new Element(Locator.dynamicXPath(sIconViewDetailCandidate, candidate.getValue(), value));
        icViewDetailCandidate.waitForVisibility();
        icViewDetailCandidate.click();
        return RecruitmentPageForm.getInstance();
    }


}
