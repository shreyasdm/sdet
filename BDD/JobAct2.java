package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

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

public class JobAct2 {
	

	
	WebDriver  driver;	
	 WebDriverWait wait;
	
	ArrayList<String> ArrayJobList = new ArrayList<String>();
  
    
    @Given("^User is on Alchemy Job page and navigate to Jobs page$")	
   public void NavigateJobpage() {
   	try {
		//System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();	
		   wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();	
		   System.out.println("Maximised Window");
		   driver.get("https://alchemy.hguy.co/jobs/");
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Jobs']")));
		   driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	
   @When("^User inputs SDET Tester to search for jobs$")
	
   public void InputTextToSearch() {
	   try {
		   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='search_keywords']")));
		   driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("SDET Tester");
		   driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }


   @And("^Filter the list to Full Time jobs$")
	
   public void FilterFullTimeJob() throws Exception {
	   	 try {
			
	   		 List<WebElement> jobTypes = driver.findElements(By.xpath("//ul[@class='job_types']/li")); 	
	   		jobTypes.get(0).click();
	   		jobTypes.get(2).click();
	   		jobTypes.get(3).click();
	   		jobTypes.get(4).click();
	   		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	   }
   
   

@And("^Find a job listing using XPath and it to see job details$")
	
   public void ListJob() throws Exception {
	   try {
		Thread.sleep(3000);
		   List<WebElement> JobList = driver.findElements(By.xpath("//ul[@class='job_listings']/li"));
		int JobListSize = JobList.size();
		System.out.println("Job List Size ->"+JobListSize);
		
		
		for(int j=0;j<JobListSize;j++)
		{
			String str= "//ul[@class='job_listings']/li["+j+"]/a/div/h3";
	//		System.out.println(str);
			ArrayJobList.add(driver.findElement(By.xpath("//ul[@class='job_listings']/li["+(j+1)+"]/a/div/h3")).getText()); 
					
			
		}
	//	System.out.println(ArrayJobList);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   }
   
 
   
   @And("^Find the title of the job listing using XPath and print it to the console$")
	
   public void PrintJobToConsole() throws Exception {
	   try {
		   
		   for(int i=0;i<ArrayJobList.size();i++)
		   {
			  System.out.println("Job List :"+ArrayJobList.get(i)); 
			   
		   }
		   
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   	 
	   }
   

@Then("^Click on the Apply for job button$")
	
 public void ClickApplyJob() throws Exception {
    
	for(int i=0;i<ArrayJobList.size();i++)
	   {
		  System.out.println("Job List :"+ArrayJobList.get(i));
		  if(ArrayJobList.get(i).equals("SDET Tester"))
		  {
			  driver.findElement(By.xpath("//ul[@class='job_listings']/li["+(i+1)+"]")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
			  Thread.sleep(1000);
			  
		  }
		   
	   }
		
   }
   
   @And("^Quit the browser$")
	
   public void QuitBrowser() throws Exception {
	   	  try {
	   		driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
   


}
