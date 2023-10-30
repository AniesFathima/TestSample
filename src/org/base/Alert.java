package org.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class Alert {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();	
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box')]")).click();
//		driver.switchTo().alert().accept();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]")).click();
//		driver.switchTo().alert().dismiss();
//				
//		Thread.sleep(2000);
//		
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]")).click();
	   Alert alert = (Alert) driver.switchTo().alert();
	   
	    
			
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
