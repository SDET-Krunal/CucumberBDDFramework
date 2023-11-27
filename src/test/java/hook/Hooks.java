package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.BasePage;

public class Hooks {

    private final BasePage basePage = new BasePage();

    @Before(order = 0)
    public void loadConfigProperties() {
        basePage.loadConfigProperties();
    }

    @Before(order = 1)
    public void initializeBrowser() {
        String browserName = BasePage.getConfigProperties().getProperty("browser");
        basePage.initializeBrowser(browserName);
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = basePage.takeScreenshot();
            scenario.attach(sourcePath, "image/jpeg", screenshotName);
        }
    }

    @After(order = 0)
    public void closeBrowser() {
        basePage.turnOffBrowser();
    }
}
