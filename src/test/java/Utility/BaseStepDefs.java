package Utility;

import org.openqa.selenium.WebDriver;

public class BaseStepDefs {

    public WebDriver driver() {
        return DriverUtility.getInstance().getDriver();
    }
}