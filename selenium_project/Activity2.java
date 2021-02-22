package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void getHeading() {
        // Get the heading of the page
    	String heading =  driver.findElement(By.xpath("//h1[@class='entry-title'][contains(text(), 'Welcome')]")).getText();
    
        //Print the Heading of the page
        System.out.println("Page heading is: " + heading);
            
            //Assertion for page title
        Assert.assertEquals("Welcome to Alchemy Jobs", heading);
                    
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
