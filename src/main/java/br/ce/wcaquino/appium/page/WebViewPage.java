package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

public class WebViewPage {
	
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
	
	public void sairContextoWeb(){
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}
}
