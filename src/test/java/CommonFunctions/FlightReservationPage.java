package CommonFunctions;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Utilities.AppUtils;

public class FlightReservationPage extends AppUtils{
	
//	Object Repository
	@FindBy(id="search-date")
	WebElement objSearchDate;
	
	@FindBy(xpath="//select[contains(@class,'sf2')]")
	WebElement objSelectFrom;
	
	@FindBy(xpath="//select[contains(@class,'sf3')]")
	WebElement objSelectTo;
	
	@FindBy(xpath="//button[contains(@class,'btn-search')]")
	WebElement objSearchFlights;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement objFlightSearchResultsClose;
	
	@FindBy(xpath="//table[@class='flights_table']")
	WebElement objFlightTable;
	
	@FindBy(xpath="//p[@class='no_flights']")
	WebElement objNoflights;
	
	@FindBy (id="name")
	WebElement objPassengerName;
	
	@FindBy(xpath="//input[@type='radio' and @value='First Class']")
	WebElement objFlightFirstClass;
	
	@FindBy(xpath="//input[@type='radio' and @value='Business']")
	WebElement objFlightBusinessClass;
	
	@FindBy(xpath="//input[@type='radio' and @value='Economy']")
	WebElement objFlightEconomyClass;
	
	@FindBy(id="tickets")
	WebElement objEnterTickets;
	
	@FindBy(xpath="//button[contains(@class,'insert-order')]")
	WebElement objInsertOrder;
	
//	Search And Select Flight or Airline
	public void searchFlightsButton(String date, String from, String to, String airlineName) throws Throwable {
		objSearchDate.sendKeys(date);
		
		Select FlightsFrom = new Select(objSelectFrom);
		FlightsFrom.selectByVisibleText(from);
		
		Select flightTo = new Select(objSelectTo);
		flightTo.selectByVisibleText(to);
		
		objSearchFlights.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(objFlightSearchResultsClose));
		
		boolean isFlightSelected = false;
		if(objFlightTable.isDisplayed()) {
			Reporter.log("Flight Table Displayed", true);
			WebElement ftableBody;
			List<WebElement> trows;
			List<WebElement> tcols;
			String fname;
			try {
				ftableBody=objFlightTable.findElement(By.tagName("tbody"));
				trows=ftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					fname=tcols.get(0).getText();
					if(fname.equalsIgnoreCase(airlineName)) {
						tcols.get(8).click();
						Thread.sleep(2000);
						isFlightSelected = true;
						break;
					}
				}
				if(isFlightSelected== true) {
					Reporter.log("Flight Available & Selected", true);
				}
				else {
					Reporter.log("Flight Not available", true);
					objFlightSearchResultsClose.click();
				}
				
			} catch (Exception e) {
				ftableBody=objFlightTable.findElement(By.tagName("tbody"));
				trows=ftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					fname=tcols.get(0).getText();
					if(fname.equalsIgnoreCase(airlineName)) {
						tcols.get(8).click();
						Thread.sleep(2000);
						isFlightSelected = true;
						break;
					}
				}
				if(isFlightSelected==true) {
					Reporter.log("Flight Available & Selected", true);
				}
				else {
					Reporter.log("Flight Not available", true);
					objFlightSearchResultsClose.click();
				}
			}
			
		}
		else {
			Reporter.log("Flight Table Not Displayed", true);
			Reporter.log(objNoflights.getText());
			objFlightSearchResultsClose.click();
		}
	}
	
//	Fill Order Information
	public void orderInformation(String PassengerName, String FlightClass, String Tickets) throws Throwable {
		
		objPassengerName.sendKeys(PassengerName);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("objFlightFirstClass"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("objFlightBusinessClass"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("objFlightEconomyClass"))));
		if(FlightClass.equalsIgnoreCase("First Class")) {
			objFlightFirstClass.click();
		}
		else if(FlightClass.equalsIgnoreCase("Business")) {
			objFlightBusinessClass.click();
		}
		else {
			objFlightEconomyClass.click();
		}
		
		objEnterTickets.clear();
		objEnterTickets.sendKeys(Tickets);
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("test-output/ScreenShots/ReviewOrder.png");
		FileUtils.copyFile(src, trg);
		
		objInsertOrder.click();
		
	}

}
