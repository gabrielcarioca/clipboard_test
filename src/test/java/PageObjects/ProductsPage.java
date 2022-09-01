package PageObjects;

import Utility.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends AbstractPage{

    @FindBy(name = "s")
    private WebElement sortSelect;

    @FindBy(xpath = "(//div[contains(@class, 's-product-image-container')])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[contains(@class, 's-product-image-container')]")
    private List<WebElement> products;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSortSelect() {
        return sortSelect;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    public void sortBy(String sortValue) {
        waitUtility().waitForElementToBeVisible(driver, sortSelect);
        new Select(sortSelect).selectByVisibleText(sortValue);
    }

    public void openProductAtPosition(int position) {
        waitUtility().waitForElementToBeVisible(driver, firstProduct);
        waitUtility().waitForElementToBeClickable(driver, products.get(position-1));
        products.get(position-1).click();
    }
}
