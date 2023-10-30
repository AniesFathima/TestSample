package org.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectandScreenshot {
	   
	public static WebDriver driver;
	
     public static void screencapture(String pagename) throws IOException {
    	 TakesScreenshot ts = (TakesScreenshot) driver;
    	 File sourceFile = ts.getScreenshotAs(OutputType.FILE);
    	 File destFile = new File("C:\\Anies\\" +pagename + ".png");
    	 FileUtils.copyFile(sourceFile, destFile);
     }
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// To configure browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Aniesakmal");
		driver.findElement(By.id("password")).sendKeys("Akmal@2022");
		
		screencapture("firstpage");
		
		driver.findElement(By.id("login")).click();
		
		
		WebElement location = driver.findElement(By.id("location"));
		Select s = new Select(location);
		s.selectByIndex(5);
		List<WebElement> locate = s.getOptions();
		
		for(int i =0;i< locate.size();i++) {
			 WebElement element = locate.get(i);
			 String text = element.getText();
			 System.out.println(text);
			
		}
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotels);
		s1.selectByValue("Hotel Hervey");
		
List<WebElement> hotel = s1.getOptions();
		
		for(int i =0;i< hotel.size();i++) {
			 WebElement element = hotel.get(i);
			 String text1 = element.getText();
			 System.out.println(text1);
		}
		
		WebElement Room = driver.findElement(By.id("room_type"));
		Select s2 = new Select(Room);
		s2.selectByVisibleText("Super Deluxe");
		
		WebElement noOfRoom = driver.findElement(By.id("room_nos"));
		Select s3 = new Select(noOfRoom);
		s3.selectByIndex(5);
		
		WebElement inDate = driver.findElement(By.id("datepick_in"));
	    inDate.sendKeys("18/06/2023");
	    
		WebElement outDate = driver.findElement(By.id("datepick_out"));
	    inDate.sendKeys("25/06/2023");
	    
	    WebElement adult = driver.findElement(By.id("adult_room"));
		Select s5 = new Select(adult);
		s5.selectByIndex(2);
		
		WebElement child = driver.findElement(By.id("child_room"));
		Select s6 = new Select(adult);
		s6.selectByIndex(2);
		
		screencapture("selected page");
		
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		
		screencapture("second selected page");
		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("first_name")).sendKeys("Anies");
		driver.findElement(By.id("last_name")).sendKeys("Akmal");
		driver.findElement(By.id("address")).sendKeys("Opera fortune");
		driver.findElement(By.id("cc_num")).sendKeys("1234567891234567");
		
		WebElement cardType = driver.findElement(By.id("cc_type"));
		Select s7 = new Select(cardType);
		s7.selectByVisibleText("American Express");
		
		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select s8 = new Select(month);
		s8.selectByIndex(9);
		
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select s9 = new Select(year);
		s9.selectByVisibleText("2022");
		
		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		
		screencapture("third selected page");
		driver.findElement(By.id("book_now")).click();
		
		
		screencapture("last  page");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
