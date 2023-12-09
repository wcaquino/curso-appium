package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;

import br.ce.wcaquino.appium.core.BasePage;

public class DragDropPage extends BasePage {

	public void arrastar(String origem, String destino) {
		WebElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		WebElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		PointerInput FINGER = new PointerInput(Kind.TOUCH, "finger");
		Sequence drag = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 
                		inicio.getLocation().getX(), inicio.getLocation().getY()))
                .addAction(FINGER.createPointerDown(MouseButton.LEFT.asArg()))
                .addAction(new Pause(FINGER, Duration.ofMillis(1000)))
                .addAction(FINGER.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), 
                		fim.getLocation().getX(), fim.getLocation().getY()))
                .addAction(FINGER.createPointerUp(MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(drag));
	}
	
	public String[] obterLista() {
		List<WebElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for(int i = 0; i < elements.size(); i++){
			retorno[i] = elements.get(i).getText();
//			System.out.print("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}
}
