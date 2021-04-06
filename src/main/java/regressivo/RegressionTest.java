package regressivo;


import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        snippets = SnippetType.CAMELCASE,
        plugin = {"junit:cucumberTestingResult.xml"
                ,
                "com.bradesco.report.CucumberReporterPlugin"
        }
        ,
        tags = "@request"
)

// Essa classe é inicial para executar seus testes precisa clicar no botão verde abaixo.
public class RegressionTest {

    // AMBIENTE DE EXECUCAO
    public static String AMBIENTE = "teste";

    // Body usado na chamada BODY
    public static Response RESPONSE = null;
    // BODY ENIADO
    public static String BODY_SEND = null;
    // ENDPOINT global
    public static String ENDPOINT_GLOBAL = null;

    @BeforeClass
    //esse método abaixo irá excluir todos seus reports antigos antes de rodar novamente a aplicação
    public static void setup() {
        // Método irá excluir todos os Reports antigos
        File folder = new File("target/logs");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }

}
