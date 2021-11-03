package come.SM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SM.utilities.JavaScriptUtil;

public class LoginPage {
	
	//1.Create Public Webdirver
	public WebDriver driver;
	
	//2.Create consturctor 
	public LoginPage(WebDriver driver) {
		this.driver = driver;//Assigning the driver passed from Test cases to local Webdriver driver.
		PageFactory.initElements(driver,this);
	}
	
	//3.Create Locators
		//3.1for username
		@FindBy(id="username")//When you use pagefactory you can use this method.
		WebElement txtUsername;//txtUsername is variable. 
	
		//3.2Create Locator for Password
		@FindBy(id="password")//This entry replace the driver.findElement......
		WebElement txtPassword;//
	
		//3.3 Create Locator for Login Button
		@FindBy(xpath="//button[@type='submit']")
		WebElement btnLogin;
		
		//3.4 Create Locator for SignUp
		@FindBy(linkText="Sign Up")
		WebElement linkText;
		
		@FindBy(linkText="Office Locations")
		WebElement linkOffice;
		
	//4.Create Method 
		//4.1 to enter Username
	
			public void setUsername(String uname) {
			JavaScriptUtil js = new JavaScriptUtil();
			js.flash(txtUsername, driver);
			txtUsername.clear();
			txtUsername.sendKeys(uname);
		
			//above is otherway you can use the method
	
	}
	
		//4.2. Method to enter Password
	
			public void setPassword(String pwd) {
			JavaScriptUtil js = new JavaScriptUtil();
			js.flash(txtPassword, driver);	
			txtPassword.clear();
			txtPassword.sendKeys(pwd);
	}
	
		//4.3. Method to click on login button
	
			public void clickLoginbutton() {
			JavaScriptUtil js = new JavaScriptUtil();
			js.flash(btnLogin, driver);		
			btnLogin.click();
				
	}
			
		//4.4 Method to click on Sing Up
			
			public boolean checkSignUpLink() {
			JavaScriptUtil js = new JavaScriptUtil();
			js.flash(linkText, driver);		
			return linkText.isDisplayed();	
				
			}
	
	///Above all steps are not test case...they prepared to execute test cases////
	
	
			public boolean checkOfficeLink() {
			JavaScriptUtil js = new JavaScriptUtil();
			js.scrollPageDown(driver);
			js.flash(linkOffice, driver);	
			return linkOffice.isDisplayed();	
					
			}

}
