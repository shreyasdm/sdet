

package sdetAPIGrpID.sdetAPIArtiID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProjectGoogleKeepRemainderAct3 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "<device name>");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void GoogleKeepWithRemainder() throws Exception {

		String str1 = "Google Keep Description";

		MobileElement createNote = driver.findElementById("new_note_button");
		createNote.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("editable_title")));
		driver.findElementById("editable_title").click();
		driver.findElementById("editable_title").sendKeys("Note12");
		 driver.findElementById("edit_note_text").click();
 	    driver.findElementById("edit_note_text").sendKeys("Description3"); 	    
 	   driver.findElementById("menu_reminder").click();
 	   Thread.sleep(2000);
 	  driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Pick a date & time')]").click();
 	 driver.findElementById("time_spinner").click();
 	Thread.sleep(2000);
 	driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Evening')]").click();
 	 driver.findElementById("save").click();
 	Thread.sleep(2000);
 	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("new_note_button")));
		 List<MobileElement> textItems=driver.findElementsById("index_note_title");
		 System.out.println(textItems.size());
		 System.out.println("Notes added "+textItems.get(0).getText());
		 String NotesAdded = textItems.get(0).getText();
		 Assert.assertEquals(NotesAdded, "Note12");
		 textItems.get(0).click();
		 String remainder = driver.findElementById("reminder_chip").getText();
		Assert.assertEquals(remainder, "Today, 6:00 PM");
		 
		 
		 /*
		 for(MobileElement textItem : textItems)
		 {
         
			System.out.println(textItem.getText()); 
			if(textItem.getText().equalsIgnoreCase("Note11"))
			{
				System.out.println("Notes Added");
				textItem.click();
				System.out.println(driver.findElementById("reminder_chip").getText());
			String remainder = driver.findElementById("reminder_chip").getText();
				Assert.assertEquals(remainder, "Today, 6:00 PM");
				break;
				
			}
			
		 }
		 */
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
