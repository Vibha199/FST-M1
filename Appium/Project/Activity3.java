package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
  @Test(dataProvider = "Note")
  public void taskKeep(String title,String note ) throws InterruptedException {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"New text note\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"New text note\")")).click();
	  
	  String newTitle = "resourceId(\"com.google.android.keep:id/editable_title\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(newTitle)));
      driver.findElement(MobileBy.AndroidUIAutomator(newTitle)).sendKeys(title);
      
      String newDesc = "resourceId(\"com.google.android.keep:id/edit_note_text\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(newDesc)));
      driver.findElement(MobileBy.AndroidUIAutomator(newDesc)).sendKeys(note);
      
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/menu_switch_to_list_view\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/menu_switch_to_list_view\")")).click();
	  
	  Thread.sleep(5000);
	  List <MobileElement> Reminders=driver.findElementsById("com.google.android.keep:id/menu_icon");
	  String TextReminder=Reminders.get(0).getText();
	  System.out.println(TextReminder);
	  Reminders.get(0).click();
	  
	  
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")).click();
	  
	  Thread.sleep(5000);
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")).click();
	  
	  Thread.sleep(5000);
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_text_description\")")).click();
	  
	  Thread.sleep(5000);
	  String Reminder=driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
	  System.out.println(Reminder);
	  String ActualDesc=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Assert.assertEquals(TextReminder, Reminder);
	  Assert.assertEquals(ActualDesc, note);
      
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException { 
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "PixelEmulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("noReset", true);
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);
  }

  @AfterClass
  public void afterClass() {
  }
  
  @DataProvider(name = "Note")
  public String[][] Note() {
      return new String[][] { 
      	{"Note2","My 2nd note"}
      	};
  }  

}