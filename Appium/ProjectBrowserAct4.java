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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProjectBrowserAct4 {
	
	  AppiumDriver<MobileElement> driver = null;
		
	    WebDriverWait wait;
		
	 @BeforeClass
		
	    public void beforeClass() throws MalformedURLException {
		
	        // Set the Desired Capabilities
		
	        DesiredCapabilities caps = new DesiredCapabilities();
		
	        caps.setCapability("deviceName", "<device name>");
		
	        caps.setCapability("platformName", "Android");
		
	        caps.setCapability("appPackage", "com.android.chrome");
		
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
	        caps.setCapability("noReset", true);
		
	 
		
	        // Instantiate Appium Driver
		
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
		
	        wait = new WebDriverWait(driver, 5);
		
	 
		
	        driver.get("https://www.training-support.net/selenium");
		
	    }
	 
		
	    @Test
		
	    public void BrwoserAct4() throws InterruptedException {
	    	Thread.sleep(5000);
	    	
	    //	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")"));
	    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(4)"));
	    	driver.findElementByXPath("//android.view.View[contains(@text, 'To-Do List')]").click();
	    	Thread.sleep(5000);
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").click();
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").sendKeys("Add tasks to list");
	    	driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").click();
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").sendKeys("Get number of tasks");
	    	driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").click();
	    	driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'taskInput')]").sendKeys("Clear the list");
	    	driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
	    	Thread.sleep(2000);
	    	
	    	driver.findElementByXPath("//android.view.View[contains(@text, 'Add tasks to list')]").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//android.view.View[contains(@text, 'Get number of tasks')]").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//android.view.View[contains(@text, 'Clear the list')]").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//android.view.View[contains(@text, 'Clear List')]").click();
	    	Thread.sleep(2000);
	    	
	    int size1 = driver.findElementsByXPath(("//android.view.View[contains(@text, 'Add tasks to list')]")).size();
	    int size2 = driver.findElementsByXPath(("//android.view.View[contains(@text, 'Get number of tasks')]")).size();
	    int size3 = driver.findElementsByXPath(("//android.view.View[contains(@text, 'Clear the list')]")).size();
	    System.out.println(size1);
	    System.out.println(size2);
	    System.out.println(size3);
	    Assert.assertEquals(size1, 0);
	    Assert.assertEquals(size2, 0);
	    Assert.assertEquals(size3, 0);
	    	/*
	    	 List<MobileElement>	  element=	 driver.findElementsByClassName("android.view.View");
		    	System.out.println("Size"+element.size());

		    	 for(int i=0;i<element.size();i++)
		    	 {
		    		 String text = element.get(i).getText();
		    		 System.out.println(text);
		    		 if(text.contains("To-Do List"))
		    		 {		    			 
		    			 System.out.println("Found");
		    			 System.out.println("Index "+i);	    			
		    			 element.get(i).click();
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
