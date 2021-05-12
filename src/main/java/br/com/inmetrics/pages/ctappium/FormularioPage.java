package br.com.inmetrics.pages.ctappium;

import br.com.inmetrics.pages.AppPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormularioPage extends AppPage {

    @AndroidFindBy(accessibility = "nome")
    private MobileElement nome;

    public String getNome(){
        return nome.getText();
    }

    public void setNome(String nome){
        escrever(this.nome,nome);
    }

}
