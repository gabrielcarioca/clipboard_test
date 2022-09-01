package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitUtility {

    private static WaitUtility singleInstance;
    private final Duration timeoutInSeconds = Duration.ofSeconds(4);

    public static WaitUtility getInstance(){
        if(singleInstance == null){
            singleInstance = new WaitUtility();
        }
        return singleInstance;
    }


    public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait(driver).withTimeout(timeoutInSeconds).ignoring(IndexOutOfBoundsException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible (WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible (WebDriver driver, String elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
    }

    public void waitForElementToBeInvisible (WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForNumberOfWindowsToEqual(WebDriver driver, final int numberOfWindows) {
        new WebDriverWait(driver, timeoutInSeconds) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (driver.getWindowHandles().size() == numberOfWindows);
            }
        });
    }
}