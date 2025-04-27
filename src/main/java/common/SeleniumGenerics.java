package common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SeleniumGenerics {
public static SoftAssert sa;
	
	public static Map<String, String> map =  new HashMap<String, String>();
	public WebDriver launchBrowser(String browserName) 
	{
		WebDriver driver =null;

		if(browserName.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("EDGE"))
		{
			driver = new InternetExplorerDriver();
		}else 
		{
			System.out.println("Please provide only chrome or IE");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}
	
	public void getURL(WebDriver driver, String url) 
	{
		driver.get(url);
	}
	
	public void browserMinimize(WebDriver driver)
	  {
		  driver.manage().window().minimize();
		  PrintUtils.logMsg("browser is minimized");
	  }
	public void browserFullScreen(WebDriver driver)
	  {
		  driver.manage().window().fullscreen();
		  PrintUtils.logMsg("browser in fullscreen");
	  }
	
	public void browserSetSize(WebDriver driver)
	  {
		Dimension dim = new Dimension(400,600);
		  driver.manage().window().setSize(dim);
	  }

	public void url(WebDriver driver, String websiteurl) {
		driver.get(websiteurl);	
		PrintUtils.logMsg("Website Url:" + websiteurl);
	}
	public void back(WebDriver driver) {
		driver.navigate().back();
		PrintUtils.logMsg("Driver navigated back");
	}
	public void forward(WebDriver driver) {
		driver.navigate().forward();
		PrintUtils.logMsg("Driver navigated forward");
		
	}
	public void refreshBrowser(WebDriver driver) 
	{
		driver.navigate().refresh();
		PrintUtils.logMsg("Driver is refreshed");
	}
	public void to(WebDriver driver, String pageURL) {
		driver.navigate().to(pageURL);	
		PrintUtils.logMsg("Navigating Url:" + pageURL);
	}
	public void closeBrowser(WebDriver driver) 
	{
		driver.close();
		PrintUtils.logMsg("Driver is closed");
	}

	public void quitBrowser(WebDriver driver) 
	{
		driver.quit();
		PrintUtils.logMsg("Driver is Quited");
	}
	public String currentURL(WebDriver driver) {
		String Current_Url =  driver.getCurrentUrl();
		PrintUtils.logMsg("Current URl :" + Current_Url);
		return Current_Url;	
	}

	public String getPageTitle(WebDriver driver) 
	{
		String actualValue = driver.getTitle();
		PrintUtils.logMsg("Page Title :" + actualValue);
		return actualValue;
	}
	public String pageSource(WebDriver driver) {
		String pagesource = driver.getPageSource();
		return pagesource;

	}
	
	public void takeScreenShot(WebDriver driver, String  screeshotName) throws Exception 
	{	
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/"+screeshotName+".png"));
		PrintUtils.logMsg("Driver Screenshot is captured");
	}

	public void takeElementScreenshot(WebElement ele, String  screeshotName) throws IOException 
	{
		File src= ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/"+screeshotName+".png"));
		PrintUtils.logMsg("Element Screenshot is captured");
		
	}
	public void enterText(WebElement ele, String valueToEnter) 
	{
		ele.sendKeys(valueToEnter);
		PrintUtils.logMsg("value enterd in input box :" + valueToEnter);
	}

	public void clickElement(WebElement ele) 
	{
		ele.click();
		PrintUtils.logMsg("Element is clicked");
	}
	public String getElementText(WebElement ele) {
		String eletext = ele.getText();
		PrintUtils.logMsg("Element text:" + eletext);
		return eletext;		
	}

	public String elementAttribute(WebElement ele, String attributeName) {
		String Attribute_name = ele.getDomAttribute(attributeName);
		PrintUtils.logMsg("Element attribute text:" + Attribute_name);
		return Attribute_name;

	}

	public void selectDropdownByValue(WebElement ele, String value) {
		Select st = new Select(ele);
		st.selectByValue(value);
		PrintUtils.logMsg("dropdown is selected by value");

	}
	public void selectDropdownByVisibleText(WebElement ele, String visibleText) {
		Select st = new Select(ele);
		st.selectByVisibleText(visibleText);
		PrintUtils.logMsg("dropdown is selected by VisibleText ");

	}
	public void selectDropdownByIndex(WebElement ele, int index) 
	{
		Select st = new Select(ele);
		st.selectByIndex(index);
		PrintUtils.logMsg("dropdown is selected by Index ");
	}
	public String getfirstselectedOption(WebElement ele) {
		Select st = new Select(ele);
		String firstselectedOption = st.getFirstSelectedOption().getText();
		PrintUtils.logMsg("first selected option : " + firstselectedOption);
		return firstselectedOption;

	}
	public List<WebElement> GetOption(WebElement ele) {

		Select st = new Select(ele);
		List<WebElement> Optionselement = st.getOptions();
	
		return Optionselement;
	}
	public List<WebElement> allSelectedOption(WebElement ele) {

		Select st = new Select(ele);
		List<WebElement> AllselectedEle = st.getAllSelectedOptions();
		return AllselectedEle;
		
	}
	public void alertAccept(WebElement ele, WebDriver driver) {

		
		Alert at = driver.switchTo().alert();
		at.accept();
		PrintUtils.logMsg("alert accepted : ");

	}
	public void alertDismiss(WebElement ele,WebDriver driver) {
		
		Alert at = driver.switchTo().alert();
		at.dismiss();
		PrintUtils.logMsg("alert dismissed : ");

	}
	public void alertSendkeys(WebElement ele, WebDriver driver, String text) {
		
		Alert at = driver.switchTo().alert();
		at.sendKeys(text);
		PrintUtils.logMsg("Input text for alert : " + text);
		
	}
	public String alertGetText(WebElement ele, WebDriver driver) {
		
		Alert at = driver.switchTo().alert();
		String alertText=  at.getText();
		PrintUtils.logMsg("Alert text is : " + alertText);
		return alertText;

	}

	public void iframeByElement(WebDriver driver, WebElement ele) {

		driver.switchTo().frame(ele);
		PrintUtils.logMsg("Driver switched to new frame by element : ");

	}
	public void iframeByIndex(WebDriver driver, int index) {

		driver.switchTo().frame(index);
		PrintUtils.logMsg("Driver switched to new frame by index : ");

	}
	public void iframeByString(WebDriver driver, String framename) {

		driver.switchTo().frame(framename);
		PrintUtils.logMsg("Driver switched to new frame by string : ");

		
	}
	public void frameDefaultContent ( WebDriver driver ) {
		
		driver.switchTo().defaultContent();	
		PrintUtils.logMsg("Driver switched to default : ");
	}
	
	public void scrollIntoViewByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
	}
	public void clickByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		PrintUtils.logMsg("Element is clicked : ");
		
	
	}
	 public void isDisplay( WebElement ele)
	 {
		ele.isDisplayed();
	 }
	 
	 public void isEnabled( WebElement ele)
	 {
		ele.isEnabled();
	 }
	 public void isSelected(WebElement ele)
	 {
		ele.isSelected();
		
	 }

}
