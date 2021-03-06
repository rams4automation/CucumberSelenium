package com.InforM3.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.Synovus.fileutils.ConfigReader;

public class BasePage {

	WebDriver driver;
	ConfigReader con=new ConfigReader();
	
	String path=con.getChromeDriverPath();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }
	
	
	public WebDriver Openurl(WebDriver driver,String URL) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver=new FirefoxDriver();
		driver.manage().window().maximize();
		 Thread.sleep(2000);
		//driver.get("https://www.facebook.com/");
		driver.get(URL);
		return driver;
	}
	
	public void clickmethod(WebDriver driver,By element){
		driver.findElement(element).click();
	}
	
	public void Sendkeysmethod(WebDriver driver,By Element,String text){
		driver.findElement(Element).clear();
		driver.findElement(Element).sendKeys(text);
	}


	
	

}
