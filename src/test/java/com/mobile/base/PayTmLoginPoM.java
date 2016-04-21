package com.mobile.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class PayTmLoginPoM {
	
	AndroidDriver driver;
	
	@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Account']")
	public WebElement myAccount;
	@FindBy(how=How.ID,using="net.one97.paytm:id/name")
	public WebElement SignIn;
	@FindBy(how=How.ID,using="net.one97.paytm:id/edit_username")
	public WebElement userName;
	@FindBy(how=How.ID,using="net.one97.paytm:id/edit_password")
	public WebElement password;
	@FindBy(how=How.ID,using="net.one97.paytm:id/button_text")
	public WebElement signInButton;
	
	
	PayTmLoginPoM(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
