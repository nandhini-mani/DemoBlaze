package testNGScripts;

import org.testng.annotations.Test;

import generic.Constants;
import generic.Drivers;
import generic.ExcelLibrary;
import generic.WebLibrary;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUp;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

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
import org.testng.annotations.AfterTest;

public class DemoBlazeTest {
	static WebDriver driver;
	Actions act;
	public String expectedTitle = "STORE";
  @Test
  public void googleSearch() {
	  
	  driver.get(Constants.googleUrl);
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
		
		String actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title matches - DemoBlaze Home page is displayed");
		}else {
			System.out.println("Title mismatch- DemoBlaze Home page is not displayed");
		}
		Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  
  @Test
  public void verifyGreetings() throws IOException {
	  driver.get(Constants.googleUrl);
	  WebElement search =driver.findElement(By.xpath("//textarea[@title='Search']"));
		search.clear();
		search.sendKeys(Constants.appUrl);
		
		act=new Actions(driver);
		act.keyDown(Keys.ENTER).build().perform();
		WebLibrary.clickOnVisibleElement(By.xpath("//a[@href='https://www.demoblaze.com/']"));
		//Click on Login
				HomePage hp = new HomePage(driver);
				hp.clickLogin();
				
				LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				//Enter Login details
				String user=ExcelLibrary.getExcelData("Sheet1", 1, 0);
				LoginPage.setUserName(user);
				LoginPage.setPassword(ExcelLibrary.getExcelData("Sheet1", 1, 1));
				LoginPage.clickLogin();
				HomePage.welcomeUser(user);
			    
  }
  
  @Test
  public void signUp() {
	  driver.get(Constants.appUrl);
	  HomePage hp = PageFactory.initElements(driver,HomePage.class);
	  HomePage.clickSignUp();
	   SignUp sign = new SignUp(driver);
	   sign.signInModal();
  }
  
  @Test
  public void signInSuccess() {
	  driver.get(Constants.appUrl);
	  HomePage hp = PageFactory.initElements(driver,HomePage.class);
	  HomePage.clickSignUp();
	   SignUp sign = new SignUp(driver);
	   sign.signInModal();
		SignUp signin = new SignUp(driver);
		signin.setUserName("m11a22");
		signin.setPassword("mama123456789");
		signin.clickSignUp();
		 //WAIT UNTIL ALERT OPENS AND THEN CLICK ON OK/ACCEPT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text : "+alert.getText());
		alert.accept();
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = Drivers.getBrowser();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
