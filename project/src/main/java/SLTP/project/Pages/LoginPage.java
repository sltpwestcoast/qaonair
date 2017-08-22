package SLTP.project.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	private final Logger log = LogManager.getLogger(LoginPage.class.getName());
	 WebDriver driver;
	 public LoginPage(WebDriver driver)
	 {   System.out.println("start constructor");
		// PageFactory.initElements(driver, Login.class);
		 this.driver = driver;
		 System.out.println("In constructor");
		
	 }
	 
	
	@FindBy(how=How.NAME, using ="user_login")
	WebElement username;
	@FindBy(how=How.NAME, using ="user_pass")
	WebElement password;
	@FindBy(how=How.CSS, using ="button.btn-submit.fre-submit-btn")
	WebElement submitbutton;
	
	public void Login_process(String uid, String pwd)
	{
		System.out.println("Login process called");
	username.sendKeys(uid);	
	log.debug("User id is entered " + uid);
   password.sendKeys(pwd);
   log.debug("Password is entered " + uid);
   submitbutton.click();
   log.debug("Submit button is clicked");
	}
}
