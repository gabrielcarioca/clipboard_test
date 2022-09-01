package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductFilterPage extends AbstractPage {

    private final String filterLocator = "//span[.='[FILTER_SECTION]']/../following-sibling::ul//a[.//span[.='[FILTER_VALUE]']]";
    private WebElement filter;

    public ProductFilterPage(WebDriver driver) {
        super(driver);
    }

    public String getFilterLocator (String filterSection, String filterValue) {
        return filterLocator.replace("[FILTER_SECTION]", filterSection).replace("[FILTER_VALUE]", filterValue);
    }

    public WebElement getFilter(String filterSection, String filterValue) {
        return driver.findElement(By.xpath(getFilterLocator(filterSection, filterValue)));
    }

    public void clickFilterValue(String filterSection, String filterValue) {
        waitUtility().waitForElementToBeVisible(driver, getFilterLocator(filterSection, filterValue));
        WebElement element = getFilter(filterSection, filterValue);
        element.click();
    }
}
