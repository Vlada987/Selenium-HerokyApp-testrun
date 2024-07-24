package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RedirectLinkPage extends BaseClass {

	public RedirectLinkPage(WebDriver driver) {
		super(driver);
	}

	public void openRedirectLinkPage() {

		driver.findElement(By.linkText("Redirect Link")).click();
	}

	public void linksTest() throws IOException {

		openRedirectLinkPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("redir"));
		Assert.assertEquals(header, "Redirection");

		linksCheck();
		driver.navigate().back();
	}

	public void linksCheck() throws IOException {

		driver.findElement(By.id("redirect")).click();
		List<String> links = driver.findElements(By.tagName("a")).stream().map(e -> e.getAttribute("href"))
				.collect(Collectors.toList());

		for (String link : links) {
			Assert.assertTrue(!link.isEmpty());
			HttpURLConnection hc = (HttpURLConnection) (new URL(link).openConnection());
			hc.connect();
			Assert.assertTrue(hc.getResponseCode() < 400);
		}
	}

}
