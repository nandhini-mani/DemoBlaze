package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {
	public static WebDriver driver = null;
	/**
	 * Description : To initialize and setup the browser. 
	 * Maximize the browser and add implicit wait for the driver
	 * Author : Nandhini Mani
	 * Date Created : 21st July 2024
	 * @return returns the WebDriver
	 */
	public static WebDriver getBrowser() {
		
		if(Constants.browser.equalsIgnoreCase("firefox")) {
			//Configuration setup for Firefox Driver
			WebDriverManager.firefoxdriver().setup();
			//Launch the light and empty browser
			driver= new FirefoxDriver();
		}else if (Constants.browser.equalsIgnoreCase("chrome")) {
			//Configuration setup for Chrome Driver
			WebDriverManager.chromedriver().setup();
			//Launch the light and empty browser
			driver = new ChromeDriver();
		}if(Constants.browser.equalsIgnoreCase("Edge")) {
			//Configuration setup for Edge Driver
			WebDriverManager.edgedriver().setup();
			//Launch the light and empty browser
			driver = new EdgeDriver();
		}
		//Maximize the browser
		driver.manage().window().maximize();
		//Implicitly wait statement
		WebLibrary.waitForPageLoad();
		
		//return the initialized driver
		return driver;
		
	}
	

}
