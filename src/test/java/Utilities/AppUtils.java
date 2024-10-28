package Utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import CommonFunctions.LoginPage;
import CommonFunctions.LogoutPage;

public class AppUtils {
	
	public static WebDriver driver;
	public static Properties p;
	
	@BeforeSuite
	public void launchBrowser() throws Throwable{
		p= new Properties();
		p.load(new FileInputStream("PropertiesFile/OR.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({"UserName", "Password"})
	@BeforeMethod
	public void login(String UserName, String Password) {
		driver.get(p.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("objUserId"))));
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginFeature(UserName, Password);
	}
	
	
	@AfterMethod
	public void logout() {
		LogoutPage lo = PageFactory.initElements(driver, LogoutPage.class);
		lo.logoutFeature();
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
