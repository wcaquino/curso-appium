package br.ce.wcaquino.appium.page.seuBarriga;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.appium.core.BasePage;

public class SBResumoPage extends BasePage {

	public void excluirMovimentacao(String desc) {
		WebElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
