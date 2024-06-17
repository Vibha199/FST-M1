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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
  @Test(dataProvider = "Note")
  public void taskKeep(String title,String note ) {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"New text note\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"New text note\")")).click();
	  
	  String newTitle = "resourceId(\"com.google.android.keep:id/editable_title\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(newTitle)));
      driver.findElement(MobileBy.AndroidUIAutomator(newTitle)).sendKeys(title);
      
      String newDesc = "resourceId(\"com.google.android.keep:id/edit_note_text\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(newDesc)));
      driver.findElement(MobileBy.AndroidUIAutomator(newDesc)).sendKeys(note);
      
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Open navigation drawer\")")).click();
	  
	  String ActualTitle=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
	  String ActualDesc=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Assert.assertEquals(ActualTitle, title);
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
	  driver.quit();
  }
  
  @DataProvider(name = "Note")
  public String[][] Note() {
      return new String[][] { 
      	{"Note1","My 1st note"}
      	};
  }  

}