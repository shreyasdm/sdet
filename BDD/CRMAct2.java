package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMAct2 {
	

	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
   
   @Given("^User logs in Achemy CRM page$")	
   public void CRMLogin() {
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();	
		   System.out.println("Maximised Window");
		   
		   driver.get("https://alchemy.hguy.co/crm/index.php?module=Users&action=Login");
		   driver.findElement(By.id("user_name")).sendKeys("admin");
		   driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		   driver.findElement(By.id("bigbutton")).click();
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='tab0']")));
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	
   @When("^User Navigates to Create Lead page$")
	
   public void NavigateCreateLeadpage() {
	   try {
		
		   driver.findElement(By.id("grouptab_0")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//a[text()='Leads']")).click();
	   		Thread.sleep(3000);
	   		driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
	   		System.out.println("Clicked Lead Link");
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   @And("^Enter \"(.*)\" and \"(.*)\"$")
	
   public void CreateLead(String FirstName, String LastName) throws Exception {
	   try {
		  Thread.sleep(5000);
		   driver.findElement(By.id("first_name")).sendKeys(FirstName);;
			   Thread.sleep(1000);
			   driver.findElement(By.id("last_name")).sendKeys(LastName);
			   Thread.sleep(1000);
			   
			  
			   
		   Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
   @And("^Click Save to finish$")
	
   public void ClickSave() throws Exception {
	   	 
	   try { 
		  
		   driver.findElement(By.id("SAVE")).click();
		   Thread.sleep(2000);
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   }
   
   @Then("Navigate to the View Leads page and confirm Lead \"(.*)\" and \"(.*)\" are created$")
	
 public void VerifyVacancyCreated(String FirstName, String LastName) throws Exception {
	  
	   String getStr= driver.findElement(By.xpath("//h2[@class='module-title-text']")).getText();
	   System.out.println("Str from Application :"+getStr);
	   String strtoSearch = FirstName+" "+LastName;
	   strtoSearch=strtoSearch.toUpperCase();
	   System.out.println("String to Search :"+strtoSearch);
	   Assert.assertEquals(strtoSearch, getStr);
	   
	 
   }
   
   @And("^Exist the currentBrowser$")
	
   public void CloseBrowser() throws Exception {
	   	  try {
		//	driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   






}
