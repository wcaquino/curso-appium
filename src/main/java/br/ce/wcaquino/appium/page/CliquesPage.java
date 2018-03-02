package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.TouchAction;

public class CliquesPage extends BasePage {

	public void cliqueLongo(){
		new TouchAction(getDriver())
			.longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))
			.perform();
	}
	
	public String obterTextoCampo(){
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
