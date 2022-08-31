package Stepdefs;

//import PageObjects.*;
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
    //public HomeScreen homeScreen;
    //public SignUpModalScreen signUpModalScreen;
    //public TasksScreen tasksScreen;
    //public AddTaskModalScreen addTaskModalScreen;

    //private Task lastCreatedTask;

    @Before(order = 1)
    public void beforeSuite() {
        System.out.println("BeforeTest");

        //homeScreen = new HomeScreen(driver());
        //signUpModalScreen = new SignUpModalScreen(driver());
        //tasksScreen = new TasksScreen(driver());
        //addTaskModalScreen = new AddTaskModalScreen(driver());

        //lastCreatedTask = new Task();
    }

    @Given("^User goes to the Amazon page$")
    public void goToAmazonPage() throws MalformedURLException{
        driver().navigate().to(new URL("https://www.amazon.in/"));
        SeleniumUtility.getInstance().pauseForSeconds(10);
    }

    @When("^User pauses$")
    public void userPauses() {
        SeleniumUtility.getInstance().pauseForSeconds(10);
    }
}
