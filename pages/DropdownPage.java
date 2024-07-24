package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BaseClass {

	public DropdownPage(WebDriver driver) {
		super(driver);

	}

	public void openDropdownPage() {

		driver.findElement(By.linkText("dropdown")).click();

	}

	public void dropdownTest() {

		openDropdownPage();
		String url = driver.getCurrentUrl();
		String header = driver.findElement(By.xpath("//h3")).getText();

		Assert.assertTrue(url.contains("dropdown"));
		Assert.assertEquals(header, "Dropdown List");
		dropdownSelect();
		driver.navigate().back();
	}

	public void dropdownSelect() {

		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByValue("Option 1");
		String selected = select.getFirstSelectedOption().getText();

		Assert.assertEquals(selected, "Option 1");

		select.selectByValue("Option 2");
		String selected2 = select.getFirstSelectedOption().getText();

		Assert.assertEquals(selected2, "Option 2");
	}

}
