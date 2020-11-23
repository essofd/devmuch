package api.utils;

import static org.junit.Assert.fail;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLog {

	public static void enviaRelatorio(ExtentTest test, Response response, int statusCode, String param1, String param2) {
		String value_in_full = null;
		int code;

		try {
			value_in_full = response.jsonPath().get(param1);

			System.out.println("Valor: " + value_in_full + "\n");

			code = response.getStatusCode();

			if (code == statusCode && value_in_full.equals(param2)) {
				test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString(param1));
				test.log(LogStatus.INFO, "Status Code", "\"" + statusCode + "\"");
				test.assignAuthor("Edson Costa");
				test.assignCategory("Api");

			} else if (code != statusCode) {
				test.log(LogStatus.FAIL, "Status Code", Integer.toString(code));
				fail("Status Code diferente do retornado");
			} else if (!value_in_full.equals(param2)) {
				test.log(LogStatus.FAIL, "Erro no valor do intervalo", value_in_full);
				fail("valor do intervalo diferente do retornado");
			} else {
				test.log(LogStatus.PASS, "Retorno", response.jsonPath().getString(param1));
				test.log(LogStatus.INFO, "Status Code", "\"" + statusCode + "\"");
				test.assignAuthor("Edson Costa");
				test.assignCategory("Api");
			}

		} catch (Exception e) {
			System.out.println("Falha ao encontrar o valor: " + value_in_full);
			test.log(LogStatus.FAIL, "Falha no padrão do parametro:", response.getBody().prettyPrint());
			fail("Falha no padrão do parametro");
		}

	}

}
