package com.examples;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FindingMultipleElements {
	AndroidDriver driver; 
	File file = new File("C:\\Users\\Patrick\\Documents\\LearnSelenium\\Appium_FindingElements\\apk\\com.davemac327.gesture.tool.apk");
	
  @Test
  public void testApp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Moto G");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", file.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
		
		//List<WebElement> buttons =  driver.findElementsByClassName("android.widget.Button");
		List<WebElement> buttons =  driver.findElements(By.className("android.widget.Button"));
		
		System.out.println("Button available on screen: " + buttons.size());
		for(int i=0; i< buttons.size(); i++){
			System.out.println("Name of the button: " + buttons.get(i).getText());
		}
		
		//Using attribut 
		System.out.println("\n===================== Using attribut ================== ");
		for(int i=0; i< buttons.size(); i++){
			System.out.println("Name of the button: " + buttons.get(i).getAttribute("text"));
		}
		
			System.out.println("\n =================== Click on Add gesture button  ==================  ");
				for(int i=0; i< buttons.size(); i++){
					if(buttons.get(i).getText().equals("Add gesture")){
						buttons.get(i).click();
						System.out.println("Button: clicked");
					}
				}
		
  }
  
  @AfterTest
  public void TearDown() throws InterruptedException{
	  Thread.sleep(5000);
	  driver.quit();
  }
}
