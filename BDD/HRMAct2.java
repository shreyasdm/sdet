package stepDefinitions;

import java.util.ArrayList;
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

public class HRMAct2 {
	
	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
    String fisrtName ="FirstName3";
    String lastName ="LastName3";
    String email ="First1@hmail.com";
   
   @Given("^users Logins OrangeHRM application$")	
   public void OrangeHRMLogin() {
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
	
	
   @When("^Navigate to the Recruitment page and click on the Add button$")
	
   public void NavigateRecruitPage() {
	   try {
		
		   driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.id("btnAdd")).click();
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Fill in the details of the candidate$")
	
   public void FillCandidateDetails() throws Exception {
	   	 try {
	   		driver.findElement(By.id("addCandidate_firstName")).sendKeys(fisrtName);
	   		Thread.sleep(1000);
	   		driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastName);
	   		Thread.sleep(1000);
	   		driver.findElement(By.id("addCandidate_email")).sendKeys(email);
	   		
	   		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   
   
   @And("^Upload a resume docx or pdf to the form and Save$")
	
   public void uploadResumenSave() throws Exception {
	   try {
		   driver.findElement(By.id("btnSave")).click();
		   Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
   
   
   @Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	
 public void VerifyCandidateCreated() throws Exception {
	   
	   driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(fisrtName+" "+lastName);
  		driver.findElement(By.id("btnSrch")).click();
  		Thread.sleep(3000);
  		ArrayList<String> candidateSearch = new ArrayList<String>();
 List<WebElement> CandidateList=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
 int i;
 String CandidateToSearch = fisrtName+" "+lastName;
 for(i=0;i<CandidateList.size();i++)
 {
String searchCandidate =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+(i+1)+"]/td[3]")).getText();
 
 if(searchCandidate.equalsIgnoreCase(CandidateToSearch))
 {
	 System.out.println("Candidate Found");
	 System.out.println("Location is "+i);
	 break;
	 
 }
 
	 
 }
  
 Assert.assertEquals(CandidateToSearch, driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+(i+1)+"]/td[3]")).getText());
 //	   Assert.assertEquals(VacancyName, getStr);

   }
   
   @And("^Closes the browsers$")
	
   public void CloseBrowser() throws Exception {
	   	  try {
		//	driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   



	
	

}
