package pages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public void takeScreenshot(WebElement el) throws WebDriverException, IOException {

		try {
			String path = "C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Selenium_Java_Dinternet\\target\\myImg";
			TakesScreenshot ts = (TakesScreenshot) driver;
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(path));
		} catch (WebDriverException e) {
			System.out.println("unable to make Screenshot");
		}

	}

}
