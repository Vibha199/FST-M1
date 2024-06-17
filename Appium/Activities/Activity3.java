package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
  @Test
  public void add() {
      driver.findElementById("digit_5").click();
      driver.findElementById("op_add").click();
      driver.findElementById("digit_9").click();
      // Perform Calculation
      driver.findElementById("eq").click();

      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "14");
  }	
  @Test
  public void subtract() {
      driver.findElementById("digit_1").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("op_sub").click();
      driver.findElementById("digit_5").click();
      // Perform Calculation
      driver.findElementById("eq").click();

      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "5");
  }

  @Test
  public void multiply() {
      driver.findElementById("digit_5").click();
      driver.findElementById("op_mul").click();
      driver.findElementById("digit_1").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("digit_0").click();
      // Perform Calculation
      driver.findElementById("eq").click();

      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "500");
  }

  @Test
  public void divide() {
      driver.findElementById("digit_5").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("op_div").click();
      driver.findElementById("digit_2").click();
      // Perform Calculation
      driver.findElementById("eq").click();

      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "25");
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
	      caps.setCapability("deviceName", "PixelEmulator");
	      caps.setCapability("platformName", "android");
	      caps.setCapability("appPackage", "com.android.calculator2");
	      caps.setCapability("appActivity", ".Calculator");
	      caps.setCapability("noReset", true);
	 
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}