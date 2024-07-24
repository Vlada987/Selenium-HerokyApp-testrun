package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploadPage extends BaseClass {

	public FileUploadPage(WebDriver driver) {
		super(driver);

	}

	public void openFileUploadPage() {

		driver.findElement(By.linkText("File Upload")).click();
	}

	public void fileUploadTest() throws AWTException {

		openFileUploadPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("upload"));
		Assert.assertEquals(header, "File Uploader");

		uploadFile();
		String header2 = driver.findElement(By.xpath("//h3")).getText();
		String uplFileName = driver.findElement(By.id("uploaded-files")).getText();

		Assert.assertEquals(uplFileName, "sample.txt");
		Assert.assertEquals(header2, "File Uploaded!");

		driver.navigate().back();
	}

	public void uploadFile() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(777);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(777);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.delay(777);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(777);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(777);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(999);
	}

}
