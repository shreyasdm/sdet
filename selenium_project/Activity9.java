package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");


	}
	@Test
	public void testcase9() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		//Actions class    - Locate the left hand menu and click the menu item that says “Job Listings”
		Actions action =new Actions(driver);    
		WebElement button = driver.findElement(By.xpath("//div[text()='Job Listings'][1]"));
		
		//Mouse hover the element using actions class      
		action.moveToElement(button).build().perform();
		
		// Locate the “Add New” button and click it. 
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New")));
		WebElement button2 = driver.findElement(By.linkText("Add New"));
		action.moveToElement(button2);
		action.click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='img'])[13]"))).click();
		
		// Fill in the necessary details
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='post-title-0']"))).sendKeys("Test Lead");
		driver.findElement(By.id("_application")).clear();
		driver.findElement(By.id("_job_location")).sendKeys("India");
		driver.findElement(By.id("_application")).sendKeys("Test9@gmail.com");
		driver.findElement(By.id("_company_name")).sendKeys("Testing Pvt Ltd");	
		driver.findElement(By.id("_company_website")).sendKeys("https://test.com");
		driver.findElement(By.id("_company_twitter")).sendKeys("@testing");
		
		// Click the “Publish” button.
		driver.findElement(By.xpath("//button[contains(text(), 'Publish…')]")).click();
	
		//Verify that the job listing was created
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='editor-post-publish-panel__header-publish-button']/button"))).click();
		Thread.sleep(5000);
		String publishedText = driver.findElement(By.className("editor-post-publish-panel__header-published")).getText();
		Assert.assertEquals(publishedText, "Published");
	}

		//Close the browser.
		@AfterMethod
		public void aftermethod()
		{
			driver.close();
		}

	


}
