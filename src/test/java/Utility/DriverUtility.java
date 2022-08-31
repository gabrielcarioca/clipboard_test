package Utility;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtility {

    private static DriverUtility singleInstance;

    public static DriverUtility getInstance(){
        if(singleInstance == null){
            singleInstance = new DriverUtility();
        }
        return singleInstance;
    }

    private WebDriver driver;

    private boolean isDriverStarted = false;

    public void startANewChromeDriver() throws MalformedURLException{

        if (!isDriverStarted) {
            // Chrome Capabilities
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
            capability.setCapability(CapabilityType.PLATFORM_NAME, "ANY");

            // create a new instance of the chrome driver
            System.setProperty("webdriver.chrome.driver","/opt/homebrew/bin/chromedriver");
            this.driver = new ChromeDriver();
            isDriverStarted = true;
        }
    }

    public void stopRunningDriver() {
        if (isDriverStarted) {
            isDriverStarted = false;
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}