package basic.exercise.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/selenium_driver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void visit(String url) {
		driver.get(url);
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// this function is for wait load page
	public void WaitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);

	}

	// this function is for do scroll in the page
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");
	}

	// this function is for accept alert in the page
	public void AcceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
}
