package steps;

import io.cucumber.java.en.*;

public class loginStepUsingOutline {
	@Given("I launched  BP travel page")
	public void i_launched_bp_travel_page() {
	   System.out.println("bp travel page");
	}

	@When("I enter Username {string} and password {string}")
	public void i_enter_username_admin_and_password_admin(String username, String password) {
	    System.out.println("user " + username);
	    System.out.println("pass " + password);
	}

	@And("I clicked login button")
	public void i_clicked_login_button() {
	    System.out.println("click button");
	}

	@Then("I verify homepage Url {string}")
	public void i_verify_homepage_urlhttps_bptravel_blueprism_com_search_html(String url) {
	    System.out.println("verify"+ url);
	}
	@Then("I verify homepage Url\"https:\\/\\/bptravel.blueprism.com\\/search.html\"")
	public void i_verify_homepage_url_https_bptravel_blueprism_com_search_html() {
		System.out.println("verify");
	}

}
