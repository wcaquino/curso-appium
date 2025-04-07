package br.ce.wcaquino.appium.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

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
    	UiAutomator2Options options = new UiAutomator2Options()
    		    .setUdid("emulator-5554")
    		    .setApp(new File("CTAppium_2_0.apk").getAbsolutePath());
        try {
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		} catch (MalformedURLException | URISyntaxException e) {
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
    
    public static void resetApp() {
    	getDriver().terminateApp("com.ctappium");
    	getDriver().activateApp("com.ctappium");
    }
}