package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.BasePage;

public class Hooks {
    BasePage basePage = new BasePage();

    @Before
    public void initializeBrowser() {
        basePage.initializeBrowser();
    }

    @After
    public void closeBrowser() {
        basePage.turnOffBrowser();
    }
}
