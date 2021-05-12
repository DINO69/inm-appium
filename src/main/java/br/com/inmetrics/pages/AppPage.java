package br.com.inmetrics.pages;

import br.com.inmetrics.factories.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AppPage {

    public AppPage() {
        PageFactory.initElements( new AppiumFieldDecorator(DriverFactory.getDriver(), Duration.ofSeconds(15)  ), this );
    }

    public void escrever(MobileElement element, String texto) {
        element.clear();
        element.sendKeys(texto);
    }
}
