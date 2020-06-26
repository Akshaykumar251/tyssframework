package tyssframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.description.type.TypeDescription.Generic;
import tyssframework.lib.Genericlib;

public class Homepage 
{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Patients')]")
	private WebElement patientslink;
	
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Add Patient')]")
	private WebElement addpatientlink;
	
	
	@FindBy(xpath = "//input[@name='patname']")
	private WebElement patnametxtfield;
	
	
	@FindBy(xpath = "//input[@name='patcontact']")
	private WebElement patcontacttxtfield;
	
	
	@FindBy(xpath = "//input[@name='patemail']")
	private WebElement patemailtxtfield;
	
	
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement genderbtn;
	
	@FindBy(xpath = "//textarea[@name='pataddress']")
	private WebElement patadresstxtfield;
	
	@FindBy(xpath = "//input[@name='patage']")
	private WebElement patagetextfield;
	
	@FindBy(xpath = "//textarea[@name='medhis']")
	private WebElement medhistextfield;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement addbtn;
	
	
	public Homepage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void click() 
	{
		Genericlib.clickelement(driver, patientslink, "patients link");
		Genericlib.clickelement(driver, addpatientlink, "add patient link");
	
		
	}
	
	public void enterText(String patnametext, String patcontacttext, String patmailtext) 
	{
		Genericlib.enterText(driver, patnametxtfield, "patient name textfield", patnametext);
		Genericlib.enterText(driver, patcontacttxtfield, "patient contact", patcontacttext);
		Genericlib.enterText(driver, patemailtxtfield, "patient mail", patmailtext);
		
		
	}
	

	
	public void clickgenderbtn() 
	{
		Genericlib.clickelement(driver, genderbtn, "gender button");
	}
	
	public void enterText1(String pataddresstext, String patagetext, String medhistext) 
	{
		
		Genericlib.enterText(driver, patadresstxtfield, "patient address", pataddresstext);
		Genericlib.enterText(driver, patagetextfield, "patient age", patagetext);
		Genericlib.enterText(driver, medhistextfield, "patient med history", medhistext);
	}
	
	public void clickaddbtn() 
	{
		Genericlib.clickelement(driver, addbtn, "add button");
	}


	
	

}
