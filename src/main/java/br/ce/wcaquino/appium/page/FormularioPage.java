package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.AppiumBy;

public class FormularioPage extends BasePage {
	
	public void escreverNome(String nome) {
		escrever(AppiumBy.accessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(AppiumBy.accessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(AppiumBy.accessibilityId("console"), valor);
	}
	
	public String obterValorCombo(){
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck(){
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch(){
		clicar(AppiumBy.accessibilityId("switch"));
	}
	
	public boolean isCheckMarcado(){
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(AppiumBy.accessibilityId("switch"));
	}
	
	public void clicarSeekBar(double posicao){
		int delta = 50;
		WebElement seek = getDriver().findElement(AppiumBy.accessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
		System.out.println(x);
		
		tap(x, y);
	}
	
	public void salvar(){
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado(){
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado(){
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String obterConsoleCadstrado(){
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckCadastrado(){
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public String obterSwitchCadastrado(){
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
}
