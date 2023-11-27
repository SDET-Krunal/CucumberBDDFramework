package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.SideNavigationPanel;
import utility.Constant;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage(BasePage.getDriver());
    ProductsPage productsPage = new ProductsPage(BasePage.getDriver());
    SideNavigationPanel sideNavigationPanel = new SideNavigationPanel(BasePage.getDriver());

    @Given("User is on application login page")
    public void openApplication() {
        loginPage.openURL();
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.doLogin(username, password);
    }

    @Then("User should get navigated to application Home page")
    public void verifyApplicationHomePage() {
        assert productsPage.getPageTitle().equals(Constant.PRODUCTS);

        sideNavigationPanel.doLogout();
    }

    @Then("Locked out user should get an error while login into application")
    public void locked_out_user_should_get_an_error_while_login_into_application() {
        assert loginPage.getLoginErrorMsg().equals(Constant.LOGIN_ERROR_MSG);
    }
}
