package Stepdefs;

import Utility.DriverUtility;
import Utility.SeleniumUtility;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;


public class ServiceHooks{

    @Before(order = 0)
    public void initializeTest(Scenario scenario) throws MalformedURLException {
        // Code to setup initial configurations
        System.out.println("Initialize Test");
        // Creating the chrome driver
        DriverUtility.getInstance().startANewChromeDriver();
    }

    @After(order = 0)
    public void embedScreenshot(Scenario scenario) {
        System.out.println("Finishing Test");
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
                SeleniumUtility.getInstance().takeScreenshotOnFailure(DriverUtility.getInstance().getDriver(), scenario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DriverUtility.getInstance().stopRunningDriver();
    }
}