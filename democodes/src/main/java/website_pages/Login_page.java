package website_pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.Base_Class;

public class Login_page extends Base_Class {
	
	Dashboard_page dashboardpage;
	
	@FindBy (id="txtUsername")
	WebElement adminusername;
	
	@FindBy (id="txtPassword")
	WebElement adminpassword;
	
	@FindBy (id="btnLogin")
	WebElement loginbutton;
	
	@FindBy (xpath="/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/div/a")
	WebElement forgetpasswordlink;
	
	@FindBy (xpath="/html/body/div[1]/div/div[3]/div[1]/img")
	WebElement websitelogo;
	
	
	public Login_page() throws FileNotFoundException {
		super();
		
		PageFactory.initElements(driver, this);
		dashboardpage = new Dashboard_page();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public Dashboard_page adminlogin(String username, String password)
	{
		
		adminusername.sendKeys(username);
		Websiteload();
		adminpassword.sendKeys(password);
		Websiteload();
		loginbutton.click();
		
		return new Dashboard_page();
	}
	

	public void verifyforgetpasswordlink() {
		forgetpasswordlink.click();
		
	}
	
}
