package runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = {"step_definitions"},
	    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
	    		            "junit:target/cucumber-reports/Cucumber.xml",
	    		            "html:target/cucumber-reports"},
	    monochrome = true,
		tags = {"@SmokeTest,@RegressionTest"}
		)
public class RunCukesTest {

}
  