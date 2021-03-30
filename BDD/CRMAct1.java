package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMAct1 {
	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
    String VacancyName ="New Job Threess";
   
   @Given("^users Logins Alchemy CRM application$")	
   public void CRMOpen() {
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();	
		   System.out.println("Maximised Window");
		   
		   driver.get("https://alchemy.hguy.co/crm/index.php?module=Users&action=Login");
		  
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	
   @When("^User enters valid Credentials$")
	
   public void CRMLogin() {
	   try {
		
		   driver.findElement(By.id("user_name")).sendKeys("admin");
		   driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		   driver.findElement(By.id("bigbutton")).click();
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='tab0']")));
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Count the number of Dashlets on the homepage$")
	
   public void CoundDashlet() throws Exception {
	   	 try {
	   		
	   		 
	   		 Thread.sleep(5000);
	   		 List<WebElement> Dashlet = driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[2]"));
	   		 int DashletSize = Dashlet.size();
	   		 System.out.println("No of DashLet in Homepage :"+DashletSize);
	   		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   @Then("^Print the number and title of each Dashlet into the console$")
	
 public void PrintDashlet
 () throws Exception {
	   
	   
	   List<WebElement> Dashlet = driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[2]"));
 		 int DashletSize = Dashlet.size();
 		 System.out.println("No of DashLet in Homepage :"+DashletSize);
 		 
 		 for(int i=0;i<DashletSize;i++)
 		 {
 			 
 			 System.out.println("DashLet No is "+(i+1)+"  "+"and Title is "+Dashlet.get(i).getText());
 			 
 		 }
	  
   }
   
   @And("^Exit the browser$")
	
   public void ExitBrowser() throws Exception {
	   	  try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   




}
