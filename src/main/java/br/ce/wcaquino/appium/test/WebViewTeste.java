package br.ce.wcaquino.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Test
	public void deveFazerLogin(){
		//acessar o menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("a@a");
		
		//senha
		page.setSenha("a");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Wagner!", page.getMensagem());
	}
	
	@After
	public void tearDown(){
		page.sairContextoWeb();
	}
}
