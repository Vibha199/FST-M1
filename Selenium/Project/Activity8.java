package Project_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity8 {
	WebDriver driver;
  @Test
  @Parameters({"name", "email", "subject", "msg"})
  public void fnContactUs(String name,String email,String subject,String msg) {
	  driver.findElement(By.xpath("//li[@id='menu-item-1506']")).click();
	  WebElement name1 = driver.findElement(By.id("wpforms-8-field_0"));
	  WebElement email1 = driver.findElement(By.id("wpforms-8-field_1"));
	  WebElement subject1 = driver.findElement(By.id("wpforms-8-field_3"));
	  WebElement msg1 = driver.findElement(By.cssSelector("textarea[id='wpforms-8-field_2']"));
	  name1.sendKeys(name);
	  email1.sendKeys(email);
	  subject1.sendKeys(subject);
	  msg1.sendKeys(msg);
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  String loginMessage = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();
	  System.out.println("Message after submision:"+loginMessage);	  
	 
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