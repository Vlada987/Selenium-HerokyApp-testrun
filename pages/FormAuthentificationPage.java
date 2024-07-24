package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FormAuthentificationPage extends BaseClass {

	public FormAuthentificationPage(WebDriver driver) {
		super(driver);

	}

	public void openFormAuthPage() {

		driver.findElement(By.linkText("Form Authentication")).click();
	}

	public void formAuthTest() {

		openFormAuthPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h2")).getText();

		Assert.assertTrue(url.contains("login"));
		Assert.assertEquals(header, "Login Page");

		login("xxxxx", "xxxxx");
		String loginFailMsg = driver.findElement(By.id("flash")).getText();

		Assert.assertTrue(loginFailMsg.contains("username is invalid!"));

		login("tomsmith", "SuperSecretPassword!");
		String loginSucess = driver.findElement(By.id("flash")).getText();

		Assert.assertTrue(loginSucess.contains("You logged into a secure area!"));

		driver.findElement(By.xpath("/html/body/div[2]/div/div/a/i")).click();
		driver.navigate().back();
	}

	public void login(String uname, String pwd) {

		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

	}

}
