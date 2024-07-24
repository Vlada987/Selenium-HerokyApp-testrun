package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddRemoveElementsPage extends BaseClass{

public AddRemoveElementsPage(WebDriver driver) {
	super(driver);
}


public void openAddRemoveElPage() {

driver.findElement(By.linkText("Add/Remove Elements")).click();
}

public void AddRemoveElPageTest() {
	
openAddRemoveElPage();
String url=driver.getCurrentUrl();
String header=driver.findElement(By.xpath("//h3")).getText();

Assert.assertTrue(url.contains("add_remove_elements"));
Assert.assertEquals(header, "Add/Remove Elements");

addAndRemoveElements();
driver.navigate().back();
}

public void addAndRemoveElements() {
	
driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));

Assert.assertTrue(deleteButton.isDisplayed());
deleteButton.click();

try {
	Assert.assertTrue(!deleteButton.isDisplayed());
} catch (Exception e) {
	e.printStackTrace();
}

}




}
