package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By lockedOutUserError = By.xpath("//h3[@data-test=\"error\"]");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String userName) {
        driver.findElement(username).sendKeys(userName);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void doLogin(String userName, String pwd) {
        enterUsername(userName);
        enterPassword(pwd);
        clickOnLoginBtn();
    }

    public String getLoginErrorMsg() {
        return driver.findElement(lockedOutUserError).getText();
    }
}
