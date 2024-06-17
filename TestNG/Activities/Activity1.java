package testNGTests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver;
	
  @Test
  public void f() {
	 String PageTitle=driver.getTitle();
	 System.out.println("Title of the page is:"+PageTitle);
	 Assert.assertEquals("Training Support", PageTitle);
	 driver.findElement(By.id("about-link")).click();
	 String PageTitle1=driver.getTitle();
	 System.out.println("Title of the page is:"+PageTitle1);
	 Assert.assertEquals(PageTitle1,"About Training Support");
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}