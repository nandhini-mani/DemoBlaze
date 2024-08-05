package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
	@FindBy(xpath="//a[contains(@href,'index')]//parent::li")
	WebElement home;
	
	@FindBy(css="a[data-target^='#example']")
	WebElement contact;
	
	@FindBy(xpath="//a[starts-with(@data-target,'#video')]")
	WebElement aboutUs;
	
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(css="a#login2")
	static WebElement login;
	
	@FindBy(id="logout2")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	static WebElement welcome;
	
	@FindBy(id="signin2")
	static WebElement signUp;
	
	public HomePage(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public void clickHome() {
		home.click();
	}
	
	public void clickContact() {
		contact.click();
	}
	
	public void clickAbout() {
		aboutUs.click();
	}
	
	public void clickCart() {
		cart.click();
	}
	
	public static void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public static void welcomeUser(String user) {
		boolean message =welcome.isEnabled();
		System.out.println("Message :"+message);
		System.out.println(welcome.getText());
		if(message) {
			System.out.println("Greeting message displayed : "+(welcome.getText()));
			if(welcome.getText().contains(user) && welcome.getText().contains("Welcome")) {
				System.out.println("Greeting present with correct username");
			}
		}else {
			System.out.println("Greetings not displayed");
		}
		
	}
	
	public static void clickSignUp() {
		signUp.click();
	}
}
