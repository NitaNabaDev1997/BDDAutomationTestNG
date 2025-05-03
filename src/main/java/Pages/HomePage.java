package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By HomePageSections = By.xpath("//div[contains(@class,'shop-menu pull-right')]//ul[contains(@class,'nav')]/li");
    private By contact = By.xpath("//a[contains(text(),'Contact us')]");

    public int getHomePageAccountSectionCount()
    {
        return driver.findElements(HomePageSections).size()-1;
    }

    public String getPageTitle()
    {
       return driver.getTitle();
    }
    public List<String> getHomePageSectionList()
    {
        List<String> sectionList= new ArrayList<>();
        List<WebElement> headerlist= driver.findElements(HomePageSections);

        for(WebElement e: headerlist)
        {
            sectionList.add(e.getText());
        }
        return sectionList;
    }

 public void clickContactUs()
 {
     driver.findElement(contact).click();
 }

 public ContactUsPage enterToContactUs()
 {
     return new ContactUsPage(driver);
 }

}
