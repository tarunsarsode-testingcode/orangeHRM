package website_pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.Base_Class;

public class Forgetpassword_page extends Base_Class {
	
	public Login_page loginpage;
	
	public Forgetpassword_page() throws FileNotFoundException
	{
		super();
		PageFactory.initElements(driver, this);
		loginpage = new Login_page();
	}
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/form/fieldset/ol/li/input")
	WebElement username;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/form/fieldset/div/input[1]")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/form/fieldset/div/input[2]")
	WebElement cancel;
	
	 public Login_page verifycancel() throws Exception
	 {
			/*
			 * loginpage = new Login_page(); loginpage.verifyforgetpasswordlink();
			 */
		 loginpage.verifyforgetpasswordlink();
		  cancel.click();
		  return new Login_page();
	 }
	 
	 public void verify_Forgetpassword(String Username) throws Exception
	 {
		 loginpage.verifyforgetpasswordlink();
			username.sendKeys(Username); 
			submit.click();
			 
	 }

	
}
