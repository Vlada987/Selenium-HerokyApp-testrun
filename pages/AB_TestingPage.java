package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AB_TestingPage extends BaseClass {

	public AB_TestingPage(WebDriver driver) {
		super(driver);

	}

	public void openABTestingPage() {

		driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[1]/a")).click();
	}

	public void abTestingPageTest() throws InterruptedException {

		openABTestingPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("abtest"));
		Assert.assertTrue(header.contains("A/B Test"));
//******Check redirect URL **********
		redirectUrlCheck();
		driver.navigate().back();

	}

	public void redirectUrlCheck() throws InterruptedException {

		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();

		Assert.assertTrue(url.contains("selenium"));
		Assert.assertTrue(title.contains("Selenium"));
		driver.close();
		driver.switchTo().window(mainWindow);
	}

}
