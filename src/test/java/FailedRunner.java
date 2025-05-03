import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failedrerun.txt",
        glue = "StepDefinitions",
        //tags = "@chapter1Validation",
        plugin = {"pretty"
                ,"rerun:target/failedrerun.txt"},
        monochrome = true
        ,publish = true)
public class FailedRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
