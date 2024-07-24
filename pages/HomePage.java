package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public void openPage() {

		driver.get("https://the-internet.herokuapp.com/");

	}

	public void homePageTest() {

		try {
			String title = driver.getTitle();
			String header = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();

			Assert.assertEquals(title, "The Internet");
			Assert.assertTrue(header.contains("Welcome "));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
