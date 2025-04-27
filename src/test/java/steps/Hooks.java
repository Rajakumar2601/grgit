package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.SeleniumGenerics;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import pages.Loginpage;

public class Hooks extends SeleniumGenerics {
	
	public WebDriver driver;
	
	
	public static Loginpage _loginpage =null;
	
	
	@Before
	public void openbrowser() {
		driver = launchBrowser("chrome");
		_loginpage = PageFactory.initElements(driver, Loginpage.class);
		
		

		
	}

	@After
	public void closebrowser1() {
		
		closeBrowser(driver);
		
	}
}
