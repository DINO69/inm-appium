package br.com.inmetrics.pages.ctappium.seubarrigahibrido;

import br.com.inmetrics.factories.DriverFactory;
import br.com.inmetrics.pages.AppPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.Set;

public class SeuBarrigaHibridoPage extends AppPage {

    @AndroidFindBy(id = "email")
    private MobileElement email;

    @AndroidFindBy(id = "senha")
    private MobileElement senha;

    public SeuBarrigaHibridoPage() {
        super();
        Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
        System.out.println(contextHandles);
        DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void logar(String email, String senha){
        escrever(this.email,email);
        escrever(this.senha,senha);
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public String getSenha(){
        return senha.getAttribute("value");
    }

}
