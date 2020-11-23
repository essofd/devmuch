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
public class ApiPtTest {

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
	public String param1="extenso";
	public String param2;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ResultadosPortugues.html", true);
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

	}

	@Test
	public void ct01_deveRetornarErroAbaixoIntervaloPt() {
		param2 = "Invalid data";

		test = report.startTest("CT01-LimiteAbaixoIntervPort");

		System.out.println("#### CT01 - Limite Abaixo do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[0]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[0]);

		ReportLog.enviaRelatorio(test, response, 400, param1, param2);

	}

	@Test
	public void ct02_deveRetornarSucessoLimiteInferiorIntervaloPt() {
		param2 = "menos dez mil";

		test = report.startTest("CT02-LimiteInferiorIntervPort");

		System.out.println("#### CT02 - Limite Inferior do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[1]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[1]);


		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct03_deveRetornarSucessoLimiteInferiorDentroIntervaloPt() {
		param2="menos nove mil novecentos e noventa e nove";
		
		test = report.startTest("CT03-LimiteInferiorDentroIntervPort");

		System.out.println("#### CT03 - Limite Inferior Dentro do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[2]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[2]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct04_deveRetornarSucessoLimiteDentroIntervaloPt() {
		param2="um";
		
		test = report.startTest("CT04-LimiteDentroIntervPort");

		System.out.println("#### CT04 - Limite Dentro do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[3]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[3]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);
	}

	@Test
	public void ct05_deveRetornarSucessoLimiteSuperiorDentroIntervaloPt() {
		param2="nove mil novecentos e noventa e nove";
		
		test = report.startTest("CT05-LimiteSuperiorDentroIntervPort");

		System.out.println("#### CT05 - Limite Superior Dentro do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[4]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[4]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);
	}

	@Test
	public void ct06_deveRetornarSucessoLimiteSuperiorIntervaloPt() {
		param2 = "dez mil";
		
		test = report.startTest("CT06-LimiteSuperiorIntervPort");

		System.out.println("#### CT06 - Limite Superior do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[5]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[5]);

		ReportLog.enviaRelatorio(test, response, 200, param1, param2);

	}

	@Test
	public void ct07_deveRetornarErroAcimaIntervaloPt() {
		param2 = "Invalid data";
		
		test = report.startTest("CT07-LimiteAcimaIntervPort");

		System.out.println("#### CT07 - Limite Acima do Intervalo Portugues ####\n");

		Response response = given().contentType("application/json").get(urlBase + valor[6]);

		test.log(LogStatus.INFO, "Chamando a Api", urlBase + valor[6]);

		ReportLog.enviaRelatorio(test, response, 400, param1, param2);
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();

	}

}
