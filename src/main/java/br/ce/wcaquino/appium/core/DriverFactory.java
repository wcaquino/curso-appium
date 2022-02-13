package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
//			createDriver();
			createTestObjectDriver();
		}
		return driver;
	}
    
    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\wcaqu\\eclipse-workspace\\CursoAppium\\CTAppium_2_0.apk");
//        desiredCapabilities.setCapability("autoGrantPermissions", true);
//        desiredCapabilities.setCapability("noReset", true);
//        desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
//	    desiredCapabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
//        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }
    
    private static void createTestObjectDriver() {
    	MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("deviceName","Samsung Galaxy S9 Plus FHD GoogleAPI Emulator");
//        caps.setCapability("platformVersion","8.1");
//        caps.setCapability("appiumVersion", "1.9.1");
    	
    	caps.setCapability("automationName", "UiAutomator2");
    	
    	
        caps.setCapability("browserName", "");
    	caps.setCapability("platformName", "Android");
//    	caps.setCapability("platformVersion", "11");
    	caps.setCapability("deviceName", "Samsung_Galaxy_S9_free");
    	caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
    	MutableCapabilities sauceOptions = new MutableCapabilities();
    	sauceOptions.setCapability("username", "oauth-oldbutpuregold7-65c3b");
    	sauceOptions.setCapability("accessKey", "06edba44-07e4-4389-aec3-ac6aed87148e");
    	caps.setCapability("sauce:options", sauceOptions);
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("https://oauth-oldbutpuregold7-65c3b:06edba44-07e4-4389-aec3-ac6aed87148e@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
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


/*
org.openqa.selenium.SessionNotCreatedException: Unable to create a new remote session. Please check the server log for more details. Original error: Unknown error while proxying appium request, please contact Sauce Labs support, error id is '815c6546-334d-4db1-ab72-d094de6c557e'
Command duration or timeout: 1.01 seconds
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-CH43EQQ', ip: '10.0.0.92', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_202'
Driver info: driver.version: AndroidDriver
	at io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:216)
	at io.appium.java_client.remote.AppiumCommandExecutor.createSession(AppiumCommandExecutor.java:225)
	at io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:250)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)
	at io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)
	at io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)
	at io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)
	at org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)
	at io.appium.java_client.AppiumDriver.startSession(AppiumDriver.java:363)
	at org.openqa.selenium.remote.RemoteWebDriver.<init>(RemoteWebDriver.java:131)
	at io.appium.java_client.DefaultGenericMobileDriver.<init>(DefaultGenericMobileDriver.java:37)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:89)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:99)
	at io.appium.java_client.android.AndroidDriver.<init>(AndroidDriver.java:97)
	at br.ce.wcaquino.appium.core.DriverFactory.createTestObjectDriver(DriverFactory.java:68)
	at br.ce.wcaquino.appium.core.DriverFactory.getDriver(DriverFactory.java:22)
	at br.ce.wcaquino.appium.core.BasePage.clicar(BasePage.java:29)
	at br.ce.wcaquino.appium.core.BasePage.clicarPorTexto(BasePage.java:33)
	at br.ce.wcaquino.appium.page.MenuPage.acessarAbas(MenuPage.java:26)
	at br.ce.wcaquino.appium.test.AbasTeste.deveInteragirComAbas(AbasTeste.java:18)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.rules.TestWatcher$1.evaluate(TestWatcher.java:55)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:93)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:40)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:529)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:756)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:452)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:193)
	... 46 more
Caused by: org.openqa.selenium.WebDriverException: Unknown error while proxying appium request, please contact Sauce Labs support, error id is '815c6546-334d-4db1-ab72-d094de6c557e'
Command duration or timeout: 1.01 seconds
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)
	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)
	at org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$errorHandler$0(JsonWireProtocolResponse.java:54)
	at org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)
	at org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)
	at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
	at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)
	at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
	at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)
	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
	at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)
	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)
	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)
	... 51 more
Caused by: org.openqa.selenium.WebDriverException: Unknown error while proxying appium request, please contact Sauce Labs support, error id is '815c6546-334d-4db1-ab72-d094de6c557e'
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-CH43EQQ', ip: '10.0.0.92', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_202'
Driver info: driver.version: unknown

org.openqa.selenium.SessionNotCreatedException: Unable to create a new remote session. Please check the server log for more details. Original error: Unknown error while proxying appium request, please contact Sauce Labs support, error id is 'ef10c137-6d88-4b6b-b5e9-4cd138273496'
Command duration or timeout: 828 milliseconds
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-CH43EQQ', ip: '10.0.0.92', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_202'
Driver info: driver.version: AndroidDriver
	at io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:216)
	at io.appium.java_client.remote.AppiumCommandExecutor.createSession(AppiumCommandExecutor.java:225)
	at io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:250)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)
	at io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)
	at io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)
	at io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)
	at org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)
	at io.appium.java_client.AppiumDriver.startSession(AppiumDriver.java:363)
	at org.openqa.selenium.remote.RemoteWebDriver.<init>(RemoteWebDriver.java:131)
	at io.appium.java_client.DefaultGenericMobileDriver.<init>(DefaultGenericMobileDriver.java:37)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:89)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:99)
	at io.appium.java_client.android.AndroidDriver.<init>(AndroidDriver.java:97)
	at br.ce.wcaquino.appium.core.DriverFactory.createTestObjectDriver(DriverFactory.java:68)
	at br.ce.wcaquino.appium.core.DriverFactory.getDriver(DriverFactory.java:22)
	at br.ce.wcaquino.appium.core.BaseTest.gerarScreenShot(BaseTest.java:32)
	at br.ce.wcaquino.appium.core.BaseTest.tearDown(BaseTest.java:25)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:33)
	at org.junit.rules.TestWatcher$1.evaluate(TestWatcher.java:55)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:93)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:40)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:529)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:756)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:452)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:193)
	... 43 more
Caused by: org.openqa.selenium.WebDriverException: Unknown error while proxying appium request, please contact Sauce Labs support, error id is 'ef10c137-6d88-4b6b-b5e9-4cd138273496'
Command duration or timeout: 828 milliseconds
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)
	at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)
	at org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$errorHandler$0(JsonWireProtocolResponse.java:54)
	at org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)
	at org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)
	at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
	at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)
	at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
	at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)
	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
	at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)
	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)
	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)
	... 48 more
Caused by: org.openqa.selenium.WebDriverException: Unknown error while proxying appium request, please contact Sauce Labs support, error id is 'ef10c137-6d88-4b6b-b5e9-4cd138273496'
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-CH43EQQ', ip: '10.0.0.92', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_202'
Driver info: driver.version: unknown

*/