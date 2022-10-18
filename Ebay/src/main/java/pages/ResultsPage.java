package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import base.Base;

public class ResultsPage extends Base
{
    
    
	By totalresult=By.xpath("//h1[@class='srp-controls__count-heading']");
	By prodnames=By.xpath("//span[contains(text(),'Portable')]");
			
	public void getTotalResult()
	{
		String results=driver.findElement(totalresult).getText();
		test=report.createTest("Total Result value");
		test.log(Status.INFO, results);
		
	}
	public void getProductNames()
	{
		List<WebElement> lst= driver.findElements(prodnames);
		test=report.createTest("ProductNames");
		for(WebElement x : lst)
		{
			test.log(Status.INFO,x.getText());
		}
		
	}
}
