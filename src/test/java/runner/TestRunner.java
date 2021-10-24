package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author shako
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue = "stepDefinitions",
		tags = "@Test",
//		if we put true for dryRun it will not do anything it will skip
		dryRun = false,
		monochrome = true,
		strict = true,
		plugin = {"pretty", 
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json" }, 
		publish = true
		)
public class TestRunner {

}
