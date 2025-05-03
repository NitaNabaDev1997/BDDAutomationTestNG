package Utility;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Passed "+ result.getName());
    }

    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failed "+result.getName());

        Throwable error= result.getThrowable();
        if(error!=null)
        {
            System.out.println("Exception "+ error.getMessage());
            error.printStackTrace();
        }

    }
}
