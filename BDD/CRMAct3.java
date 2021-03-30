package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMAct3 {
	
	

	

	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
	String Subject = "CRM New Meeting Important";
   
   @Given("^User logs in Achemy CRM page with Valid Cred$")	
   public void CRMLogin() {
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 30);
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
	
	
   @When("^User Navigates to schedule Meeting thorugh activities and Meeting$")
	
   public void NavigateMeetingpage() {
	   try {
		
		   driver.findElement(By.id("grouptab_3")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//a[text()='Meetings']")).click();
	   		Thread.sleep(3000);
	   		driver.findElement(By.xpath("//a[@data-action-name='Schedule_Meeting']")).click();
	   		System.out.println("Clicked Schedule meeting");
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   @And("Enter the details of the meeting$")
	
   public void EnterMeetingDetails() throws Exception {
	   try {
		  Thread.sleep(5000);
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class='module-title-text']")));
		  driver.findElement(By.id("name")).sendKeys(Subject);;
			   Thread.sleep(1000);
			  
			  
			   
		   Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
   @And("Search for \"(.*)\" and \"(.*)\" and \"(.*)\" and add them to the meeting$")
	
   public void searchInvitees(String rerecipient1, String recipient2, String recipient3) throws Exception {
	   	 
	   try { 
		  
		   driver.findElement(By.id("search_first_name")).sendKeys(rerecipient1);
		   Thread.sleep(2000);
		   driver.findElement(By.id("invitees_search")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//tr[@class='oddListRowS1']/td[5]/input")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.id("search_first_name")).clear();
		   driver.findElement(By.id("search_first_name")).sendKeys(recipient2);
		   Thread.sleep(3000);
		   WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_search")));
		   Element.click();
		  // driver.findElement(By.id("invitees_search")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//tr[@class='oddListRowS1']/td[5]/input")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.id("search_first_name")).clear();
		   driver.findElement(By.id("search_first_name")).sendKeys(recipient3);
		   Thread.sleep(3000);
		   WebElement Element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("invitees_search")));
		   Element1.click();
		  // driver.findElement(By.id("invitees_search")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//tr[@class='oddListRowS1']/td[5]/input")).click();
		   Thread.sleep(2000);
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   }
   
   @And("^Click save meeting$")
	
   public void ClickSave1() throws Exception {
	   	 
	   try { 
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//input[@id='SAVE_HEADER']")).click();
		   Thread.sleep(2000);
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   }
   
   @Then("Navigate to View Meeting and check  \"(.*)\" and \"(.*)\" is added$")
	
 public void VerifyVacancyCreated(String FirstName, String LastName) throws Exception {
	  
     driver.findElement(By.id("moduleTab_Meetings")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//a[text()='View Meetings']")).click();
     Thread.sleep(2000);
     String meetingSubJectFromApp = driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr[1]/td[4]/b/a")).toString();
     System.out.println("subject :"+meetingSubJectFromApp);
     System.out.println(Subject);
	   Assert.assertEquals(Subject, meetingSubJectFromApp);
	   
	 
   }
   
   @And("^Exit the Browser created for meeting$")
	
   public void CloseBrowser() throws Exception {
	   	  try {
		//	driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   








}
