package br.com.inmetrics.pages.ctappium.seubarriganativo;

import br.com.inmetrics.pages.AppPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SeuBarrigaNativoPage extends AppPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
    private MobileElement nome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=2]")
    private MobileElement senha;

    public void logar(String nome, String senha){
        escrever(this.nome,nome);
        escrever(this.senha,senha);
    }

    public String getNome(){
        return nome.getText();
    }

    public String getSenha(){
        return senha.getText();
    }

}
