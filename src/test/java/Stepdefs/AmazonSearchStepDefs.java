package Stepdefs;

import PageObjects.*;
import Utility.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class AmazonSearchStepDefs extends BaseStepDefs{
    public FilterPage filterPage;

    @Before(order = 1)
    public void beforeSuite() {
        System.out.println("BeforeTest");

        filterPage = new FilterPage(driver());
    }

    @Given("^User goes to the Amazon page$")
    public void goToAmazonPage() throws MalformedURLException{
        driver().navigate().to(new URL("https://www.amazon.in/"));
        filterPage.waitForHamburgerMenuButton();
    }

    @When("^User opens filter menu$")
    public void openFilterMenu() {
        filterPage.getHamburgerMenuButton().click();
        filterPage.waitForFilterMenuDiv();
    }

    @And("^User selects section \"([^\"]*)\" under category \"([^\"]*)\"$")
    public void selectProductFilter(String filterSection, String filterCategory) {
        filterPage.getFilterSection(filterSection, filterCategory).click();
        SeleniumUtility.getInstance().pauseForSeconds(5);
    }
}
