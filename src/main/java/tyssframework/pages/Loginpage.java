package tyssframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyssframework.lib.Genericlib;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement untxtbox;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwdtxtbox;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginbtn;
	
	public Loginpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterTExt(String untext, String pwdtext) throws InterruptedException 
	{
		Genericlib.enterText(driver,untxtbox, "username textbox",untext);
		Thread.sleep(3000);
		Genericlib.enterText(driver, pwdtxtbox, "password textbox",pwdtext);
		
		
		
	}
	
	public void loginBtn() 
	{
		
		Genericlib.clickelement(driver, loginbtn, "Login button");
	}

}
