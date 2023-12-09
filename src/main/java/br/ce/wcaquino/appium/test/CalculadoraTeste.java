package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    
	    WebElement el3 = (WebElement) driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"));
	    el3.click();
	    WebElement el4 = (WebElement) driver.findElement(AppiumBy.accessibilityId("plus"));
	    el4.click();
	    WebElement el5 = (WebElement) driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"));
	    el5.click();
	    WebElement el6 = (WebElement) driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
//	    System.out.println(el6.getText());
	    Assert.assertEquals("4", el6.getText());
	    
	    driver.quit();
	}
}
