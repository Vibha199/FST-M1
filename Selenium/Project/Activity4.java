package Project_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	WebDriver driver;
  @Test
  public void VerifyPopularCourses() {
	  WebElement PopularCourses=driver.findElement(By.xpath("(//div//h3[@class='entry-title'])[2]"));
	  Assert.assertEquals(PopularCourses.getText(), "Email Marketing Strategies");
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}