package com.mobile.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class PayTmAddToCartPage {
	
	AndroidDriver driver;
	
	@FindBy(how=How.XPATH,using="//android.widget.ImageButton[@index='0']")
	public WebElement menu;
	@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Electronics']")
	public WebElement electronicsMenu;
	@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Kitchen Appliances']")
	public WebElement kitchenAppliances;
	@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Mixer Juicer Grinders']")
	public WebElement mixerGrinders;
	@FindBy(how=How.ID,using="net.one97.paytm:id/product_image")
	public WebElement itemToBuy;
	@FindBy(how=How.XPATH,using="//android.widget.TextView[@text='Buy for Rs.1,179']")
	public WebElement addToCart;
	
	PayTmAddToCartPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
