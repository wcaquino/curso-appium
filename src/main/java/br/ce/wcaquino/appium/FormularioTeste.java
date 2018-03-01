package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void devePreecherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for(MobileElement elemento: elementosEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
	    elementosEncontrados.get(1).click();
	    
	    //escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Wagner");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Wagner", text);
	    
	    driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //verificar opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", text);
	    
	    driver.quit();
	}
	

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	    
	    //verificar status dos elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //clicar nos elementos
	    check.click();
	    switc.click();
	    
	    //verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	    
	    driver.quit();
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	    
	    //preencher campos
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Wagner");
	    driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.className("android.widget.Switch")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        
        //salvar
        driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
        
        //verificacoes
        MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Wagner']"));
        Assert.assertEquals("Nome: Wagner", nome.getText());
        
        MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        Assert.assertEquals("Console: switch", combo.getText());
        
        MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
        Assert.assertTrue(swit.getText().endsWith("Off"));
        
        MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
        Assert.assertTrue(check.getText().endsWith("Marcado"));
        
        driver.quit();
    }
}