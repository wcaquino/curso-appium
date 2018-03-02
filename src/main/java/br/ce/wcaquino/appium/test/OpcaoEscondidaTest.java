package br.ce.wcaquino.appium.test;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();

	@Test
	public void deveEncontrarOpcaoEscondida(){
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Começando");
		
		menu.scrollDown();
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
	}
}