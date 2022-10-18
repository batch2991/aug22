package testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ResultsPage;

public class Ebay_Testing extends Base
{
  HomePage homepage=new HomePage();
  ResultsPage resultspage=new ResultsPage();
  
  @Test 
  public void functionalTest()
  {
	homepage.openUrl();
	homepage.validateTitle();
	homepage.search();
	resultspage.getTotalResult();
	resultspage.getProductNames();
  }
}
