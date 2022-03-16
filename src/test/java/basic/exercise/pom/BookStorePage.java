package basic.exercise.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends Base {
	By goToStoreBtnLocator = By.xpath("//button[@id='gotoStore']");
	By linkBookName = By.id("google_esf");
	By linkTextBookName = By.linkText("Git Pocket Guide");
	By addStoreBtnBook = By.xpath("(//button[@id='addNewRecordButton'])[2]");
	By deleteAllBtnBooks = By.xpath("(//button[text()='Delete All Books'])[1]");
	By modalBtnAccept = By.id("closeSmallModal-ok");

	public BookStorePage(WebDriver driver) {
		super(driver);
	}

	public void addBook() throws InterruptedException {
		// Wait that the page load
		WaitForLoad();
		// Wait 2 seconds
		Thread.sleep(2000);

		// Go to Book Store Page
		scroll(); // Scroll in the page
		Thread.sleep(2000);
		click(goToStoreBtnLocator);
		Thread.sleep(2000);

		// select a Book with the link text
		WaitForLoad();
		Thread.sleep(2000);
		click(linkTextBookName);

		// add book
		scroll();// scroll in the page
		WaitForLoad();
		Thread.sleep(2000);
		click(addStoreBtnBook);
		Thread.sleep(2000);

		// Accept add book in the alert
		AcceptAlert();

		// Go to profile page
		visit("https://demoqa.com/profile");
		WaitForLoad();
		Thread.sleep(2000);
		scroll();// scroll in the page
		
		
		//Clear table // delete all books
		click(deleteAllBtnBooks);
		Thread.sleep(2000);
		//Click in the modal displayed
		click(modalBtnAccept);
		Thread.sleep(2000);
		
		// Accept add book in the alert
		AcceptAlert();
		Thread.sleep(2000);

	}
	

}
