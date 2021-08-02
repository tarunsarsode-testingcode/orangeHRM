package democodes;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base_package.Base_Class;
import website_pages.Forgetpassword_page;
import website_pages.Login_page;

public class Forgetpasswordpage_Test extends Base_Class {

	
	Forgetpassword_page forgetpasswordpage;
	ExtentTest test;
	
	public Forgetpasswordpage_Test() throws FileNotFoundException {
		
		super();	
		
		}
	@BeforeTest
	public void initextentreport()
	{
		Extentreport();
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, InterruptedException
	{
		initalization();
		driver.get(prop.getProperty("APP_URL"));
		forgetpasswordpage = new Forgetpassword_page();
	}
		
	@Test(priority = 1)
	public void verify_Forgetpassword_Test() throws Exception
	{
		String username = prop.getProperty("Username");
		 forgetpasswordpage.verify_Forgetpassword(username);
		
	}
	
	@Test(priority = 2)
	public void verify_cancel() throws Exception
	{
		forgetpasswordpage.verifycancel();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterTest
	public void flushextent()
	{
		extentflush();
	}

}
