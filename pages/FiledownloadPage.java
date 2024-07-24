package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import tests.DriverSetup;

public class FiledownloadPage extends BaseClass {

	public FiledownloadPage(WebDriver driver) {
		super(driver);
	}

	public void openDownloadPage() {

		driver.findElement(By.linkText("File Download")).click();
	}

	public void downloadFileTest() throws InterruptedException {

		openDownloadPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("download"));
		Assert.assertEquals(header, "File Downloader");

		downloadFileAndCheck();
		driver.navigate().back();

	}

	public void downloadFileAndCheck() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//a[2]"));
		String fileName = element.getText();
		element.click();
		Thread.sleep(6000);

		File file = new File(DriverSetup.downloadPath + "/" + fileName);
		Assert.assertEquals(file.exists(), true);
		Assert.assertEquals(fileName, file.getName());

	}

}
