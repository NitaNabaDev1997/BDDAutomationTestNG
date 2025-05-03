import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;


@Listeners(Utility.TestListener.class)
@CucumberOptions(features = "src/test/resources/features/LoginPage.feature",
        glue = "StepDefinitions",
       // tags = "@Regression",
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"
                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                ,"timeline:test-output-thread/"
                ,"rerun:target/failedrerun.txt"},
        monochrome = true
        ,publish = true)
public class ParallelTestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
