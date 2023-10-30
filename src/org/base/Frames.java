package org.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();	
    	driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement customerId = driver.findElement(By.xpath("//input[@type='text']"));
		customerId.sendKeys("123456");
		
		List<WebElement> frameNos = driver.findElements(By.tagName("frams"));
		
		int size = frameNos.size();
		System.out.println(size);
	}

}
