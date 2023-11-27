package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Constant;

public class SideNavigationPanel extends BasePage {

    private final By allItemLink = By.id("inventory_sidebar_link");
    private final By aboutLink = By.id("about_sidebar_link");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By resetAppStateLink = By.id("reset_sidebar_link");

    Header header = new Header(BasePage.getDriver());
    WebDriver driver;

    public SideNavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSideNavigationMenu(String menuName) {
        switch (menuName) {
            case "All Item" -> driver.findElement(allItemLink).click();
            case "About" -> driver.findElement(aboutLink).click();
            case "Logout" -> driver.findElement(logoutLink).click();
            case "Reset App State" -> driver.findElement(resetAppStateLink).click();
            default -> System.out.println("OOPs, Invalid Menu name!");
        }
    }

    public void doLogout() {
        header.clickOnBurgerMenuBtn();
        waitUntilElementToBeVisible(logoutLink);
        this.clickOnSideNavigationMenu(Constant.LOGOUT);
    }
}
