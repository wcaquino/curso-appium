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

public class CalculadoraAsusTeste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.asus.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.asus.calculator.Calculator");
	    
	    AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    
	    WebElement el1 = (WebElement) driver.findElement(AppiumBy.id("com.asus.calculator:id/digit2"));
	    el1.click();
	    WebElement el2 = (WebElement) driver.findElement(AppiumBy.accessibilityId("mais"));
	    el2.click();
	    WebElement el3 = (WebElement) driver.findElement(AppiumBy.id("com.asus.calculator:id/digit2"));
	    el3.click();
	    WebElement el4 = (WebElement) driver.findElement(AppiumBy.accessibilityId("igual"));
	    el4.click();
	    WebElement el5 = (WebElement) driver.findElement(AppiumBy.accessibilityId("4"));
	    Assert.assertEquals("4", el5.getText());
	    
	    driver.quit();
	}
}
