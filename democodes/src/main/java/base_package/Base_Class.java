package base_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test_util.Testutil;

public class Base_Class {

	public static Properties prop;
	public static WebDriver driver;
	
	public Base_Class() throws FileNotFoundException
	{
		try {
	prop = new Properties();
	
	String file = System.getProperty("user.dir")+"\\src\\main\\java\\configuration_package\\configuration.properties";
	FileInputStream fp = new FileInputStream(file);
		prop.load(fp);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static void initalization() throws FileNotFoundException
	{
		String browsername = prop.getProperty("Browser_Name");
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Desktop\\Automation_codes\\democodes\\browser_driver\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("APP_URL"));
	}
	
	public static void Websiteload()
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	public static void sleep() throws InterruptedException
	{
			Thread.sleep(10);	
	}
	
}
