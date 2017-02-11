package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLogInPage {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void tesLogInPage(){

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTitle();
		System.out.println("The title of the Application is: "+"'"+title+"'");
		Assert.assertTrue(title.contains("My Store"));
		home.clickSignInLink();
		LogInPage login= PageFactory.initElements(driver, LogInPage.class);
		login.logInApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		login.verifySignout();
	}
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
