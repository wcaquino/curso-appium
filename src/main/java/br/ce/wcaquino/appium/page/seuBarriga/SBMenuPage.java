package br.ce.wcaquino.appium.page.seuBarriga;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas(){
		clicarPorTexto("Contas");
	}
	
	public void acessarMovimentacoes(){
		clicarPorTexto("Mov...");
	}
	
	public void acessarResumo(){
		clicarPorTexto("Resumo");
	}
	
	public void acessarHome(){
		clicarPorTexto("Home");
	}
}
