package Stepdefs;

import PageObjects.*;
import Utility.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AmazonSearchStepDefs extends BaseStepDefs{
    public CategoryFilterPage categoryFilterPage;
    public ProductFilterPage productFilterPage;
    public ProductsPage productsPage;
    public ProductPage productPage;

    @Before(order = 1)
    public void beforeSuite() {
        System.out.println("BeforeTest");

        categoryFilterPage = new CategoryFilterPage(driver());
        productFilterPage = new ProductFilterPage(driver());
        productsPage = new ProductsPage(driver());
        productPage = new ProductPage(driver());
    }

    @Given("^User goes to the Amazon page$")
    public void goToAmazonPage() throws MalformedURLException{
        driver().navigate().to(new URL("https://www.amazon.in/"));
        categoryFilterPage.waitForHamburgerMenuButton();
    }

    @When("^User opens filter menu$")
    public void openFilterMenu() {
        categoryFilterPage.getHamburgerMenuButton().click();
        categoryFilterPage.waitForFilterMenuDiv();
    }

    @And("^User selects section \"([^\"]*)\" under category \"([^\"]*)\"$")
    public void selectCategoryFilter(String filterSection, String filterCategory) {
        categoryFilterPage.clickFilterSection(filterSection, filterCategory);
    }

    @And("^User selects \"([^\"]*)\" under section \"([^\"]*)\"$")
    public void selectProductFilter(String filterValue, String filterSection) {
        productFilterPage.clickFilterValue(filterSection, filterValue);
    }

    @And("^User sorts by \"([^\"]*)\"$")
    public void sortProducts(String sortValue) {
        productsPage.sortBy(sortValue);
    }

    @And("^User opens result at position \"([^\"]*)\"$")
    public void openProduct(String productPosition) {
        productsPage.openProductAtPosition(Integer.parseInt(productPosition));
        WaitUtility.getInstance().waitForNumberOfWindowsToEqual(driver(), 2);
        ArrayList<String> driverTabs = new ArrayList<String> (driver().getWindowHandles());
        driver().switchTo().window(driverTabs.get(1));
    }

    @Then("^Assert and print About this item section$")
    public void assertAboutSection() {
        Assert.assertTrue(productPage.isAboutSectionVisible(), "About this item section not present");
        System.out.println(productPage.getAboutItemText());
    }
}
