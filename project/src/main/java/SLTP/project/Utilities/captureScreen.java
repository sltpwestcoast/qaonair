package SLTP.project.Utilities;

import java.io.File; 
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreen {
	private static Logger log = LogManager.getLogger(captureScreen.class.getName());
	 
	public static String capture(WebDriver driver, String screenshotname) throws IOException
	{
		String dest;
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = (File) ts.getScreenshotAs(OutputType.FILE);
		dest = System.getProperty("user.dir")+"/ErrorScreens/"+screenshotname+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		log.info("Screen is captured for this test case");
		return dest;
	}

	
}
