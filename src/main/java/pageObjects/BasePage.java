package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void initializeBrowser() {
        driver = new ChromeDriver();
    }

    public void turnOffBrowser() {
        driver.quit();
    }

    public void openURL() {
        driver.get("https://www.saucedemo.com/");
    }

    public void waitUntilElementToBeVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
