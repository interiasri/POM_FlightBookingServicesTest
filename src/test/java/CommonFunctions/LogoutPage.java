package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
//	Define Object Repository
	@FindBy(xpath="//i[contains(@class,'fa-gear')]")
	WebElement objUserSetting;
	
	@FindBy(linkText="Logout")
	WebElement objUserLogout;
	
	
//	Create Method
	public void logoutFeature() {
		objUserSetting.click();
		objUserLogout.click();
	}

}
