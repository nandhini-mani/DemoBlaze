package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLibrary extends Drivers{
	public static Actions action;
	
	/**
	 * Description : This method is used to wait for the entire page to load and 
	 * also to locate every WebElement it waits for mentioned duration before throwing exception.
	 * <p>Implicit wait statement waits for specified amount of time
	 * <p>It polls over the web page download and checks it in regular interval of 500ms
	 * Author : Nandhini Mani
	 * Date created : 21st july 2024
	 */
	public static void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}	
	/**
	 * Description : This method is used to wait for the element to be clicked is visible and enabled
	 * <p> If the element is displayed it moves to the element and performs the click
	 * <p> It takes By type as parameter
	 * @param by
	 */
	public static void clickOnVisibleElement(By by) {
		//Wait for WebElement that you have to click is visible
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
		//Retrieve the WebElement using provided locator
		WebElement element = driver.findElement(by);
		
		if(driver!=null && element!=null && element.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			//Move to element and click the element
			action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		}else {
			System.out.println("Either driver or element is null or Element is not displayed");
		}			
	}
	/**
	 * Description : This method is used to wait for the element to be clicked is visible and enabled
	 * <p> If the element is displayed it moves to the element and performs the click
	 * <p>It takes WebElement as parameter
	 * @param element
	 */
	public static void clickOnVisibleElement(WebElement element) {
		//Wait for WebElement that you have to click is visible
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				
		if(driver!=null && element!=null && element.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			//Move to element and click the element
			action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		}else {
			System.out.println("Either driver or element is null or Element is not displayed");
		}			
	}
}
