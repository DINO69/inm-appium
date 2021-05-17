package br.com.inmetrics.factories.drivers;

import br.com.inmetrics.exceptions.DriverException;
import br.com.inmetrics.factories.apps.AppStategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class DriverStrategy {

    private AppStategy app;

    public DriverStrategy(AppStategy app) {
        this.app = app;
    }

    public abstract DesiredCapabilities getCapabilities();

    public abstract String toURL();

    public AndroidDriver<MobileElement> createDriver() {

        DesiredCapabilities desiredCapabilities = getCapabilities();

        desiredCapabilities.merge(app.generateCapabilities());

        return new AndroidDriver<>(getURL(), desiredCapabilities);

    }

    private URL getURL() {
        try {
            return new URL(toURL());
        } catch (MalformedURLException e) {
            throw new DriverException("Erro ao se conectar no appim pelo endereço." + e.getMessage());
        }
    }

}
