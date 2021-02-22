package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	
	 @BeforeMethod
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/");
	    }

	    @Test
	    public void findJobMenu() throws InterruptedException {
	       
	    	// navigate to jobs page
	       	driver.findElement(By.linkText("Jobs")).click();
	    	
	    	//Search for a particular job and wait for listings to show. 
	       	WebElement searchkey = driver.findElement(By.xpath("//input[@id='search_keywords']"));
	       	searchkey.sendKeys("Test");
	       	driver.findElement(By.xpath("//input[@type='submit']")).click();
	    	
	       	//Click and open any one of the jobs listed
	    	
	       	WebDriverWait wait = new WebDriverWait(driver,30);
	       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/job/testing-pvt-ltd-india-2-automation-test-specialist-5/']//div[@class='position']//h3[contains(text(),'Automation Test Specialist')]"))).click();	
       		       	
	       	//submit for job
	       	
	       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='button']"))).click();
       	   	
	       	//Get Email id
	       	String eMail= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
	       	System.out.println("Email is " + "'"+ eMail +"'" );
	       	
	    }
	    
		
	    @AfterMethod 
	    public void tearDown() 
	    { 
	    	//Close the browser 
	    	driver.quit(); 
	    }
	    
}
