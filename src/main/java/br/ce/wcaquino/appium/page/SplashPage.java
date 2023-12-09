package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;

public class SplashPage extends BasePage {

	public boolean isTelaSplashVisivel(){
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguardarSplashSumir(){
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
