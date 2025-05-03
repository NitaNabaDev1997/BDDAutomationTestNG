package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By emailId= By.xpath("//input[@type='email']");
    private By pass= By.xpath("//input[@type='password']");
    private By login= By.xpath("//button[@type='submit']");
    private By forgotPwdLink;

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public boolean forgotPassLinkCheck()
    {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUsername(String username)
    {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPass(String pwd)
    {
        driver.findElement(pass).sendKeys(pwd);
    }

    public void clickOnLogin()
    {
        driver.findElement(login).click();
    }

    public HomePage enterToHomePage()
    {
        return new HomePage(driver);
    }



}
