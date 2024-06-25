package Project_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity2 {
	WebDriver driver;
  @Test
  public void VerifyHeader() {
	  WebElement header = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
      Assert.assertEquals(header.getText(), "Learn from Industry Experts");
  }
  @BeforeTest(alwaysRun = true)
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
  }

  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  driver.close();
  }

}