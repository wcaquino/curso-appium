package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarFormulario(){
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash(){
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas(){
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas(){
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion(){
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques(){
		clicarPorTexto("Cliques");
	}
}
