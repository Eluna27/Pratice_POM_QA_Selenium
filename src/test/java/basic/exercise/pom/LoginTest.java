package basic.exercise.pom;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	private WebDriver driver;
	LogInPage logInPage;
	BookStorePage bookStorePage;

	@Before

	public void setUp() throws Exception {
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConection();
		bookStorePage = new BookStorePage(driver);
		driver.manage().window().maximize();
		logInPage.visit("https://demoqa.com/login");
	}

	@Test

	public void test() throws InterruptedException {
		logInPage.logIn();
		Thread.sleep(2000);
		assertEquals("eduardo", logInPage.getUserNameDisplayed());
		Thread.sleep(2000);
		bookStorePage.addBook();
		Thread.sleep(2000);
	
	}

	@After

	public void tearDown() throws InterruptedException {
		driver.close();
		driver.quit();
	}

}
