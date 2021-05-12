package br.com.inmetrics.pages.ctappium;

import br.com.inmetrics.pages.AppPage;
import br.com.inmetrics.pages.ctappium.seubarrigahibrido.SeuBarrigaHibridoPage;
import br.com.inmetrics.pages.ctappium.seubarriganativo.SeuBarrigaNativoPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends AppPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
    private MobileElement formulario;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Nativo']")
    private MobileElement seuBarrigaNativo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Híbrido']")
    private MobileElement seuBarrigaHibrido;

    public FormularioPage acessarFormulario(){
        formulario.click();
        return new FormularioPage();
    }

    public SeuBarrigaNativoPage acessarSeuBarrigaNativo(){
        seuBarrigaNativo.click();
        return new SeuBarrigaNativoPage();
    }

    public SeuBarrigaHibridoPage acessarSeuBarrigaHibrido(){
        seuBarrigaHibrido.click();
        return new SeuBarrigaHibridoPage();
    }

}
