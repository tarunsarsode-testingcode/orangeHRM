package democodes;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_package.Base_Class;
import website_pages.Dashboard_page;
import website_pages.Forgetpassword_page;
import website_pages.Login_page;

public class Login_page_Testcase extends Base_Class {

	
	Login_page loginpage;
	Dashboard_page dashboardpage;
	Forgetpassword_page forgetpasswordpage;
	ExtentTest test;
	
	public Login_page_Testcase() throws FileNotFoundException {
		
		super();
	}
	
	@BeforeTest
	public void initextentreport()
	{
		Extentreport();
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException
	{
		initalization();
		driver.get(prop.getProperty("APP_URL"));
		loginpage = new Login_page();
	}
	
	
	@Test (priority = 1)
	public void Verify_login()
	{
		test = extent.createTest("TC_Loginpage");
		dashboardpage  = loginpage.adminlogin(prop.getProperty("Username"), prop.getProperty("Password"));
		test.log(Status.PASS, "Admin login Successully");
	}
	
	@Test(priority = 2)
	public void verify_Title()
	{
		test = extent.createTest("TC_VerifyTitle");
		String Title = loginpage.verifyTitle();
		Assert.assertEquals(Title, "OrangeHRM");
		test.log(Status.PASS, "Login page Title are coming correct");
	}
	
	@Test(priority = 3)
	public void verify_forgetpassword_link() throws Exception
	{
		test = extent.createTest("TC_Verify_Forgetpasswordlink");
		 forgetpasswordpage = loginpage.verifyforgetpasswordlink();
		 test.log(Status.PASS, "Forgetpassword link is clickable");
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
