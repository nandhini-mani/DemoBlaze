package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.ExcelLibrary;

public class SignUp {
	public static WebDriver driver;
	
	@FindBy(css="h5#signInModalLabel")
	WebElement signInOverlay;
	
	@FindBy(css="input#sign-username")
	WebElement userName;
	
	@FindBy(id="sign-password")
	WebElement password;
	
	@FindBy(xpath="//div[@id='signInModal']/descendant::button[text()='Close']")
	WebElement closeBtn;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signUpBtn;
	
	public SignUp(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public void signInModal() {
		if(signInOverlay.isEnabled() || signInOverlay.isDisplayed()) {
			System.out.println("Sign In modal is displayed");
		}
	}
	
	public void setUserName(String user) {
		userName.clear();
		userName.sendKeys(user);
		
	}
	
	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickSignUp() {
		signUpBtn.click();
	}
	
	public void signUp() throws IOException {
		//Get Username and password from Excel Sheet
		String user = ExcelLibrary.getExcelData("Sheet1", 1, 0);
		String pass = ExcelLibrary.getExcelData("Sheet1", 1, 1);
		//Enter Username
		userName.clear();
		userName.sendKeys(user);
		//Enter Password
		password.clear();
		password.sendKeys(pass);
		//Click on Sign Up Button
		signUpBtn.click();
	}

}
