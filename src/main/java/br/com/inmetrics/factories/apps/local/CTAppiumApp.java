package br.com.inmetrics.factories.apps.local;

import br.com.inmetrics.constants.MobileCapabilityType;
import br.com.inmetrics.factories.apps.AppStategy;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CTAppiumApp extends AppStategy {

    @Override
    public DesiredCapabilities generateCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\apks\\CTAppium_1_2.apk");
        return capabilities;
    }

}
