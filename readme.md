## Objetivo

Este projeto tem como objetivo servir de exemplo para a realização testes em aplicativos mobile utilizando [Appium]().<br/>

Iremos apresentar a interação com vários elementos e também faremos fluxos completos, iremos apresentar várias situações comuns no dia-a-dia do tester mobile.

## Estrutura de pastas

## Montar o ambiente
### JAVA
### Android
### Variaveis de ambiente
### Testes do ambiente
### Emulador
### Appium

## Driver factory

## Page Factory

O padrão 'Page Factory' é utilizado por classes que representam páginas da aplicação no projeto para : <br/>
1 - Instanciar os elementos da página na criação do objeto;</br>
1 - Deixar o código menos verboso;<br/>
2 - Facilitar a leitura / manutenção;<br/>
3 - Facilitar o uso OO (Orientação a Objeto);<br/>
4 - Proporcionar a aplicação de outros princípios de desenvolvimento (SOLID);<br/><br/>

Para utilizar o Page Factory :

1 - O construtor da class deve ter a seguinte instrução: 

```
public AppPage() {
    PageFactory.initElements( new AppiumFieldDecorator(DriverFactory.getDriver(), Duration.ofSeconds(15)  ), this );
}
```

Criamos a class [AppPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/AppPage.java) que conterá a instrução a cima e comportamentos comuns para todas as páginas, conforme classe [MenuPage](https://github.com/DINO69/inm-appium/blob/main/src/main/java/br/com/inmetrics/pages/ctappium/MenuPage.java) :  

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
### TextView
##### Nativo
##### Hibrído

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

