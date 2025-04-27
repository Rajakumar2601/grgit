package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.PrintUtils;
import common.SeleniumGenerics;

public class Loginpage extends SeleniumGenerics{
	
	WebDriver driver;
	public Loginpage(WebDriver pageDriver) 
	{
		this.driver = pageDriver;
	}

	/*public  Loginpage(WebDriver pageDriver)
	{
		this.driver = pageDriver;
	}
*/
	// Page Elements - Locate
	@FindBy(id = "username")
	WebElement userNameEle;

	@FindBy(id = "password")
	WebElement passwordEle;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement LoginButtonEle;

	@FindBy(linkText = "Configuration")
	WebElement configLinkEle;

	@FindBy(id = "message")
	WebElement errorMessageEle;

	// page methods


	public void clickConfigLink(String expectedTitle) 
	{
		clickElement(configLinkEle);
		String value =	getPageTitle(driver);
		if(value.equals(expectedTitle))
		{
			PrintUtils.logMsg("Config page title matched");
		}else 
		{
			PrintUtils.logError("Config page title not matched");
		}
	}

	
	public void openBpTravel(String url) {
		getURL(driver, url);
		
	}
	public void loginWithValidUserDetails(String userName, String pwd) throws InterruptedException 
	{
		enterText(userNameEle,userName);
		enterText(passwordEle, pwd);
		
		
	}
	public void clickElement() {
		
	
		clickElement(LoginButtonEle);
	}
		
		
		public void validateUrl( String expectedURl) {
			
		String value =	currentURL(driver);
		if(value.equals(expectedURl))
		{
			PrintUtils.logMsg("Home page url matched");
		}else 
		{
			PrintUtils.logError("Home page url not matched");
		}
	}

	public void loginWithInValidUserDetails(String userName, String pwd) 
	{
		enterText(userNameEle,userName);
		enterText(passwordEle, pwd);
		
	}
	public void clickloginelement() {
		
	
	
		clickElement(LoginButtonEle);
	}
		
		public void validateErrorMsg(String expectedErrorMsg) {
			
		
		String value =	getElementText(errorMessageEle);
		if(value.equalsIgnoreCase(expectedErrorMsg))
		{
			PrintUtils.logMsg("Error message is matched");
		}else 
		{
			PrintUtils.logError("Error message is not matched");
		}
	}

}



