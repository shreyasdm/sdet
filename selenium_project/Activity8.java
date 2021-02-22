package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");


	}
	@Test
	public void testcase8() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		
		String title = driver.getTitle();
		System.out.println("page Title: "+ title);
		
		Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress");
		


	}


	@AfterMethod
	public void aftermethod()
	{
		driver.close();
	}
}


