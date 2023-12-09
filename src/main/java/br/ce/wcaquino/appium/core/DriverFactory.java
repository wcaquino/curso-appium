package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private static AndroidDriver driver;
	
	public static AndroidDriver getDriver() {
		if(driver == null) {
			createDriver();
//			createTestObjectDriver();
		}
		return driver;
	}
    
    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", "C:\\Users\\Wcaquino\\code\\cursos\\curso-appium\\CTAppium_2_0.apk");      
        try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    private static void createTestObjectDriver() {
    	MutableCapabilities caps = new MutableCapabilities();
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
    	caps.setCapability("automationName", "UiAutomator2");

    	//Settings for Emulator
//    	caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
//    	caps.setCapability("appium:platformVersion", "12.0");

    	//Settings for real device
    	caps.setCapability("appium:deviceName", "Samsung Galaxy S9");
    	caps.setCapability("appium:platformVersion", "10");
        
    	MutableCapabilities sauceOptions = new MutableCapabilities();
    	sauceOptions.setCapability("username", "USERNAME_GOES_HERE");
    	sauceOptions.setCapability("accessKey", "ACCESS_KEY_GOES_HERE");
    	sauceOptions.setCapability("build", "appium-build-WCS7C");
    	sauceOptions.setCapability("name", "Test CTAppium");
    	sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
    	caps.setCapability("sauce:options", sauceOptions);
        try {
        	URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
			driver = new AndroidDriver(url, caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public static void killDriver() {
    	if(driver != null) {
    		driver.quit();
    		driver = null;
    	}
    }
}