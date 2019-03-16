package modules;

import org.openqa.selenium.JavascriptExecutor;
import utilities.BrowserUtil;


public class PageScroll {

	public static void goto_Index() {
	JavascriptExecutor js = (JavascriptExecutor) BrowserUtil.driver;
	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

}