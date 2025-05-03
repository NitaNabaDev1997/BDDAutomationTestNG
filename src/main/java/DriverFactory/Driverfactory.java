package DriverFactory;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

public class Driverfactory {

   // public WebDriver driver;

    public static ThreadLocal<WebDriver> threadLocalDriver= new ThreadLocal<>();

// to initialize the driver with threadlocal for different browsers
    public WebDriver initializeDriver(String browsername) {
        System.out.println("browser name is  " + browsername);

        if (browsername.equalsIgnoreCase("chrome")) {

            threadLocalDriver.set(new ChromeDriver());
        }

        else if(browsername.equalsIgnoreCase("edge"))
        {
            threadLocalDriver.set(new EdgeDriver());
        }

        else if(browsername.equalsIgnoreCase("firefox"))
        {
            threadLocalDriver.set(new FirefoxDriver());
        }
        else
        {
            System.out.println("Pass the correct browser name "+browsername);
        }

        getdriver().manage().deleteAllCookies();
        getdriver().manage().window().maximize();
        return getdriver();

    }

//to get the driver with threadlocal
    public static synchronized WebDriver getdriver()
    {
        return threadLocalDriver.get();
    }
}
