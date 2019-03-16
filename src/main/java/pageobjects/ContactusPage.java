package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

	public class ContactusPage extends BaseClass {
				
		public ContactusPage(WebDriver driver)
		{
			super(driver);
		}
		
		@FindBy(how=How.CSS, using=".selector,.hover")
		public static WebElement div_heading;

		@FindBy(how=How.ID, using="id_contact")
		public static Select subject_heading;
		
		@FindBy(how=How.ID, using="email")
		public static WebElement email;
		
		@FindBy(how=How.ID, using="id_order")
		public static WebElement order_reference;
		
		@FindBy(how=How.ID, using="message")
		public static WebElement message;
		
		@FindBy(how=How.ID, using="submitMessage")
		public static WebElement submit;

		@FindBy(how=How.CLASS_NAME, using="alert-danger")
		public static WebElement error_message;
		
		@FindBy(how=How.ID, using="id_contact")
		public static WebElement select_dropdown;
		
        @FindBy(how=How.ID, using="fileUpload")
		public static WebElement file_upload;
        
        @FindBy(how=How.XPATH, using="//p[@class='alert alert-success']")
		public static WebElement success_message;
		
		
		 public static void select_listvalue() {
			 Select value = new Select(select_dropdown);
			 value.selectByVisibleText("Webmaster");
		}
		 
		 public static void enter_Email() {
			 email.sendKeys("veereshpalacharla@gmail.com");
		 }
		 
		 public static void enter_Reference() {
			 order_reference.sendKeys("3456QUJUYI");
		 }
		 
		public static void choose_file() {
			file_upload.click();
		}
		
		public static void click_send() {
			submit.click();
		}
		
		public static void type_message() {
			message.sendKeys("This is a Test");
		}
		
		public static String verify_text() {
			return success_message.getText();
		}
		
		 
}

