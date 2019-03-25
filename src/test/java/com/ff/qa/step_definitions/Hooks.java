package com.ff.qa.step_definitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.ff.qa.helpers.ConfigFileReader;
import com.ff.qa.utilities.BrowserUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {	
	ConfigFileReader configFileReader;
   
	@Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
	public void openBrowser() throws Exception {
		configFileReader = new ConfigFileReader();
	    BrowserUtil.getBrowser(configFileReader.getBrowserType()); 
	}
	
	@After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + BrowserUtil.driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)BrowserUtil.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        BrowserUtil.driver.quit();
    }
}
