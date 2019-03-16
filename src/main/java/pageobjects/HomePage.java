package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import modules.PageScroll;

public class HomePage extends BaseClass {

	PageScroll pageScroll;
	
	public HomePage(WebDriver driver){
		super(driver);
		}  

	@FindBy(how=How.LINK_TEXT, using="Sign in")
	public static WebElement sign_in;
	
	@FindBy(how=How.LINK_TEXT, using="Contact us")
	public static WebElement contact_us;

	@FindBy(how=How.LINK_TEXT, using="Sign out")
	public static WebElement sign_out;
	
	@FindBy(how=How.LINK_TEXT, using="Veeresh Palacharla")
	public static WebElement account_name;
	
	public static void signin_Link() {
		 sign_in.click();
		 }
	
	public static void signout_Link() {
		 sign_out.click();
		 }
	
	public static String get_Account() {
		 return account_name.getText();
		 }
	
	public static void contactus_Link() {
		contact_us.click();
	
	     } 
	

}
