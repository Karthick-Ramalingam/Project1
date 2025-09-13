package org.stepdef;

import java.util.List;
import java.util.Map;

import org.amazon.AmazonHomePage;
import org.facebook.BaseClass;
import org.facebook.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	@Given("user launch edge browser")
	public void userLaunchEdgeBrowser(){
		browserLaunch();
	}

	@When("user enter valid url")
	public void userEnterValidUrl() {
		loadUrl("https://www.facebook.com/");
			}

	@When("user enter valid username and valid password")
	public void userEnterValidUsernameAndValidPassword() {
	  LoginPage l=new LoginPage();
	  passTxt(l.getUsername(), "karthick");
	  passTxt(l.getPassword(), "123");    
	}
	
	@When("user enter invalid username and invalid password")
	public void user_enter_invalid_username_and_invalid_password() {
		  LoginPage l=new LoginPage();
		  passTxt(l.getUsername(), "ssssss");
		  passTxt(l.getPassword(), "124");
	}
	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
	   LoginPage l=new LoginPage();
	   passTxt(l.getUsername(), username);
	   passTxt(l.getPassword(), password);
	}
	@Then("user click login button")
	public void user_click_login_button() {
		driver.findElement(By.name("login")).click();
	}
	@When("user enter amazon url")
	public void user_enter_amazon_url() {
			loadUrl("https://www.amazon.in/");
	}

	@When("user enter product name and click search button")
	public void user_enter_product_name_and_click_search_button(io.cucumber.datatable.DataTable d) {
		
		WebElement textbox = driver.findElement(By.id("twotabsearchtextbox"));
//		List<Map<String,String>> asMaps = d.asMaps();
//		Map<String, String> map = asMaps.get(2);
//		String value = map.get("mobile");
//		passTxt(textbox, value);
		
		Map<Object, Object> asMap = d.asMap(String.class, String.class);
		Object value = asMap.get("mobile");
		passTxt(textbox, (String) value);

	}


	
}
