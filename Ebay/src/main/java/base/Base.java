package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentSparkReporter htmlreport;
	public static ExtentReports report;
	public static ExtentTest test;
	

	@BeforeSuite
	public void initialize()
	{
		prop=new Properties();
		try {
		prop.load(new FileInputStream("src/main/java/conf/config.properties"));}catch(Exception e) {}		
		htmlreport=new ExtentSparkReporter("./Reports/Ebay.html");
		htmlreport.config().setReportName("Ebay Functional Testing");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("ApplicationName","ebay.com");
		report.setSystemInfo("Tester","ram");
		report.setSystemInfo("Environment","TestEnv");
		
		
	}
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String str)
	{		
		if(str.matches("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();	
			driver=new FirefoxDriver();	
		}
		if(str.matches("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void openUrl()
	{
		driver.get(prop.getProperty("url"));
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	@AfterSuite
	public void closing()
	{
	  report.flush();	 //save the report
	}
}
