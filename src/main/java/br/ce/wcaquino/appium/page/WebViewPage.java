package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb(){
		Set<String> contextHandles = getDriver().getContextHandles();
//		for(String valor: contextHandles) {
//			System.out.println(valor);
//		}
		getDriver().context((String) contextHandles.toArray()[1]);
	}

	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	
	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);
	}
	
	public void entrar(){
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void sairContextoWeb(){
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}
}
