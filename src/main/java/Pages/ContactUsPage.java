package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    WebDriverWait wait;
    public ContactUsPage(WebDriver driver)
    {
        this.driver=driver;
        wait= new WebDriverWait(driver,Duration.ofSeconds(3));
    }


   private By name= By.xpath("//input[@name='name']");
   private By email= By.xpath("//input[@name='email']");
   private By sub=By.xpath("//input[@name='subject']");
   private By textcontext=By.xpath("//textarea[@id='message']");
   private By submitbtn= By.xpath("//input[@name='submit']");
   private By successmsg= By.cssSelector("div.status");

   public String getPageTitle()
   {
       return driver.getTitle();
   }

   public void fillForm(String username,String useremail,String subject,String context)
   {
       driver.findElement(name).sendKeys(username);
       driver.findElement(email).sendKeys(useremail);
       driver.findElement(sub).sendKeys(subject);
       driver.findElement(textcontext).sendKeys(context);


   }

   public void clickSubmit()
   {
      /* JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("document.querySelector('CSS_SELECTOR_HERE').style.display='none';");
       */
       driver.findElement(submitbtn).click();
       wait.until(ExpectedConditions.alertIsPresent());
       Alert alert=driver.switchTo().alert();
       alert.accept();
   }

   public String getSucessConfirmMsg()
   {
       return driver.findElement(successmsg).getText();
   }




}
