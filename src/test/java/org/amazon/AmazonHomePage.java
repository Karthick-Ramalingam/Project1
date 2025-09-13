package org.amazon;

import org.facebook.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BaseClass {
	
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "twotabsearchtextbox")
	private WebElement textbox;
	
	public WebElement getTextbox() {
		return textbox;
	}
	

}
