package CommonFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import Utilities.AppUtils;

public class FlightBookingsOrderPage extends AppUtils{
	@FindBy(linkText="Flight Bookings")
	WebElement objFlightBookings;
	
	@FindBy(xpath ="//h2[normalize-space()='Orders']")
	WebElement objorderPage;
	
	@FindBy(className="flights_table")
	WebElement objFlightBookingsOrdersTable;
	
//	View Order
	public void viewOrder(String orderId) throws Throwable {
		objFlightBookings.click();
		WebElement WebEleftableBody;
		List<WebElement> trows;
		List<WebElement> tcols;
		String ActualOrderId;
		boolean isViewPageDisplayed = false;
		if(objorderPage.isDisplayed()) {
			try {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("View")).click();
						Thread.sleep(3000);
						isViewPageDisplayed = true;
						break;
					}
				}
				if(isViewPageDisplayed== true) {
					Reporter.log("View Page Displayed", true);
				}
				else {
					Reporter.log("View Page Not Displayed", true);
				}
				
			} catch (Exception e) {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("View")).click();
						Thread.sleep(3000);
						isViewPageDisplayed = true;
						break;
					}
				}
				if(isViewPageDisplayed== true) {
					Reporter.log("View Page Displayed", true);
				}
				else {
					Reporter.log("View Page Not Displayed", true);
				}
			}
		}
		else {
			Reporter.log("Flight Bookings Order Page Not Displayed", true);
		}
	}
	
//	Edit Order
	public void editOrder(String orderId) throws Throwable {
		objFlightBookings.click();
		WebElement WebEleftableBody;
		List<WebElement> trows;
		List<WebElement> tcols;
		String ActualOrderId;
		boolean isEditPageDisplayed = false;
		if(objorderPage.isDisplayed()) {
			try {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("Edit")).click();
						Thread.sleep(3000);
						isEditPageDisplayed = true;
						break;
					}
				}
				if(isEditPageDisplayed== true) {
					Reporter.log("Edit Page Displayed", true);
				}
				else {
					Reporter.log("Edit Page Not Displayed", true);
				}
				
			} catch (Exception e) {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("Edit")).click();
						Thread.sleep(3000);
						isEditPageDisplayed = true;
						break;
					}
				}
				if(isEditPageDisplayed== true) {
					Reporter.log("Edit Page Displayed", true);
				}
				else {
					Reporter.log("Edit Page Not Displayed", true);
				}
			}
		}
		else {
			Reporter.log("Flight Bookings Order Page Not Displayed", true);
		}
		
	}
	
//	Delete Order
	public void deleteOrder(String orderId) throws Throwable {
		objFlightBookings.click();
		WebElement WebEleftableBody;
		List<WebElement> trows;
		List<WebElement> tcols;
		String ActualOrderId;
		boolean isAlertPageDisplayed = false;
		if(objorderPage.isDisplayed()) {
			try {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("Delete")).click();
						Thread.sleep(3000);
						isAlertPageDisplayed = true;
						break;
					}
				}
				if(isAlertPageDisplayed== true) {
					Reporter.log("Alert Displayed", true);
					driver.switchTo().alert().accept();
				}
				else {
					Reporter.log("Alert Not Displayed", true);
				}
				
			} catch (Exception e) {
				WebEleftableBody=objFlightBookingsOrdersTable.findElement(By.tagName("tbody"));
				trows=WebEleftableBody.findElements(By.tagName("tr"));
				for(int i=1; i<trows.size(); i++) {
					tcols=trows.get(i).findElements(By.tagName("td"));
					ActualOrderId=tcols.get(0).getText();
					if(ActualOrderId.equalsIgnoreCase(orderId)) {
						tcols.get(9).findElement(By.linkText("Delete")).click();
						Thread.sleep(3000);
						isAlertPageDisplayed = true;
						break;
					}
				}
				if(isAlertPageDisplayed== true) {
					Reporter.log("Alert Displayed", true);
					driver.switchTo().alert().accept();
				}
				else {
					Reporter.log("Alert Not Displayed", true);
				}
			}
		}
		else {
			Reporter.log("Flight Bookings Order Page Not Displayed", true);
		}
		
	}

}
