package org.facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(name = "pass")
	private WebElement password;
	

	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	private WebElement fp;
	
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createAcc;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getFp() {
		return fp;
	}

	public WebElement getCreateAcc() {
		return createAcc;
	}
	
	
}
