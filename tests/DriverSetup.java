package tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup extends ExtentReport{

	public WebDriver driver;
	static String path = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Selenium_Java_Dinternet\\geckodriver.exe";
	public static String downloadPath="C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Selenium_Java_Dinternet\\target";
	
	public static FirefoxProfile getProfile() {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
	    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/png");
	    profile.setPreference("browser.download.dir",downloadPath);
	    return profile;
	}
	
		
	public static FirefoxOptions getOptions() {

		FirefoxProfile profile=getProfile();
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		option.addArguments("--headless");
		
		return option;
	}

	@BeforeSuite
	public void setupDriver() {

		FirefoxOptions option = getOptions();
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
