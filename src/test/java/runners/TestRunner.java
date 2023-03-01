package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		dryRun= true
		)
public class TestRunner {
}
