     package Project_Activity;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
  @Test
  @Parameters({"username", "password"})
  public void NavigateMyAccount(String username, String password) {
	driver.findElement(By.xpath("//li[@id='menu-item-1507']")).click();
	String PageTitle=driver.getTitle();
	System.out.println("Title of the page is:"+PageTitle);
	Assert.assertEquals("My Account – Alchemy LMS", PageTitle);
	WebElement LoginButton=driver.findElement(By.xpath("//a[@href='#login']"));
	LoginButton.click();	
	 WebElement usernameField = driver.findElement(By.id("user_login"));
     WebElement passwordField = driver.findElement(By.id("user_pass"));
     usernameField.sendKeys(username);
     passwordField.sendKeys(password);
     driver.findElement(By.cssSelector("input[type='submit']")).click();
     WebElement header=driver.findElement(By.xpath("//div//h1[@class='uagb-ifb-title']"));
     Assert.assertEquals(header.getText(),"My Account");  
     System.out.println("After login heading is:"+header.getText());
   
  }

  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}