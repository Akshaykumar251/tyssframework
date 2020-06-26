package tyssframework.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tyssframework.init.Iconstants;
import tyssframework.lib.Baselib;
import tyssframework.lib.Excellib;
import tyssframework.pages.Homepage;
import tyssframework.pages.Loginpage;
import tyssframework.pages.Welcomepage;

public class Testscriptone extends Baselib
{
	

	@Test
	public void tc_01() throws InterruptedException 
	{
	
		Welcomepage wp=new Welcomepage(driver);
		wp.clickhere();
		Loginpage lp=new Loginpage(driver);
		String untext = Excellib.getdata("Sheet1", 1, 1, Iconstants.dataexcelpath);
		String pwdtext = Excellib.getdata("Sheet1", 1, 2, Iconstants.dataexcelpath);
		lp.enterTExt(untext, pwdtext);
		Thread.sleep(2000);
		lp.loginBtn();
		Homepage hp=new Homepage(driver);
		hp.click();
		String patnametext=Excellib.getdata("Sheet1", 1, 3, Iconstants.dataexcelpath);
		String patcontacttext=Excellib.getdata("Sheet1", 1, 4, Iconstants.dataexcelpath);
		String patmailtext=Excellib.getdata("Sheet1", 1, 5, Iconstants.dataexcelpath);
		hp.enterText(patnametext, patcontacttext, patmailtext);
		hp.clickgenderbtn();
		String pataddresstext=Excellib.getdata("Sheet1", 1, 6, Iconstants.dataexcelpath);
		String patagetext=Excellib.getdata("Sheet1", 1, 7, Iconstants.dataexcelpath);
		String medhistext=Excellib.getdata("Sheet1", 1, 8, Iconstants.dataexcelpath);
		hp.enterText1(pataddresstext, patagetext, medhistext);
		hp.clickaddbtn();
		
		

		
	}

}
