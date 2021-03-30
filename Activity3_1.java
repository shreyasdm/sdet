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
public class Activity3_1 {
	
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");   	
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
	
    public void smsTest() {
	
        // Locate the button to write a new message and click it
	
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
	
 
	
        // Enter the number to send message to
	
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
	
        // Enter your own phone number
	
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("8197722770");
	
 
	
        // Focus on the message text box
	
        String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/top_contacts_header\")";
	
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
	
 
	
        // Type in a message
	
        messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
	
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
	
        composeMessageInput.sendKeys("Hello from Appium from Madhu");
	
 
	
        // Send the message
	
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
	
 
	
        // Wait for message to show
	
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));
	
 
	
        // Assertion
	
        String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
	
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
	
        Assert.assertEquals(sentMessageText, "Hello from Appium");
	
    }
	
  
}