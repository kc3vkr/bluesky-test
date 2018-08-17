package com.bluesky.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bluesky.object.ui.LoginPage;
import com.bluesky.utils.CreateDriver;

public class SimpleUnitTest {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@Test
	public void testApp() {
		login.waitForLoginPageToLoad();
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	

}
