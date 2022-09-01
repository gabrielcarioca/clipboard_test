package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage{

    @FindBy(xpath = "//h1[.=' About this item ']")
    private WebElement aboutSection;

    @FindBy(xpath = "//h1[.=' About this item ']/following-sibling::ul")
    private WebElement aboutThisItemText;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAboutSection() {
        return aboutSection;
    }

    public WebElement getAboutThisItemText() {
        return aboutThisItemText;
    }

    public Boolean isAboutSectionVisible() {
        try {
            waitUtility().waitForElementToBeVisible(driver, aboutSection);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public String getAboutItemText() {
        return aboutThisItemText.getText();
    }
}
