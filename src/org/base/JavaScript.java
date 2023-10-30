package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akmal\\eclipse-workspace\\SeleniumConfiguration\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();	
    	driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
           // Java Based
		  WebElement user = driver.findElement(By.id("email"));
		  		  
		  JavascriptExecutor js =(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].setAttribute('value','anies')", user);
		  		  
		  //javabased
		  String Java = user.getAttribute("Value");
		  System.out.println("Java Based :" +Java);
		  
		  //JS based
		  Object userName = js.executeScript("return arguments[0].getAttribute('value')", user);
		  System.out.println("JS Based :" +userName);
	
		  WebElement pass = driver.findElement(By.id("pass"));
	     js.executeScript("arguments[0].setAttribute('value','12345')", pass);
	     
	     Object password = js.executeScript("return arguments[0].getAttribute('value')", pass);
		  System.out.println(password);
		  
//		  WebElement log = driver.findElement(By.name("login"));
//		  js.executeScript("arguments[0].click()", log);
		  
		 // driver.quit();
		  WebElement dowm = driver.findElement(By.linkText("Create a Page"));
		  
		  js.executeScript("arguments[0].scrollIntoView(true)", dowm);
		  
		  Thread.sleep(2000);
		  WebElement up = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		  
		  js.executeScript("arguments[0].scrollIntoView(false)", up);
	}

}
