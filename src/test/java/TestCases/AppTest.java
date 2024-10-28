package TestCases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctions.FlightBookingsOrderPage;
import CommonFunctions.FlightReservationPage;
import Utilities.AppUtils;

public class AppTest extends AppUtils{
	
	@Test(priority = 1)
	public void verifyUserPageTest() {
		if(driver.findElement(By.xpath(p.getProperty("objUserDashBoard"))).isDisplayed()) {
			Reporter.log("User Dashboard verified Successfully", true);
		}
	}
	
	@Parameters({"date","from","to", "airlineName", "PassengerName", "FlightClass", "Tickets"})
	@Test(priority = 2)
	public void searchFlightsTest(String date, String from, String to, String airlineName, String PassengerName, String FlightClass, String Tickets) throws Throwable {
		FlightReservationPage sf = PageFactory.initElements(driver, FlightReservationPage.class);
		sf.searchFlightsButton(date, from, to, airlineName);
		sf.orderInformation(PassengerName, FlightClass, Tickets);
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("test-output/ScreenShots/OrderSuccessPage.png");
		FileUtils.copyFile(src, trg);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("objBookingSuccessPage"))));
		
		String successMessage=driver.findElement(By.xpath(p.getProperty("objBookingSuccessMessage"))).getText();
		Reporter.log(successMessage, true);
		
	}
	
	@Parameters({"orderId"})
	@Test(priority = 3)
	public void viewOrderTest(String orderId) throws Throwable {
		FlightBookingsOrderPage fb = PageFactory.initElements(driver, FlightBookingsOrderPage.class);
		fb.viewOrder(orderId);
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("test-output/ScreenShots/ViewOrder.png");
		FileUtils.copyFile(src, trg);
		
		
	}
	
}
