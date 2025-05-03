package StepDefinitions;

import DriverFactory.Driverfactory;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps{

    private static String getTitle;
    private LoginPage loginPage = new LoginPage(Driverfactory.getdriver());
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println(loginPage.getUrl());
        //Driverfactory.getdriver().get("https://automationexercise.com/login");
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        getTitle=loginPage.getLoginPageTitle();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {

        Assert.assertEquals(getTitle,expectedTitle,"Title Mismatch");
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.forgotPassLinkCheck());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
    loginPage.enterUsername(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
    loginPage.enterPass(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
       loginPage.clickOnLogin();
    }



}
