## Objetivo

Este projeto tem como objetivo servir de exemplo para a realização testes em aplicativos mobile na linguagem [JAVA](https://www.oracle.com/br/java/technologies/javase-downloads.html) utilizando [Appium](https://appium.io/).<br/>

Iremos apresentar a interação com vários elementos e também faremos fluxos completos, iremos apresentar várias situações comuns no dia-a-dia do tester mobile.

## Estrutura de pastas

## Montar o ambiente
### JAVA
### Android
### Variaveis de ambiente
### Testes do ambiente
### Emulador


Abrir o emulador pelo console
```
emulator -avd <AVDname>
```

### Appium

## Driver factory

## <a id="pagefactory" />Page Factory

O padrão 'Page Factory' é utilizado por classes que representam páginas da aplicação no projeto para : <br/>
1 - Instanciar os elementos da página na criação do objeto;</br>
2 - Deixar o código menos verboso;<br/>
3 - Facilitar a leitura / manutenção;<br/>
4 - Facilitar o uso OO (Orientação a Objeto);<br/>
5 - Proporcionar a aplicação de outros princípios de desenvolvimento (SOLID);<br/><br/>

Para utilizar o Page Factory :

1 - O construtor da classe deve ter a seguinte instrução: 

```
public AppPage() {
    PageFactory.initElements( new AppiumFieldDecorator(DriverFactory.getDriver(), Duration.ofSeconds(15)  ), this );
}
```

Criamos a classe [AppPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/AppPage.java) que conterá a instrução a cima e comportamentos comuns para todas as páginas, conforme herança da classe [MenuPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/MenuPage.java) :  

1.1 - Herdar a classe AppPage :

```
public classe MenuPage extends AppPage {
    ...
}
```

2 - Para cada elemento da página, incluímos a anotação abaixo:

```
@AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
private MobileElement formulario;
```

2.1 - Dentro da anotação, você deve indicar como o elemento vai ser notificado, [existem varias formas](https://appium.github.io/java-client/io/appium/java_client/pagefactory/AndroidFindBy.html), no exemplo acima utilizamos o 'xpath';

3 - Para interagir com o elemento 'formulario', basta realizar uma ação conforme exemplo na classe [MenuPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/MenuPage.java):

```
public FormularioPage acessarFormulario(){
    formulario.click();
    return new FormularioPage();
}
```

3.1 - Sem o padrão uma das formas comuns de utilização seria esta, se encontrar no seu código tente aplicar o Page Factory: 
```
public FormularioPage acessarFormulario(){
    By by = By.xpath("//android.widget.TextView[@text='Formulário']");
    MobileElement elemento = DriverFactory.getDriver().findElement(by);
    elemento.click();
    return new FormularioPage();
}
```

Todas as vezes teríamos que encontrar o elemento, e realizar a interação com ele!. 

## Elementos

Neste tópico traremos interações sobre alguns elementos encontrados nos APPs, para gerar conteúdo, 
será apresentado a usabilidade em vários apps, este projeto será atualizado constantemente.

### EditText

Acredito ser um dos elementos mais importantes quando falamos de teste UI tanto mobile e web.</br>

Este elemento é usado para armazenar texto, para demonstrar o uso dele, escreveremos um texto qualquer, e depois capturaremos ele, validando o processo de escrita / captura do conteúdo.</br>

##### Teste no app [CTAppium_1_2.apk](https://github.com/DINO69/inm-appium/blob/main/apks/CTAppium_1_2.apk) na classe [EditTextTest](https://github.com/DINO69/inm-appium/blob/main/src/test/java/br/com/inmetrics/appium/EditTextTest.java)

##### Nativo

Ao construir um app, você poderá usar elementos nativos, onde o elemento (EditText) é adicionado no mesmo contexto da aplicação e constrói as interações utilizando recursos nativos da plataforma. </br>

Para interagir com o EditText nativo : </br>

1 - Mapear/Encontrar o elemento utilizando [PageFactory](#pagefactory) :

1.1 - Exemplo na classe ['FormularioPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/FormularioPage.java)

```
@AndroidFindBy(accessibility = "nome")
private MobileElement nome;
```

1.2 - Exemplo na classe ['SeuBarrigaNativoPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/seubarriganativo/SeuBarrigaNativoPage.java)

```
@AndroidFindBy(xpath = "//android.widget.EditText[@index=1]")
private MobileElement nome;

@AndroidFindBy(xpath = "//android.widget.EditText[@index=2]")
private MobileElement senha;
```

2 - Preencher/Escrever conteúdo dentro do EditText :

2.1 - Por ser um código(Ação) comum ele está na classe [AppPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/AppPage.java) e como todas as páginas estendem ela, podem utilizar.

```
public void escrever(MobileElement element, String texto) {
    element.clear();
    element.sendKeys(texto);
}
```
2.1.1 - O método acima recebe o elemento mobile e o texto que será escrito no elemento.

2.1.2 - Método ".clear" serve para limpar o conteúdo que possa existir dentro do EditText.

2.1.3 - Método ".sendKeys" serve para enviar um conjunto de caracteres para dentro do EditText.

2.2 - Dentro de cada página o método escrever é chamado

2.2.1 - Exemplo na classe ['FormularioPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/FormularioPage.java)

```
public void setNome(String nome){
    escrever(this.nome,nome);
}
```

2.2.2 - Exemplo na classe ['SeuBarrigaNativoPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/seubarriganativo/SeuBarrigaNativoPage.java)
```
public void logar(String nome, String senha){
    escrever(this.nome,nome);
    escrever(this.senha,senha);
}
```

3 - Capturando o valor do elemento, utilizamos o metodo ".getText()" do próprio elemento mapeado da classe "page".

3.1 - Exemplo na classe ['FormularioPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/FormularioPage.java)

```
public String getNome(){
    return nome.getText();
}
```

3.2 - Exemplo na classe ['SeuBarrigaNativoPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/seubarriganativo/SeuBarrigaNativoPage.java)
```
public String getNome(){
    return nome.getText();
}

public String getSenha(){
    return senha.getText();
}
```

##### Hibrído

Para o elemento EditText será demonstrado a utilizando em um app hídrido, apesar que a "maioria" dos elementos também possuem a possibilidade de estar em um ambiente hídrido.</br>

A sua utilizaram facilidade a implementação e tem os seus prós/contras, conforme link [Híbrido vs Nativo](https://medium.com/taqtilebr/h%C3%ADbrido-vs-nativo-c8591df0dce6#:~:text=Aplica%C3%A7%C3%B5es%20h%C3%ADbridas%20s%C3%A3o%20aplica%C3%A7%C3%B5es%20multi,linguagem%20nativa%20de%20cada%20plataforma.) </br>

Faremos as mesmas etapas do nativo, apresentando a diferença entre os 2.

1 - Mapear/Encontrar o elemento utilizando [PageFactory](#pagefactory), com a diferença que no construtor da classe, temos que trocar o contexo, tendo em vista que o elemento não está na "camada principal do app"</br> 

1.1 - Exemplo na classe ['SeuBarrigaHibridoPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/seubarrigahibrido/SeuBarrigaHibridoPage.java)
```
@AndroidFindBy(id = "email")
private MobileElement email;

@AndroidFindBy(id = "senha")
private MobileElement senha;
```

1.2 - Construtor trocando de contexto
```
public SeuBarrigaHibridoPage() {
    super();
    Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
    System.out.println(contextHandles);
    DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
}
```

2 - Preencher/Escrever conteúdo dentro do EditText, idêntico ao nativo e também extende [AppPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/AppPage.java) :

2.1 - Exemplo na classe ['SeuBarrigaHibridoPage'](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/seubarrigahibrido/SeuBarrigaHibridoPage.java)
```
public void logar(String email, String senha){
    escrever(this.email,email);
    escrever(this.senha,senha);
}
```

3 - Capturando o valor do elemento, por ser uma aplicação hídrica desenvolvida utlizando recursos de html, não conseguimos utilizar o método ".getText()", mas sim capturamos dentro do atributo "value" o conteúdo do elemento, conforme exemplo 'email.getAttribute("value")' e apresentado no código abaixo : </br>

```
public String getEmail(){
    return email.getAttribute("value");
}

public String getSenha(){
    return senha.getAttribute("value");
}
```

### Checkbox
### Switch
### Combo
### Alertas * ( Pegar do aplicativo do frança )
### Tabs
### Accordion
### DataPicker
### TimePicker
### Click na tela
### SeekBar
### Cliques ( Longo | Duplo | Duplo lento | Simples )
### Scroll
### Swipe
### Toast
### Touch Actions

## WebView

## Padroes

## Relatorios

## Esperas

## Clientes
### Appium
### Selendroid

## QrCode
### Validar geração
### Validar leitura

## Fluxos completos
### Cadastro

## Execução em Servidor Cloud
### SauceLabs
### BrowserStacks
### AWS Farms

## CI / CD

## Paralelo

## Referencias

### Testes funcionais de aplicações Android com Appium
Curso : [Testes funcionais de aplicações Android com Appium](https://www.udemy.com/course/testes-appium/)

### Documentação para utilizar a biblioteca ['owner'](http://owner.aeonbits.org/docs/usage/)

### [Downloads de apks](https://downloadapk.net/)

### Aplicativos [Híbrido vs Nativo](https://medium.com/taqtilebr/h%C3%ADbrido-vs-nativo-c8591df0dce6#:~:text=Aplica%C3%A7%C3%B5es%20h%C3%ADbridas%20s%C3%A3o%20aplica%C3%A7%C3%B5es%20multi,linguagem%20nativa%20de%20cada%20plataforma.)

## Dependecias

### Appium

Framework para interações com o mobile ( app )

```
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>7.5.1</version>
</dependency>
```

### JUnit 5 - Jupiter

JUnit 5

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.0-M1</version>
    <scope>test</scope>
</dependency>
```

### OWNER

Biblioteca [owner](http://owner.aeonbits.org/) utilizada para instanciar as propriedades. 

```
<dependency>
    <groupId>org.aeonbits.owner</groupId>
    <artifactId>owner</artifactId>
    <version>1.0.12</version>
</dependency>
```

## Vídeos

### [Utilizando o Appium + Java - #1 - Apresentação do projeto](https://youtu.be/zJffyiC91Vo)
### [Utilizando o Appium + Java - #2 - Page Factory](https://youtu.be/VRpjchAKgX4)
### [Utilizando o Appium + Java - #3 - Elemento EditText 1/2](https://youtu.be/eugJH_ZcZgY)
### [Utilizando o Appium + Java - #4 - Elemento EditText 2/2](https://youtu.be/3QG8LDEaZm0)

