package TestCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.AppUtils;

public class VerifyUserDashBoard extends AppUtils{
	
	@Test
	public void verifyUserPage() {
		if(driver.findElement(By.xpath(p.getProperty("objUserDashBoard"))).isDisplayed()) {
			Reporter.log("User Dashboard verified Successfully", true);
		}
	}

}
