package democodes;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.Base_Class;
import website_pages.Dashboard_page;
import website_pages.Forgetpasswordpage;
import website_pages.Login_page;

public class Login_page_Testcase extends Base_Class {

	
	Login_page loginpage;
	Dashboard_page dashboardpage;
	Forgetpasswordpage forgetpasswordpage;
	
	public Login_page_Testcase() throws FileNotFoundException {
		
		super();
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException
	{
		initalization();
		loginpage = new Login_page();
	}
	
	
	@Test (priority = 1)
	public void Verify_login()
	{
		dashboardpage  = loginpage.adminlogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@Test(priority = 2)
	public void verify_Title()
	{
		String Title = loginpage.verifyTitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	
	@Test(priority = 3)
	public void verify_forgetpassword_link()
	{
		 loginpage.verifyforgetpasswordlink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
