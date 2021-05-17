package br.com.inmetrics.factories;

import br.com.inmetrics.exceptions.DriverException;
import br.com.inmetrics.factories.drivers.DriverStrategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

    private static DriverFactory instance;

    private AndroidDriver<MobileElement> driver;

    private DriverFactory() {}

    public static AndroidDriver<MobileElement> getDriver(){
        validarDriverInstanciado();
        return instance.driver;
    }

    public static void createDriver(DriverStrategy strategy){
        instance = new DriverFactory();
        instance.driver = strategy.createDriver();
    }

    public static void killDriver(){
        getDriver().quit();
        instance.driver = null;
        instance = null;
    }

    public static void restartApp(){
        validarDriverInstanciado();
        instance.driver.resetApp();
    }

    private static void validarDriverInstanciado() {
        if(instance == null || instance.driver == null){
            throw new DriverException("Driver não criado, utilizar 'DriverFactory.createDriver(DriverStrategy strategy)'.");
        }
    }

}
