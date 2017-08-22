package SLTP.project.Utilities; 

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class browser {
	private final Logger log = LogManager.getLogger(browser.class.getName());
	WebDriver driver; 
	String baseUrl ="";
	public WebDriver browserinit()
	{
		System.setProperty("webdriver.firefox.bin","C:\\Users\\uswjnr67\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\uswjnr67\\Documents\\selenium\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 baseUrl = "http://qaonair.com";
		 driver.get(baseUrl);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 log.info("Web browser is opened in Firefox");
		 log.info("Webpage opened is  "+ baseUrl);
		 return driver;
	}

}
