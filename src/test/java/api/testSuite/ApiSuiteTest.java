package api.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import api.testcases.ApiEnTest;
import api.testcases.ApiPtTest;


@RunWith(Suite.class)
@SuiteClasses({
	ApiPtTest.class,
	ApiEnTest.class
})
public class ApiSuiteTest {
	
}