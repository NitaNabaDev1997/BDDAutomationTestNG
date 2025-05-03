package StepDefinitions;

import DriverFactory.Driverfactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;


    public class ApplicationHooks {

        private Driverfactory driverfactory;
        private WebDriver driver;
        private ConfigReader configReader;
        Properties properties;

        @Before(order = 0)
        public void getProperty() throws IOException {
            configReader= new ConfigReader();
            properties=configReader.initializeProperties();
        }

        @Before(order = 1)
        public void launchBrowser()
        {
            String brow_name=properties.getProperty("browser");
            driverfactory= new Driverfactory();
            driver= driverfactory.initializeDriver(brow_name);
            String url=properties.getProperty("url");
            driver.get(url);
        }

        @After(order = 0)
        public void quiBrowser()
        {
            driver.quit();
        }

        @After(order =1)
        public  void tearDown(Scenario scenario)
        {
            if(scenario.isFailed())
            {
                String screenshotName=scenario.getName().replaceAll(" ","_");
                TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
                byte[] sourcepath=takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcepath,"image/png",screenshotName);
            }
        }
    }
