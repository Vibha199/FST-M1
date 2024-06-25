package Project_Activity;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
  @Test
  public void NavigateMyAccount() {
	  driver.findElement(By.xpath("//li[@id='menu-item-1507']")).click();
	  String PageTitle=driver.getTitle();
	  System.out.println("Title of the page is:"+PageTitle);
	  Assert.assertEquals("My Account – Alchemy LMS", PageTitle);
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