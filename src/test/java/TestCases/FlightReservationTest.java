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

import CommonFunctions.FlightReservationPage;
import Utilities.AppUtils;

public class FlightReservationTest extends AppUtils{
	
	@Parameters({"date","from","to", "airlineName", "PassengerName", "FlightClass", "Tickets"})
	@Test
	public void searchFlights(String date, String from, String to, String airlineName, String PassengerName, String FlightClass, String Tickets) throws Throwable {
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

}
