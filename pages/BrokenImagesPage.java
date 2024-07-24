package pages;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenImagesPage extends BaseClass {

	public BrokenImagesPage(WebDriver driver) {
		super(driver);
	}

	public void openImagesPage() {

		driver.findElement(By.linkText("Broken Images")).click();
	}

	public void brokenImagesPageTest() throws WebDriverException, IOException {

		openImagesPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("broken_images"));
		Assert.assertEquals(header, "Broken Images");
		checkImagesOnPage();
		driver.navigate().back();
	}

	public void checkImagesOnPage() throws WebDriverException, IOException {

		List<WebElement> brokenImg = driver.findElements(By.xpath("//img"));
		for (WebElement e : brokenImg) {
			System.out.println(e.getAttribute("naturalWidth"));
		}

		SoftAssert softAssert = new SoftAssert();
		WebElement content = driver.findElement(By.id("content"));
		List<WebElement> brokenImgs = driver.findElements(By.xpath("//img")).stream()
				.filter(i -> i.getAttribute("naturalWidth").equals("0")).collect(Collectors.toList());

		softAssert.assertTrue(brokenImgs.size() == 0);
		softAssert.assertAll();
		if (brokenImgs.size() > 0) {
			takeScreenshot(content);
		}

	}

}
