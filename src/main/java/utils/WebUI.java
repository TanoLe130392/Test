package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WebUI {
    WebDriver driver;
    WebDriverWait wait;
    Robot robot;

    int PAGE_LOAD_TIMEOUT =20;

    public WebUI(WebDriver _driver){
        driver = _driver;
    }

    public void waitForPageLoaded() {
        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error) {
            error.getMessage();
        }
    }


    public void clickElement(By by) {
        waitForPageLoaded();
        WebElement elementWaited = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elementWaited.click();
    }

    public void setText(By by, String value) {
        waitForPageLoaded();
        WebElement elementWaited = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elementWaited.sendKeys(value);
    }

}
