package br.com.inmetrics.appium;

import br.com.inmetrics.factories.DriverFactory;
import br.com.inmetrics.factories.apps.local.CTAppiumApp;
import br.com.inmetrics.factories.drivers.DriverLocal;
import br.com.inmetrics.pages.ctappium.FormularioPage;
import br.com.inmetrics.pages.ctappium.MenuPage;
import br.com.inmetrics.pages.ctappium.seubarrigahibrido.SeuBarrigaHibridoPage;
import br.com.inmetrics.pages.ctappium.seubarriganativo.SeuBarrigaNativoPage;
import org.junit.jupiter.api.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class EditTextTest {

    @BeforeAll
    public static void iniciarApp() {
        DriverFactory.createDriver(new DriverLocal(new CTAppiumApp()));
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, SECONDS);
    }

    @Test
    @DisplayName("Interagir com EditText dentro do formulario")
    public void interagirComEditText() {

        MenuPage menu = new MenuPage();
        FormularioPage page = menu.acessarFormulario();

        page.setNome("GUILHERME");

        Assertions.assertEquals("GUILHERME", page.getNome());

    }

    @Test
    @DisplayName("Interagir com EditText dentro do Aplicação Nativa")
    public void interagirComEditTextDentroAplicacaoNativa() {

        MenuPage menu = new MenuPage();

        SeuBarrigaNativoPage page = menu.acessarSeuBarrigaNativo();

        page.logar("GUILHERME", "SENHA");

        Assertions.assertEquals("GUILHERME", page.getNome());
        Assertions.assertEquals("SENHA", page.getSenha());

    }

    @Test
    @DisplayName("Interagir com EditText dentro da Aplicação Hibrida")
    public void interagirComEditTextDentroAplicacaoHibrida() {

        MenuPage menu = new MenuPage();

        SeuBarrigaHibridoPage page = menu.acessarSeuBarrigaHibrido();

        page.logar("contato@guifr.com.br", "gui");

        Assertions.assertEquals("contato@guifr.com.br", page.getEmail());
        Assertions.assertEquals("gui", page.getSenha());

    }

    @AfterEach
    public void afterEach() {
        DriverFactory.restartApp();
    }

    @AfterAll
    public static void afterAll() {
        DriverFactory.killDriver();
    }

}
