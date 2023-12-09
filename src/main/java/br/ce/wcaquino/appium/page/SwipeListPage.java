package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.appium.core.BasePage;

public class SwipeListPage extends BasePage {

	public void swipeElementLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void clicarBotaoMais(){
		WebElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
		tap(botao.getLocation().getX() + 50, botao.getLocation().getY());
	}
}
