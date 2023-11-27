package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getConfigProperties() {
        return properties;
    }

    public void initializeBrowser(String browserName) {
        switch (browserName) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
            case "Edge" -> driver = new EdgeDriver();
            case "Safari" -> driver = new SafariDriver();
            case "IE" -> driver = new InternetExplorerDriver();
            default -> System.out.println("Oops! Invalid browser name...");
        }
    }

    public void loadConfigProperties() {
        ConfigReader configReader = new ConfigReader();
        properties = configReader.initializeProperty();
    }

    public void turnOffBrowser() {
        driver.quit();
    }

    public void openURL() {
        driver.get(properties.getProperty("appURL"));
    }

    public void waitUntilElementToBeVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
