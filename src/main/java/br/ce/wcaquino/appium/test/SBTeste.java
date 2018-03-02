package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBContasPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBLoginPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBMenuPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	
	@Before
	public void setup(){
		menu.acessarSBNativo();
		login.setEmail("a@a");
		login.setSenha("a");
		login.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso(){
		// entrar em contas
		menuSB.acessarContas();
		
		//digitar nome conta
		contas.setConta("Conta de Teste");
		
		//salvar
		contas.salvar();
		
		//Verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
}
