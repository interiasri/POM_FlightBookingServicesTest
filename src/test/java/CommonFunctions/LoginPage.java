package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
//	Define repository
	@FindBy(name="email")
	WebElement objUserId;
	
	@FindBy(name="password")
	WebElement objPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement objSignIn;

//	Create Method
	public void loginFeature(String userId, String Password) {
		objUserId.sendKeys(userId);
		objPassword.sendKeys(Password);
		objSignIn.click();
	}
	
}
