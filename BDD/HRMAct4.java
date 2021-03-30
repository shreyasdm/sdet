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

public class HRMAct4 {
	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	//
   
   @Given("^users Logins OrangeHRM application and with Credentials$")	
   public void HRMLogin() {
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
	
	
   @When("^Navigate to Recruitment and Click vacancies$")
	
   public void NavigateRecruitPage() {
	   try {
		
		   driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//a[@id='menu_recruitment_viewJobVacancy']")).click();
	   		Thread.sleep(1000);
		   
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Click the Add button to get Add Job Vacancy page$")
	
   public void ClickVacancyMenu() throws Exception {
	   	 try {
	   		
	   		driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   
   
   @And("^Enter all details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	
   public void ClickAddButton(String JobTitleExampleTable, String Vacancyname, String HiringManager) throws Exception {
	   try {
		  System.out.println("In Add :"+Vacancyname);
		   Select JobTitle = new Select(driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
			  JobTitle.selectByVisibleText(JobTitleExampleTable);
			   Thread.sleep(1000);
			   driver.findElement(By.id("addJobVacancy_name")).sendKeys(Vacancyname);
			   
			   driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(HiringManager);
			   driver.findElement(By.id("btnSave")).click();
			   
			  
			   
		   Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
   @And("^Click Save Btn$")
	
   public void FillDetailsandSave() throws Exception {
	   	 
	   try { 
		  
		   driver.findElement(By.id("btnSave")).click();
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   }
   
   @Then("^Verify that all the \"(.*)\" have been successfully created$")
	
 public void VerifyVacancyCreated(String Vacancyname) throws Exception {
	   System.out.println("In Verify :"+Vacancyname);
	   driver.findElement(By.xpath("//a[@id='menu_recruitment_viewJobVacancy']")).click();
 		Thread.sleep(1000);
 		Select VacancyDropDown = new Select(driver.findElement(By.xpath("//select[@id='vacancySearch_jobVacancy']")));
 		VacancyDropDown.selectByVisibleText(Vacancyname);
 		driver.findElement(By.id("btnSrch")).click();
 		Thread.sleep(3000);
	   String getStr= driver.findElement(By.xpath("//a[text()='"+Vacancyname+"']")).getText();
	   System.out.println(getStr);
	   Assert.assertEquals(Vacancyname, getStr);
	   
	 
   }
   
   @And("^Closes the browsersss$")
	
   public void CloseBrowser() throws Exception {
	   	  try {
		//	driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   




}
