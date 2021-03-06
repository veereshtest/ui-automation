package com.ff.qa.modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class UploadFile {
	
	       public static void upload() throws Exception {
	        		        
	        File file = new File("/Users/veereshpalacharla/Desktop/IMG_1001.PNG");
			 
			StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
			 
			//Copy to clipboard 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			 
			Robot robot = new Robot();
			 
			// Cmd + Tab is needed since it launches a Java app and the browser looses focus
			 
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_TAB);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_TAB);
			 
			robot.delay(500);
			 
			//Open Goto window
			 
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_SHIFT);
			 
			robot.keyPress(KeyEvent.VK_G);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_SHIFT);
			 
			robot.keyRelease(KeyEvent.VK_G);
			 
			//Paste the clipboard value
			 
			robot.keyPress(KeyEvent.VK_META);
			 
			robot.keyPress(KeyEvent.VK_V);
			 
			robot.keyRelease(KeyEvent.VK_META);
			 
			robot.keyRelease(KeyEvent.VK_V);
			 
			//Press Enter key to close the Goto window and Upload window
			 
			robot.keyPress(KeyEvent.VK_ENTER);
			 
			robot.keyRelease(KeyEvent.VK_ENTER);
			 
			robot.delay(500);
			
	        }
	        

}
