package tyssframework.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baselib {
	
	
	static {
		System.setProperty(Genericlib.getpropdata("browserkey"), Genericlib.getpropdata("browservalue"));
		}
	public WebDriver driver;
	@BeforeMethod
	public void setup(ITestContext context) 
	{
		if(Genericlib.getpropdata("browsername").equalsIgnoreCase("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable -notifications");
			driver =new ChromeDriver(options);
		}
		else if(Genericlib.getpropdata("browsername").equalsIgnoreCase("firefox")) 
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(options);
		}
		else {
	

		Assert.fail("browser name not valid");
		}
		context.setAttribute("driver", driver);
		Reporter.log("Browser launched successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Genericlib.getpropdata("url"));
		Reporter.log("Application loaded");
		
	}
	
	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		Reporter.log("Browser closed successfully");
	}


}
