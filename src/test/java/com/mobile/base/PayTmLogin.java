package com.mobile.base;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayTmLogin {
	
AndroidDriver driver;
FileInputStream fs;
Properties properties;
AppiumStartandStop appiumObj;

@BeforeSuite
public void appiumStartServer() 
{
appiumObj.startServer();
}

@BeforeTest
public void setProperties() throws IOException
{
	fs=new FileInputStream("C:\\Users\\whisk\\workspace\\MobileTest\\src\\test\\java\\com\\mobile\\base\\paytm.properties");
	properties=new Properties();
	properties.load(fs);
}

@Test(priority=0)
public void openPayTm() throws MalformedURLException
{
	    System.out.println("Open PayTM Started");
		File apkPath=new File(properties.getProperty("PayTmApkPath"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//		capabilities.setCapability("deviceName", "Moto G");
//		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", apkPath.getAbsolutePath());
		capabilities.setCapability("appPackage", "net.one97.paytm");
		capabilities.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

@Test(priority=1)
public void loginTest()  
{
	System.out.println("Login Test Started");
	PayTmLoginPoM loginObj=new PayTmLoginPoM(driver);
	loginObj.myAccount.click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	loginObj.SignIn.click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	loginObj.userName.sendKeys(properties.getProperty("MobileNumber"));
	loginObj.password.sendKeys(properties.getProperty("Password"));
	loginObj.signInButton.click();
	System.out.println("Login Successfully");
}
@Test(priority=2)
public void addToCart() 
{
	System.out.println("Add to Cart Functionality is Started");
	PayTmAddToCartPage cartObj=new PayTmAddToCartPage(driver);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cartObj.menu.click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	cartObj.electronicsMenu.click();
	cartObj.kitchenAppliances.click();
	cartObj.mixerGrinders.click();
	cartObj.itemToBuy.click();
	cartObj.addToCart.click();
	System.out.println("Item added to Cart Successfully");
}
@AfterSuite
public void appiumStopServer() 
{
appiumObj.stopServer();
}
}

