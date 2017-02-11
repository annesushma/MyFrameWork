package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {
	WebDriver driver;
	public LogInPage(WebDriver ldriver){
		this.driver=ldriver;
	}

	@FindBy(xpath="//input[@id='email']") WebElement username;
	@FindBy(xpath="//input[@id='passwd']") WebElement password;
	@FindBy(id="SubmitLogin") WebElement btnSubmit;

	By signout=By.xpath("//a[@class='logout']");

	public void logInApplication(String name, String pwd){
		username.sendKeys(name);
		password.sendKeys(pwd);
		btnSubmit.click();
	}

	public void verifySignout(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text=ele.getText();
		Assert.assertEquals(text, "Sign out","Sign out link not verified properly");
	}

}




