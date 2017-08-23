package SLTP.project.Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home { 
	WebDriver driver; 
	
	 public Home(WebDriver driver)
	 {  
	
		 //PageFactory.initElements(driver, Home.class);
		 this.driver = driver;
		 System.out.println("In constructor");
		 
	 }
	 

	@FindBy(how=How.LINK_TEXT, using="SIGN UP")
	WebElement signup;
	@FindBy(how=How.LINK_TEXT, using ="LOGIN")
	WebElement login;
	@FindBy(how=How.LINK_TEXT, using ="EMPLOYERS")
	WebElement emp;
	@FindBy(how=How.CLASS_NAME, using ="fre-menu-freelancer dropdown")
	WebElement free;
	
	public void login(String uid, String pwd)
	{
		System.out.println("Login process called");
//	username.sendKeys(uid);	
  // password.sendKeys(pwd);
  // submitbutton.click();
	}
	public void signup()
	{signup.click();}
	public void emppostproject()
	{ 
		System.out.println("emppost  project");
		signup.click();
	}
	public void empfindfree()
	{
		System.out.println("emp find  freelancer");
		login.click();
	}
	public void freefindproject()
	{}
	public void freecreateprofile()
	{}
	
}
