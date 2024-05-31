package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		String title=driver.getTitle();
		System.out.println("The title is:"+title);
		WebElement firstname=driver.findElement(By.id("firstName"));
		WebElement lastname=driver.findElement(By.id("lastName"));
		firstname.sendKeys("Swagatika");
		lastname.sendKeys("Biswal"); 
		driver.findElement(By.id("email")).sendKeys("abc@example.com");
		driver.findElement(By.id("number")).sendKeys("1233456789");
		driver.findElement(By.cssSelector(".ui.green.button")).click();
		driver.close();
		
	}

}