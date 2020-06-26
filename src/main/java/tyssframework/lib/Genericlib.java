package tyssframework.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

import tyssframework.init.Iconstants;

public class Genericlib {
	
	public static String getpropdata(String key) 
	
	{
		String data="";
		try {
			FileInputStream fin = new FileInputStream(Iconstants.propfilepath);
			Properties prop=new Properties();
			prop.load(fin);
			data=prop.getProperty(key);
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
		
	}

	
	public static void clickelement(WebDriver driver, WebElement ele, String elename) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
		Reporter.log("clicked on"+elename);
		}
		catch(TimeoutException e)
		{
			Reporter.log(elename+"is not displayed");
			Assert.fail();		
		}
	}
	public static void enterText(WebDriver driver, WebElement ele, String elename, String text) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
		wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);;
		Reporter.log("Entered text \""+text+"\"In the"+elename);
		}
		
		catch (Exception e) 
		{
			Reporter.log(elename+"is not displayed");
			Assert.fail();		
		}
}
	
	public static void saveScreenshot(WebDriver driver, String filemname) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String timecurrent = LocalDateTime.now().format(dtf);
		
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(Iconstants.screenshotpath+filemname+""+timecurrent+"_failed.png");
	try {
		Files.copy(src, dest);
	} 
	catch (IOException e) {

		e.printStackTrace();
	}
	}
	
	


	
}
