package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasicAuthPage extends BaseClass {

	public BasicAuthPage(WebDriver driver) {
		super(driver);

	}

	public void openAuthAllert() {

		driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[3]/a")).click();
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void loginAlertFailed() throws InterruptedException {

		openAuthAllert();
		Alert a = driver.switchTo().alert();
		a.dismiss();

		String notAuth = driver.findElement(By.xpath("/html/body")).getText();
		Assert.assertEquals(notAuth, "Not authorized");
		driver.navigate().back();
	}

	public void loginAlertSucsses() throws InterruptedException, AWTException {

		openAuthAllert();
		sendTextForLogin();
		tabPress();
		sendTextForLogin();
		enterPress();
		Thread.sleep(2000);
		String authSucsses = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();
		Assert.assertTrue(authSucsses.contains("Congratulations!"));
		driver.navigate().back();
	}

	public void sendTextForLogin() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
	}

	public void tabPress() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public void enterPress() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

}
