package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMAct3 {
	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
	String JobId ="";
    
    @Given("^users Logins OrangeHRM application and with valid Credentials$")	
   public void NavigateOrangeHRMWithValidCredentials() {
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();	
		   System.out.println("Maximised Window");
		   driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		   driver.findElement(By.id("txtUsername")).sendKeys("orange");
		   driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		   driver.findElement(By.id("btnLogin")).click();
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Dashboard']")));
		   
		  
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	
   @When("^Navigate to the PIM Option and click on the it$")
	
   public void NavaigatePIM() {
	   try {
		   driver.findElement(By.id("menu_pim_viewPimModule")).click();
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[@for='empsearch_employee_name']")));
		   Thread.sleep(1000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   @And("^Click the Add button to add a new Employee$")
	
   public void ClickADDButton() {
	   try {
		   driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		   Thread.sleep(3000);
		//   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[@for='create_account_email']")));
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   @And("^Make sure the Create Login Details checkbox is checked$")
	
   public void CheckBoxCreateLoginChecked() {
	   try {
		   Thread.sleep(3000);
		   driver.findElement(By.id("chkLogin")).click();
//		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[@for='create_account_email']")));
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Enter \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	
   public void EEnterJobDetails(String firstName, String lastName, String UserName) throws Exception {
	   	 try {
	   		
	   		 driver.findElement(By.id("firstName")).sendKeys(firstName);
	   		driver.findElement(By.id("lastName")).sendKeys(lastName);
	   		driver.findElement(By.id("user_name")).sendKeys(UserName);
	   		JobId=driver.findElement(By.id("employeeId")).getAttribute("value");
	   		System.out.println("JobId is:"+JobId);
	   		driver.findElement(By.id("btnSave")).click();
	   		Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   
   

@Then("^Verify that the employees have been created$")
	
 public void ValidateEmployeeAdded() throws Exception {
	
	 driver.findElement(By.id("menu_pim_viewPimModule")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@name='empsearch[id]']")).sendKeys(JobId);
	 Thread.sleep(2000);
	 driver.findElement(By.id("searchBtn")).click();
	
	 Thread.sleep(2000);
String	 SearchedJobId=driver.findElement(By.xpath("//table[@id='resultTable']//following::a[8]")).getText();
	 Assert.assertEquals(SearchedJobId, JobId);
   }
   
@And("^Closes the browserss$")

public void EGenerateHTMLReport() throws Exception {
	   try {
		   
	//	  driver.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   	 
	   }

  
		
	   



}
