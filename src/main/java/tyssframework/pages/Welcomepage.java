package tyssframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyssframework.lib.Genericlib;

public class Welcomepage 
{
	WebDriver driver;
	@FindBy(xpath = "//body//div[2]//div[2]//div[1]//span[1]//a[1]")
	private WebElement clickherelink;
	
	
	

	public Welcomepage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickhere() 
	{
		Genericlib.clickelement(driver, clickherelink, "clickhere link");
	
	}

}
