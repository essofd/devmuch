package api.testcases;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import api.utils.ReportLog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiEnTest {

	/********* PARTICAO DE EQUIVALENCIA - VALOR LIMITE **************
	 * 
	 *  VALORES VALIDOS:
	 *  -10000 ---> valor válido
	 *   -9999 ---> valor válido
	 *       1 ---> valor válido
	 *    9999 ---> valor válido
	 *   10000 ---> valor válido
	 *   
	 *  VALORES INVALIDOS:
	 *  -10001 ---> valor inválido
	 *   10001 ---> valor inválido
	 *   
	 * **************************************************************/

	String urlBase = "http://challengeqa.staging.devmuch.io/";
	static ExtentTest test;
	static ExtentReports report;
	public String[] valor = { "-10001", "-10000", "-9999", "1", "9999", "10000", "10001" };
	public String param1="full";
	public String param2;
	
	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ResultadosIngles.html", true);
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

	}

	@Test
	public void ct01_deveRetornarErroAbaixoIntervaloEn() {
		param2 = "Invalid data";

		test = report.startTest("CT01-LimiteAbaixoIntervEngl");
		
		System.out.println("#### CT01 - Limite Abaixo do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[0]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[0]);

		ReportLog.enviaRelatorio(test, response, 400, param1, param2);
	}

	@Test
	public void ct02_deveRetornarSucessoLimiteInferiorIntervaloEn() {
		param2="minus ten thousand";

		test = report.startTest("CT02-LimiteInferiorIntervEngl");

		System.out.println("#### CT02 - Limite Inferior do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[1]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[1]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct03_deveRetornarSucessoLimiteInferiorDentroIntervaloEn() {
		param2="minus nine thousand, nine hundred and ninety-nine";
		
		test = report.startTest("CT03-LimiteInferiorDentroIntervEngl");

		System.out.println("#### CT03 - Limite Inferior Dentro do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[2]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[2]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct04_deveRetornarSucessoLimiteDentroIntervaloEn() {
		param2="one";
		
		test = report.startTest("CT04-LimiteDentroIntervEngl");

		System.out.println("#### CT04 - Limite Dentro do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[3]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[3]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct05_deveRetornarSucessoLimiteSuperiorDentroIntervaloEn() {
		param2="nine thousand, nine hundred and ninety-nine";
		
		test = report.startTest("CT05-LimiteSuperiorDentroIntervEngl");

		System.out.println("#### CT05 - Limite Superior Dentro do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[4]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[4]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct06_deveRetornarSucessoLimiteSuperiorIntervaloEn() {
		param2="ten thousand";
		
		test = report.startTest("CT06-LimiteSuperiorIntervEngl");

		System.out.println("#### CT06 - Limite Superior do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[5]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[5]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct07_deveRetornarErroAcimaIntervaloEn() {
		param2="Invalid data";
		
		test = report.startTest("CT07-LimiteAcimaIntervEngl");

		System.out.println("#### CT07 - Limite Acima do Intervalo Ingles ####\n");

		Response response = given().contentType("application/json").get(urlBase + "en/" + valor[6]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + "en/" + valor[6]);

		ReportLog.enviaRelatorio(test, response, 400, param1, param2);

	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();

	}

}
