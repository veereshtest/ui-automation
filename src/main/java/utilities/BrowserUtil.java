package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import helpers.ConfigFileReader;

public class BrowserUtil {
	
	public static WebDriver driver;
	
	 public static void getBrowser(String browser) throws Exception{
		 ConfigFileReader configFileReader = new ConfigFileReader();
			if(browser.equalsIgnoreCase("firefox")){
				//create firefox instance
				    System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath()+"geckodriver");
					driver = new FirefoxDriver();
				}
				//Check if parameter passed as 'chrome'
				else if(browser.equalsIgnoreCase("chrome")){
					//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver",  configFileReader.getDriverPath()+"chromedriver");
					//create chrome instance
					driver = new ChromeDriver();
				}
				//Check if parameter passed as 'Edge'
						else if(browser.equalsIgnoreCase("Edge")){
							//set path to Edge.exe
							System.setProperty("webdriver.edge.driver", configFileReader.getDriverPath()+"MicrosoftWebDriver.exe");
							//create Edge instance
							driver = new EdgeDriver();
						}
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");
				}
			
			driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	    }
	
}

