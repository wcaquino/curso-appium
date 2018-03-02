package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragDropPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();
	
	private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

	@Test
	public void deveEfetuarDragNDrop(){
		//acessar menu
		menu.clicarDragNDrop();
		
		//verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		//arrastar "Esta" para "e arraste para"
		page.arrastar("Esta", "e arraste para");
		
		//verificar estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		//arrastar "Faça um clique longo," para "é uma lista"
		page.arrastar("Faça um clique longo,", "é uma lista");
		
		//verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
