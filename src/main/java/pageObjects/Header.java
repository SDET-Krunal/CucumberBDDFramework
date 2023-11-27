package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    private final By burgerMenuBtn = By.id("react-burger-menu-btn");
    private final By cartIcon = By.className("shopping_cart_link");

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnBurgerMenuBtn() {
        driver.findElement(burgerMenuBtn).click();
    }

    public void clickOnShoppingCartIcon() {
        driver.findElement(cartIcon).click();
    }
}
