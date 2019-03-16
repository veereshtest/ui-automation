package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ConfigFileReader;
import helpers.JsonDataReader;
import modules.PageScroll;
import modules.UploadFile;
import pageobjects.ContactusPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import testDataTypes.User;
import utilities.BrowserUtil;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SigninSignoutContactUsSteps {
	
	WebDriver driver = BrowserUtil.driver;
	ConfigFileReader configFileReader;
	
	@When("^I open automationpractice website$")
	public void i_open_automationpractice_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		    configFileReader = new ConfigFileReader();
		    driver.get(configFileReader.getApplicationUrl());
		    
	}

	@When("^I sign in using \"([^\"]*)\" login details$")
	public void i_sign_in_using_login_details(String userName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageScroll.goto_Index();
        Thread.sleep(30000);
        HomePage.signin_Link();
		User user = JsonDataReader.getJsonReader().getUserByName(userName);
        LoginPage.fillin_details(user);
		LoginPage.submit();
		

	}

	@Then("^I sign out$")
	public void i_sign_out() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actual = "Veeresh Palacharla";
		//System.out.println(HomePage.account_name.getText());
		assertThat(actual, is(equalTo(HomePage.get_Account())));
		HomePage.signout_Link();
	}
	
	
	@Then("^I perform contact us actions$")
	public void i_perform_contact_us_actions() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, ContactusPage.class);
		HomePage.contactus_Link();
		PageScroll.goto_Index();
		ContactusPage.select_listvalue();
		ContactusPage.enter_Email();
		ContactusPage.enter_Reference();
		ContactusPage.choose_file();
		UploadFile.upload();
		ContactusPage.type_message();
		ContactusPage.click_send();	 
		String actual = "Your message has been successfully sent to our team.";
		assertThat(actual, is(equalTo(ContactusPage.verify_text())));
	}

}
