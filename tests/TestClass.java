package tests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AB_TestingPage;
import pages.AddRemoveElementsPage;
import pages.BasicAuthPage;
import pages.BrokenImagesPage;
import pages.DropdownPage;
import pages.FileUploadPage;
import pages.FiledownloadPage;
import pages.FormAuthentificationPage;
import pages.HomePage;
import pages.JSAlertsPage;
import pages.RedirectLinkPage;

public class TestClass extends DriverSetup {

	HomePage hp;

	@BeforeTest
	public void openPageBefore() {

		hp = new HomePage(driver);
		hp.openPage();
	}

	@Test(priority = 1)
	public void test00_HomePage() {

		hp = new HomePage(driver);
		hp.homePageTest();
	}

	@Test(priority = 2)
	public void test01_AB_Testing() throws InterruptedException {

		AB_TestingPage page = new AB_TestingPage(driver);
		page.abTestingPageTest();
	}

	@Test(priority = 3)
	public void test02_Add_RemoveElementTest() {

		AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
		page.AddRemoveElPageTest();

	}

	@Test(priority = 4)
	public void test03_BasicAlertAuth() throws InterruptedException, AWTException {

		BasicAuthPage page = new BasicAuthPage(driver);
		page.loginAlertFailed();
		page.loginAlertSucsses();
	}

	@Test(priority = 5)
	public void test04_BrokenImages() throws WebDriverException, IOException {

		BrokenImagesPage page = new BrokenImagesPage(driver);
		page.brokenImagesPageTest();

	}

	@Test(priority = 6)
	public void test05_Dropdown() {

		DropdownPage page = new DropdownPage(driver);
		page.dropdownTest();

	}

	@Test(priority = 7)
	public void test06_fileUpload() throws AWTException {

		FileUploadPage page = new FileUploadPage(driver);
		page.fileUploadTest();
	}

	@Test(priority = 8)
	public void test07_loginForm() {

		FormAuthentificationPage page = new FormAuthentificationPage(driver);
		page.formAuthTest();
	}

	@Test(priority = 9)
	public void test08_downloadFile() throws InterruptedException {

		FiledownloadPage page = new FiledownloadPage(driver);
		page.downloadFileTest();
	}

	@Test(priority = 10)
	public void test09_JSAlerts() {

		JSAlertsPage page = new JSAlertsPage(driver);
		page.jsAlertsTest();
	}

	@Test(priority = 11)
	public void test10_BrokenLinks() throws IOException {

		RedirectLinkPage page = new RedirectLinkPage(driver);
		page.linksTest();
	}

}
