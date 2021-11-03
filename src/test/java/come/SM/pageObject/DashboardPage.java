package come.SM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SM.utilities.JavaScriptUtil;

public class DashboardPage {

	//1. Creating Public Webdriver
	public WebDriver driver;
	
	//2.Create constructor. 
	public DashboardPage(WebDriver driver) {
		this.driver = driver;//Assigning the driver passed from Test cases to local Webdriver driver.
		PageFactory.initElements(driver,this);
		
	}
		
	//3.Creating locators
	@FindBy(linkText="Dashboard")
	WebElement dashboardlink;
	
	//4.Creating Method
	public String getDashboardLnkTxt() {
	JavaScriptUtil js = new JavaScriptUtil();
	js.flash(dashboardlink, driver);	
	String  val = dashboardlink.getText();	
		
	return val;
	
	}
			
		
}


