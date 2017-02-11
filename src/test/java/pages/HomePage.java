package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {


	WebDriver driver;

	public HomePage(WebDriver ldriver){
		this.driver= ldriver;
	}
	@FindBy(xpath="//a[@class='home']") WebElement homeLink;
	@FindBy(xpath="//a[@class='login']") WebElement signInLink;
	@FindBy(xpath="//input[@id='search_query_top']") WebElement Searchbx;
	

	public void clickSignInLink()
	{
		signInLink.click();
	}
	public String getApplicationTitle(){
		return driver.getTitle();
		
	}

}
