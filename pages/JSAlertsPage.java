package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JSAlertsPage extends BaseClass {

	public JSAlertsPage(WebDriver driver) {
		super(driver);

	}

	public void openJSAlertsPage() {

		driver.findElement(By.linkText("JavaScript Alerts")).click();
	}

	public void jsAlertsTest() {

		openJSAlertsPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("alerts"));
		Assert.assertEquals(header, "JavaScript Alerts");

		simpleAlert();
		confirmAlert();
		promptAlert();
		driver.navigate().back();
	}

	public void simpleAlert() {

		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert a = driver.switchTo().alert();

		Assert.assertEquals(a.getText(), "I am a JS Alert");
		a.accept();
	}

	public void confirmAlert() {

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert a = driver.switchTo().alert();

		Assert.assertEquals(a.getText(), "I am a JS Confirm");
		a.accept();
	}

	public void promptAlert() {

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert a = driver.switchTo().alert();
		a.sendKeys("test5678test");
		a.accept();

		String text = driver.findElement(By.id("result")).getText();
		Assert.assertTrue(text.contains("test5678test"));

	}

}
