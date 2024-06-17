package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
  @Test
  public void f() {
	  String title=driver.getTitle();
	  System.out.println("Title is:"+title);
	  Assert.assertEquals(title,"Target Practice");
  }
  @Test
  public void f1() {
	  WebElement blackbutton=driver.findElement(By.cssSelector("button.black"));
	  Assert.assertTrue(blackbutton.isDisplayed());
      Assert.assertEquals(blackbutton.getText(), "black");
	  
  }
  @Test(enabled= false)
  public void f2() {
	  String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  @Test
  public void f3() throws SkipException {
	  throw new SkipException("Skipping - This is not ready for testing ");
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}