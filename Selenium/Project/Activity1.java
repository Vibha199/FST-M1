package Project_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver;
  @Test
  public void VerifyTitle() {
	  String title = driver.getTitle();
	  System.out.println("Page title is: " + title);
	  Assert.assertEquals("Alchemy LMS – An LMS Application", title);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}