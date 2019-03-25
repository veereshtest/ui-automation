package com.ff.qa.modules;

import org.openqa.selenium.JavascriptExecutor;

import com.ff.qa.utilities.BrowserUtil;


public class PageScroll {

	public static void goto_Index() {
	JavascriptExecutor js = (JavascriptExecutor) BrowserUtil.driver;
	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

}