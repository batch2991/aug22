package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends Base
{
	By searchtxt=By.xpath("//input[@placeholder='Search for anything']");
	By searchbtn=By.xpath("//input[@value='Search']");

	public void validateTitle()
	{
		String title=driver.getTitle();
		test=report.createTest("validate Title");
		if(title.contains("Electronics, Cars"))
		{
			//Reporter.log("<font color='green'><b>Title is correct after open ebay</b></font>");
			test.log(Status.PASS, "The title has expected value  Electronics, Cars");
		}
		else
		{
			//Reporter.log("<font color='red'><b>Title is not correct after open ebay</b></font>");
			test.log(Status.FAIL, "The title NOT having expected value  Electronics, Cars");
		}
		
	}
	public void search()
	{
		driver.findElement(searchtxt).sendKeys("outdoor toys");
		driver.findElement(searchbtn).click();
	}
}
