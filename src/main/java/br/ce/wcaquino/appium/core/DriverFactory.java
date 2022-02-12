package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
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
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\wcaqu\\eclipse-workspace\\CursoAppium\\CTAppium_1_2.apk");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
	    desiredCapabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }
    
    private static void createTestObjectDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("testobject_api_key", "91E74CCC23FC432EBF8F5C10F8685A15");
        desiredCapabilities.setCapability("appiumVersion", "1.7.2");
//        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public static void killDriver() {
    	if(driver != null) {
    		driver.quit();
    		driver = null;
    	}
    }
}
