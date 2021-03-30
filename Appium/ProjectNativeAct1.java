package sdetAPIGrpID.sdetAPIArtiID;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class ProjectNativeAct1 {
	
	AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");	
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
	
    @Test
    public void Googletask() throws Exception {
    	
    	String str1 = "Activity with Google Tasks";
    	String str2 = "Activity with Google Keep";
    	String str3 = "second Activity Google Keep";
    	
			Thread.sleep(3000);
		/*
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys(str1);     
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
       System.out.println("1st Complated");
       
       
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys(str2);
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
        System.out.println("Second Completed");
        
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys(str3);
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
     */

        
			MobileElement createNewtask = driver.findElementById("tasks_fab");		
			createNewtask.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
			MobileElement addTask = driver.findElementById("add_task_title");
			addTask.sendKeys(str1);
			MobileElement save = driver.findElementById("add_task_done");
			save.click();
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
			 
			createNewtask.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
			addTask.sendKeys(str2);
			save.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
			
			createNewtask.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("add_task_title")));
			addTask.sendKeys(str3);
			save.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("tasks_fab")));
			
        List<MobileElement> textItems=driver.findElementsById("task_name");     
        System.out.println(textItems.size());
        
    	
        for(MobileElement textItem : textItems) {
	
          
            if(textItem.getText().equalsIgnoreCase(str1))
            {
            //	Assert.assertTrue(true);
            	System.out.println(textItem.getText());
            	System.out.println(str1);
            	Assert.assertEquals(textItem.getText(), str1);
            }
            else if(textItem.getText().equalsIgnoreCase(str2))
            {
            	System.out.println(textItem.getText());
            	System.out.println(str2);
            	Assert.assertEquals(textItem.getText(), str2);
            }
            else if(textItem.getText().equalsIgnoreCase(str3))
            {
            	System.out.println(textItem.getText());
            	System.out.println(str3);
            	Assert.assertEquals(textItem.getText(), str3);
            }
            
            else
            {
            	Assert.assertFalse(false);
            	
            }
            
        }
        
    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
	

}
