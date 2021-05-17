package br.com.inmetrics.factories.drivers;

import br.com.inmetrics.constants.MobileCapabilityType;
import br.com.inmetrics.factories.apps.AppStategy;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverLocal extends DriverStrategy {

    public DriverLocal(AppStategy app) {
        super(app);
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        return desiredCapabilities;
    }

    @Override
    public String toURL(){
        return "http://localhost:4723/wd/hub";
    }
}
