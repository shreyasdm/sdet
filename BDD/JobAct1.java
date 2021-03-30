package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class JobAct1 {
	
	WebDriver  driver;	
	 WebDriverWait wait;
	
    String userName ="Kiran1145";
    String email = "kiran1145@gmail.com";
   @Given("^User is on Job log in page$")
	
   public void openPage() {
	
       //Create Instances
	
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();	
		   System.out.println("Maximised Window");
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	
   @When("^User enteres user name and Password$")
	
   public void enterCredentials() {
	   try {
		System.out.println("enter Credentials");
		   driver.get("https://alchemy.hguy.co/jobs/wp-login.php?redirect_to=https%3A%2F%2Falchemy.hguy.co%2Fjobs%2Fwp-admin%2F&reauth=1");
		   driver.findElement(By.id("user_login")).sendKeys("root");
		   driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		   driver.findElement(By.id("wp-submit")).click();
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Dashboard']")));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Locates left hand menu and click the menu item that says Users$")
	
   public void ClickUsers() throws Exception {
	   	 try {
			driver.findElement(By.xpath("//div[text()='Users']")).click();
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='page-title-action']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   
   
   @And("^Locate the Add New button and click it.$")
	
   public void ClickAddUserButton() throws Exception {
	   try {
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
		   Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
   @And("^Fill in the necessary details.$")
	
   public void FillDetails() throws Exception {
	   	 
	   try {
		driver.findElement(By.id("user_login")).sendKeys(userName);
		   driver.findElement(By.id("email")).sendKeys(email);
		   driver.findElement(By.id("first_name")).sendKeys("Rajat");
		   driver.findElement(By.id("last_name")).sendKeys("Chavan");
		   driver.findElement(By.xpath("//button[@class='button wp-generate-pw hide-if-no-js']")).click();
		   driver.findElement(By.xpath("//input[@id='pass1']")).clear();
		   driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("%Nidhi%111123");
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Strong']")));
	//	   Thread.sleep(6000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   }
   
   @And("^Click the Add New User button$")
	
   public void ClickAddUsers() throws Exception {
	   try {
		   Thread.sleep(1000);
		driver.findElement(By.id("createusersub")).click();
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("bulk-action-selector-top")));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   	 
	   }
   

@Then("^Verify that the user was created.$")
	
 public void VerifyNewUserCreated() throws Exception {
    
	   driver.findElement(By.id("user-search-input")).sendKeys(userName);
	   driver.findElement(By.xpath("//input[@value='Search Users']")).click();
	   Thread.sleep(2000);
	   String getStr= driver.findElement(By.xpath("//tbody[@id='the-list']/tr/td/Strong/a")).getText();
	   System.out.println(getStr);
	   Assert.assertEquals(userName, getStr);
		
   }
   
   @And("^Close the browser.$")
	
   public void CloseBrowser() throws Exception {
	   	  try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   
}
