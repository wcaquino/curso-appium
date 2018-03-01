package br.ce.wcaquino.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
    
    private AndroidDriver<MobileElement> driver;
    
    @Before
    public void inicializarAppium() throws MalformedURLException {
        driver = DriverFactory.getDriver();
        
        //Selecionar formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
    }
    
    @After
    public void tearDown() {
        DriverFactory.killDriver();
    }

    @Test
    public void devePreecherCampoTexto() throws MalformedURLException {
        //escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Wagner");
        
        //checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("Wagner", text);
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {
        //clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        
        //selecionar opcao desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        
        //verificar opcao selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);
    }
    

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
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
    }
    
    @Test
    public void deveResolverDesafio() throws MalformedURLException {
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
    }
}