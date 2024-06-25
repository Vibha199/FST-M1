package Project_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
  @Test
  public void VerifyFirstInfoBox() {
	  WebElement FirstInfoBox=driver.findElement(By.xpath("(//div//h3[@class='uagb-ifb-title'])[1]"));
	  Assert.assertEquals(FirstInfoBox.getText(), "Actionable Training");
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