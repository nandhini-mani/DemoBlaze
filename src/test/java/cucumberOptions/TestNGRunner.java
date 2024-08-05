package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="C:\\Program Files\\Eclipse\\eclipse\\com.Edureka.Demoblaze\\src\\test\\java\\features",
		glue="stepDefinition",
		tags = "@Signin"
		)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
