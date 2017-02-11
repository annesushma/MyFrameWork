package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLogInPageWithReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		report = new ExtentReports("./reports/LogInPageReports.html", true);
		logger= report.startTest("Verify test LogIn");
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
	}

	@Test
	public void tesLogInPage(){

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTitle();
		System.out.println("The title of the Application is: "+"'"+title+"'");
		Assert.assertTrue(title.contains("My Store"));
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		home.clickSignInLink();
		logger.log(LogStatus.INFO, "Click on Sign In link");
		LogInPage login= PageFactory.initElements(driver, LogInPage.class);
		login.logInApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "LogIn to Application");
		login.verifySignout();
		logger.log(LogStatus.PASS, "Sign Out link appear");
	}
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
