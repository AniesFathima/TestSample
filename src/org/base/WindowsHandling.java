package org.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();	
    	driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15 pro", Keys.ENTER);
		driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 15 Pro (128 GB) - Natural Titanium')])[1]")).click();
		
		//To find windows id or current window or parent window
		String parentwindowsId = driver.getWindowHandle();
		System.out.println("parent windows id : " +parentwindowsId);
		
		//To find all windows id
		
		Set<String> allWindowsID = driver.getWindowHandles();
		System.out.println("All windows id : " +allWindowsID);
		  
		for(String x : allWindowsID) {
			if(!parentwindowsId.equals(x)) {
				System.out.println("First child window  " +x);
				//Switch to first child window
				
				driver.switchTo().window(x);
						
							}}
		driver.findElement(By.id("add-to-cart-button")).click();
			// to swich back to parent window again
		
		driver.switchTo().window(parentwindowsId);
		
		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15 Pro (128 GB) - White Titanium')]")).click();
		// to find all the windows again
		Set<String> allwindowsID2 = driver.getWindowHandles();
		
		List<String> li =new LinkedList<String>();
		li.addAll(allwindowsID2);
		String secondWindowsId = li.get(2);
		System.out.println("Second child window "  +secondWindowsId);
		Set<String> allWindowsId1 = driver.getWindowHandles();
		System.out.println(allWindowsId1);
		
		driver.switchTo().window(secondWindowsId);
		driver.findElement(By.id("add-to-cart-button")).click();
		
		
		
		

	}

}
