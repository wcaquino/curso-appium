package br.ce.wcaquino.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {
    
    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();
    
    @Before
    public void inicializarAppium() throws MalformedURLException {
    	menu.acessarFormulario();
    }

    @Test
    public void devePreecherCampoTexto() throws MalformedURLException {
    	page.escreverNome("Wagner");
        assertEquals("Wagner", page.obterNome());
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {
    	page.selecionarCombo("Nintendo Switch");
        Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
    }
    

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
        Assert.assertFalse(page.isCheckMarcado());
        Assert.assertTrue(page.isSwitchMarcado());

        page.clicarCheck();
        page.clicarSwitch();
        
        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());
    }
    
    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
    	page.escreverNome("Wagner");
    	page.clicarCheck();
    	page.clicarSwitch();
    	page.selecionarCombo("Nintendo Switch");
        
        page.salvar();
        
        Assert.assertEquals("Nome: Wagner", page.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", page.obterConsoleCadstrado());
        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
    }
}