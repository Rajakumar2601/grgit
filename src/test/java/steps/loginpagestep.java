package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.SeleniumGenerics;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;
import pages.Loginpage;

public class loginpagestep  {
	
	
	
	/*@Given("I launched BPTravelwebpage")
	public void i_launched_bp_travelwebpage() {
	    System.out.println("open BP TRAVEL web page");
	    
	}   @When("I enter valid UserName {string} and Password {string}")          
        public void i_enter_valid_user_name_admin_and_password(String username, String password) { 
	       
	          System.out.println("enter username and password");                  
	    }                                                                       
                                                                                
	

	
	public void clicked_the_login_button() {
	     
	    System.out.println("click login button ");
	}

	@Then("I validate homepage Url {string}")
	public void i_validate_homepage_url(String homepageURL) {
	    System.out.println(" validate title");
	    
	}

	@When("I enter UserName {string}and Password {string}")
	public void i_enter_user_name_admin12_and_password(String username, String password) {
	   System.out.println("enter invalid username");
	   
	}

	@Then("I validate ErrorMessage {string}")
	public void i_validate_error_message(String errormsg) {
	    
	  System.out.println(" validate error msg"); 
	  
	}*/
	
	@Given("I launched BPTravelwebpage  {string}")
	public void i_launched_bp_travelwebpage(String Url) {
		Hooks._loginpage.openBpTravel(Url);
	}
	@When("I enter valid UserName {string}and Password {string}")
	public void i_enter_valid_user_name_admin_and_password(String username,String password ) throws InterruptedException {
		Hooks._loginpage.loginWithValidUserDetails(username, password);
		
	}
	
	@Given("I launched BPTravelwebpage {string}")
	public void i_launched_bp_travelwebpageagain(String Url) {
	    // Write code here that turns the phrase above into concrete actions
		Hooks._loginpage.openBpTravel(Url);
	}
	

	
	
	
	
	/*@Given("I launched BPTravelwebpage {string}")
	public void i_launched_bp_travelwebpage( String UrL) {
		Hooks._loginpage.openBpTravel(UrL);
	    
	}*/

	/*@When("I enter valid UserName {string} Password {string}")
	public void i_enter_valid_user_name_admin_and_password(String username, String password) throws InterruptedException {
		Hooks._loginpage.loginWithValidUserDetails(username, password);
	    
	}*/

	@When("clicked the login Button")
	public void clicked_the_login_button() {
	    Hooks._loginpage.clickElement();
	}

	@Then("I validate homepage Url {string}")
	public void i_validate_homepage_url(String eUrl) {
	    Hooks._loginpage.validateUrl(eUrl);
	}
	
	@When("I enter UserName {string} and password {string}")
	public void i_enter_user_name_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		Hooks._loginpage.loginWithInValidUserDetails(string,string2);
	}

	

	

	@Then("I validate ErrorMessage {string}")
	public void i_validate_error_message(String string) {
	    Hooks._loginpage.validateErrorMsg(string);
	}

	
}



