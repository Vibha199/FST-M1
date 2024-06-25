package Project_Activity;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
  @Test
  public void NumberOfCourses() {
	  driver.findElement(By.xpath("//li[@id='menu-item-1508']")).click();
	  WebElement header=driver.findElement(By.xpath("//div//h1[@class='uagb-ifb-title']"));
	  System.out.println("After clicking on All courses heading is:"+header.getText());
	  List<WebElement> Courses=driver.findElements(By.xpath("//div//h3[@class='entry-title']"));
	  System.out.println("The Number of courses on the page is:"+Courses.size());
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms");
  }

  @AfterClass
  public void afterClass() {
  }

}