package com.ff.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ff.qa.helpers.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	public static WebDriver driver;
	
	 public static void getBrowser(String browser) throws Exception{
		 ConfigFileReader configFileReader = new ConfigFileReader();
			if(browser.equalsIgnoreCase("firefox")){
				//create firefox instance
					WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
				    driver = new FirefoxDriver(options);
				}
				//Check if parameter passed as 'chrome'
				else if(browser.equalsIgnoreCase("chrome")){
					//create chrome instance
                    WebDriverManager.chromedriver().setup();
					//create chrome instance
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("–no-sandbox");
                    options.addArguments("–disable-dev-shm-usage");
                    driver = new ChromeDriver(options);
                    }
				//Check if parameter passed as 'Edge'
						else if(browser.equalsIgnoreCase("Edge")){
							//create Edge instance
							WebDriverManager.edgedriver().setup();
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

