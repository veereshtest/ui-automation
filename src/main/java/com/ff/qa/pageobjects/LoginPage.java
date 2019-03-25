package com.ff.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ff.qa.testDataTypes.User;

public class LoginPage extends BaseClass {
		
	public LoginPage(WebDriver driver){
		super(driver);
	} 
	
	@FindBy(how=How.ID, using="email")
	public static WebElement txtbx_email;
	
	@FindBy(how=How.ID, using="passwd")
	public static WebElement txtbx_password;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	public static WebElement signin_button;
	
	@FindBy(how=How.ID, using="email_create")
	public static WebElement email_create;

	@FindBy(how=How.ID, using="SubmitCreate")
	public static WebElement submit_create;
	
	 public static void enter_Email(String email) {
		 txtbx_email.sendKeys(email);
		 }
	
	 public static void enter_Password(String password) {
		 txtbx_password.sendKeys(password);
		 }
	 
	 public static void submit() {
		 signin_button.click();
		 }
	 
	 public static void fillin_details(User user) {
		 enter_Email(user.emailAddress);
		 enter_Password(user.loginPassword);
	}
	 
	 
}
	

