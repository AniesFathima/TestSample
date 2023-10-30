package org.base;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowswithScreenshot {
	
	public static WebDriver driver;
	
		public static void screenCapture(String name) throws Exception {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("C:\\Anies\\" +name+ ".png");
			FileUtils.copyFile(srcFile, targetFile);
				}
		public static void main(String[] args) throws Exception {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
	    	driver = new ChromeDriver();	
	    	driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15 pro", Keys.ENTER);
			driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15 Pro (256 GB) - Natural Titanium')]")).click();
			
			
			String parentWindowId = driver.getWindowHandle();
			System.out.println("The Parent Window Id is : " +parentWindowId);
			
			Set<String> firstWindowId = driver.getWindowHandles();
			for (String x : firstWindowId) {
				if(!parentWindowId.equals(x))
				{
			     System.out.println("The First Child Window Id is : " +x);
				}
				driver.switchTo().window(x);
				

				}
			driver.findElement(By.id("add-to-cart-button")).click();
			screenCapture("Add to cart 1st Mobile");
			
			String currentUrl = driver.getCurrentUrl();
		    System.out.println("The First Child URl: " +currentUrl);
		
		    driver.switchTo().window(parentWindowId);
		    driver.findElement(By.id("twotabsearchtextbox")).clear();
		    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 11r ", Keys.ENTER);
		    driver.findElement(By.xpath("//span[contains(text(),'OnePlus 11 5G (Eternal Green, 8GB RAM, 128GB Storage)')]")).click();
		   		     
		    Set<String> allWindowsId = driver.getWindowHandles();
		    List<String> li = new LinkedList<String>();
		    li.addAll(allWindowsId);
		    String secondPhoneID = li.get(2);
		    System.out.println("SecondPhone Id is : " +secondPhoneID);
		    String currentUrl1 = driver.getCurrentUrl();
		    System.out.println("Second url is: " +currentUrl1);
		    driver.switchTo().window(secondPhoneID);
			driver.findElement(By.id("add-to-cart-button")).click();
			screenCapture("Add to cart 2nd Mobile");
		                        
			
			driver.switchTo().window(parentWindowId);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
		    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nothing phone 2", Keys.ENTER);
		    driver.findElement(By.xpath("(//span[contains(text(),'Nothing Phone (2) 5G (White, 12GB RAM, 256GB Storage)')])[1]")).click();
		
		    Set<String> allWindowsId1 = driver.getWindowHandles();
		    List<String> li1 = new LinkedList<String>();
		    li1.addAll(allWindowsId1);
		    String thirdphoneId = li1.get(3);
		    String thirdwindowid = driver.getWindowHandle();
		    System.out.println("thirdWindow Id is : " +thirdwindowid);
		    driver.switchTo().window(thirdphoneId);
		    driver.findElement(By.id("add-to-cart-button")).click();
		    screenCapture("Add to cart 3rd Mobile");
		
		
		
		
		
		
		
		
		    
			
	
	
			
			

	

}}
