package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String title=driver.getTitle();
		System.out.println("Title is:"+title);
		WebElement idlocator= driver.findElement(By.id("about-link"));
		System.out.println("Text in element:"+idlocator.getText());
		WebElement classlocator= driver.findElement(By.className("green"));
		System.out.println("Text in element:"+classlocator.getText());
		WebElement linklocator= driver.findElement(By.linkText("About Us"));
		System.out.println("Text in element:"+linklocator.getText());
		WebElement csslocator= driver.findElement(By.cssSelector(".green"));
		System.out.println("Text in element:"+csslocator.getText());
		driver.close();
		
	}

}