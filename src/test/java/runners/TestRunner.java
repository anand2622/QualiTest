package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/src/test/resources/functionalTests/", tags= "@Wishlist_Test",
		glue = {"stepDefinitions"},
		monochrome = true,
		//plugin = "html:report/cucumber-reports",
		plugin={"html:out", "json:target/cucumber.json", "html:target/cucumber"}
//clean verify -Dcucumber.options="--tags @createContactDetail1"
)

public class TestRunner {

}
