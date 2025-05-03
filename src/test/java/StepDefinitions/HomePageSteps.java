package StepDefinitions;

import DriverFactory.Driverfactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private LoginPage loginPage = new LoginPage(Driverfactory.getdriver());
    HomePage homePage;
    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {

       List<Map<String, String>> credList= dataTable.asMaps();
       String username=credList.get(0).get("username");
       String pass=credList.get(0).get("password");
       loginPage.enterUsername(username);
       loginPage.enterPass(pass);
       loginPage.clickOnLogin();
       homePage = loginPage.enterToHomePage();

    }
    @Given("user is on Home page")
    public void user_is_on_home_page() {
        System.out.println("HomePage Title is "+homePage.getPageTitle());
    }

    @Then("user gets HomePage section")
    public void userGetsHomePageSection(DataTable sectionTable) {
        List<String> expectedSectionList=sectionTable.asList();
        System.out.println("Expected account section list "+expectedSectionList);

        List<String> actualSectionList=homePage.getHomePageSectionList();
        System.out.println("Actual account section list "+actualSectionList);

        Assert.assertEquals(actualSectionList,expectedSectionList,"Product List Mismatch");
    }

    @And("accounts section count should be {int}")
    public void accountsSectionCountShouldBe(int expectedcount) {
        Assert.assertEquals(homePage.getHomePageAccountSectionCount(),expectedcount,"Count Mismatch");
    }
}
