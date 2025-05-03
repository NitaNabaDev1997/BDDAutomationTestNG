package StepDefinitions;

import DriverFactory.Driverfactory;
import Pages.ContactUsPage;
import Pages.HomePage;
import Utils.ExcelReader;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class contactUsSteps {
private HomePage homePage= new HomePage(Driverfactory.getdriver());
ContactUsPage contactUsPage;
    @Given("user navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
         homePage.clickContactUs();
         contactUsPage=homePage.enterToContactUs();
        System.out.println(contactUsPage.getPageTitle());
    }
    @When("user fills the form given sheetName {string} and rownum {int}")
    public void user_fills_the_form_given_sheet_name_and_rownum(String sheetName, Integer index) throws IOException {

        ExcelReader excelReader= new ExcelReader();
        List<Map<String,String>> testData=excelReader.getData(System.getProperty("user.dir")+"/testData/Book1.xlsx",sheetName);


        String name= testData.get(index).get("Name");
        String email=testData.get(index).get("Email");
        String sub= testData.get(index).get("Subject");
        String msg= testData.get(index).get("Message");

        contactUsPage.fillForm(name,email,sub,msg);



    }
    @When("user clicks on Submit button")
    public void user_clicks_on_submit_button() {

        contactUsPage.clickSubmit();

    }
    @Then("It shows a success message {string}")
    public void it_shows_a_success_message(String expectedmsg) {

        String actualmsg=contactUsPage.getSucessConfirmMsg();
        Assert.assertEquals(actualmsg,expectedmsg,"confirm msg does not match");

    }

}
