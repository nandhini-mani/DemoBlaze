package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.Constants;
import generic.Drivers;
import generic.WebLibrary;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUp;


public class Steps {
	public static WebDriver driver = null;
	public static Actions act ;
	public String expectedTitle = "STORE";
	@Given("User is on WebBrowser")
	public void launchBrowser() {
		driver =Drivers.getBrowser();
	}

	@When("User launches Google Home page")
	public void launch_google_home_page() {
		driver.get(Constants.googleUrl);
	}

	@When("User enters the Demo_blaze url and Clicks on DemoBlaze URL from search result")
	public void enterDemo_blaze_url() {
		WebElement search =driver.findElement(By.xpath("//textarea[@title='Search']"));
		search.clear();
		search.sendKeys(Constants.appUrl);
		
		act=new Actions(driver);
		act.keyDown(Keys.ENTER).build().perform();
		WebElement topSearchResult = driver.findElement(By.xpath("//div[@id='rso']/descendant::div[@class='MjjYud'][1]"));
		if(topSearchResult.getText().contains("https://www.demoblaze.com")) {
			System.out.println("Demoblaze site present in top most search result");
		}else {
			System.out.println("Demo blaze site not present in top most search result");
		}
		WebLibrary.clickOnVisibleElement(By.xpath("//a[@href='https://www.demoblaze.com/']"));
	}


	
	@Given("User clicks on Login")
	public void user_clicks_on_login() {
		//Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
	}

	@When("User enters valid (.+) and (.+)$")
	public void user_enters_valid_login_credentials(String user,String pass) {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		//Enter Login details
		LoginPage.setUserName(user);
		LoginPage.setPassword(pass);
		LoginPage.clickLogin();
	}

	@Then("Greetings message displayed with (.+)$")
	public void greetings_message_displayed_with_username(String user) {
		HomePage.welcomeUser(user);
	    
	}



	@Then("User should navigate to DemoBlazeHome page")
	public void validate_the_demo_blaze_website_from_the_search_result() {

		String actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title matches - DemoBlaze Home page is displayed");
		}else {
			System.out.println("Title mismatch- DemoBlaze Home page is not displayed");
		}
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("User launches DemoBlaze Home page")
	public void user_launches_demo_blaze_home_page() {
		driver.get(Constants.appUrl);
	}

	@When("Click on Sign Up")
	public void click_on_sign_up() {
		HomePage hp = PageFactory.initElements(driver,HomePage.class);
		HomePage.clickSignUp();
	}

	@Then("Sign Up page should open")
	public void sign_up_page_should_open() {
	   SignUp sign = new SignUp(driver);
	   sign.signInModal();
	}
	
	@When("Enter the details and click on sign in")
	public void enter_the_details_and_click_on_sign_in() {
		SignUp signin = new SignUp(driver);
		signin.setUserName("m11a22");
		signin.setPassword("mama123456789");
		signin.clickSignUp();
		
		
		
	}

	@Then("Sign in should be successful")
	public void sign_in_should_be_successful() {
		 //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text : "+alert.getText());
		alert.accept();
		
		
	}


}
