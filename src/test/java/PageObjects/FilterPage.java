package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends AbstractPage {

    @FindBy(id = "nav-hamburger-menu")
    private WebElement hamburgerMenuButton;

    @FindBy(id = "hmenu-content")
    private WebElement hamburgerMenuDiv;

    private final String filterSectionLocator = "//li[.='[FILTER_CATEGORY]']/following-sibling::li//a[.='[FILTER_SECTION]']";
    private WebElement filterSection;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHamburgerMenuButton() {
        return hamburgerMenuButton;
    }

    public WebElement gethamburgerMenuDiv() {
        return hamburgerMenuDiv;
    }

    public void waitForHamburgerMenuButton() {
        waitUtility().waitForElementToBeClickable(driver, hamburgerMenuButton);
    }

    public void waitForFilterMenuDiv() {
        waitUtility().waitForElementToBeVisible(driver, hamburgerMenuDiv);
    }

    public WebElement getFilterSection(String filterSection, String filterCategory) {
        String locatorXpath = filterSectionLocator.replace("[FILTER_CATEGORY]", filterCategory).replace("[FILTER_SECTION]", filterSection);
        return driver.findElement(By.xpath(locatorXpath));
    }
}