package SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubthrows InterruptedException
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String title=driver.getTitle();
		System.out.println("Title is:"+title);
		driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
		System.out.println("Heading is: " + driver.getTitle());
		driver.close();
		
	}

}