package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	
	@FindBy(css="input#loginusername")
	static WebElement userName;
	
	@FindBy(id="loginpassword")
	static WebElement password;
	
	@FindBy(xpath="//div[@id='logInModal']/descendant::button[text()='Close']")
	static WebElement closeBtn;
	
	@FindBy(xpath="//button[text()='Log in']")
	static WebElement loginBtn;
	
	public LoginPage(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public static void setUserName(String user) {
		userName.clear();
		userName.sendKeys(user);
		
	}
	
	public static void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public static void clickLogin() {
		loginBtn.click();
	}
	
}
