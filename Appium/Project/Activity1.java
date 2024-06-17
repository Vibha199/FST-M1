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

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @DataProvider(name = "TaskNames")
    public String[][] TaskNames() {
        return new String[][] { 
        	{"Complete Activity with Google Tasks"}, 
        	{"Complete Activity with Google Keep"},
        	{"Complete the second Activity Google Keep"}
        	};
    }  
  @Test(dataProvider = "TaskNames")
  public void taskTest(String task) {
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Create new task\")")));
	  driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create new task\")")).click();
	  String newTask = "resourceId(\"com.google.android.apps.tasks:id/add_task_title\")";
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(newTask)));
      driver.findElement(MobileBy.AndroidUIAutomator(newTask)).sendKeys(task);
      driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
          
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Create new task\")")));
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      
      String textItems = driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView").getText();
      
      Assert.assertEquals(textItems, task);
      
    
   
      }	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "PixelEmulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("noReset", true);
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}