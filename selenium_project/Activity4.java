package Project;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	
	public class Activity4 { 
		
		WebDriver driver;
		
		 @BeforeMethod
		    public void beforeMethod() {
		        //Create a new instance of the Firefox driver
		        driver = new FirefoxDriver();
		        
		        //Open browser
		        driver.get("https://alchemy.hguy.co/jobs/");
		    }

		    @Test
		    public void getSecondHeading() {
		        // get the second heading of the page
		    	
		        String secondheading = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
		        		   
		        //Print the heading of the page
		        System.out.println("Page title is: " + secondheading);
		            
		        //Assertion for page heading
	        Assert.assertEquals("Quia quis non", secondheading);
		    }
		    
		    @AfterMethod
		    public void tearDown() {
		        //Close the browser
		        driver.quit();
		    }
		}

