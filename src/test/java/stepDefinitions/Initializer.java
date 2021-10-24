package stepDefinitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base{

	
	// In this class we will define Before Hooks and After hooks of Cucumber
	// Before hooks will run before each scenario
	// After hooks will run after each scenario

	@Before
	public void beforHooks(Scenario scenario) {
		logger.info( scenario.getName() + " Started");
		scenario.log(scenario.getName()+ " started");
		selectBrowser();// this method comes from Base class and will lunch browser
		openBrowser();// this method comes from Base class and will lunch url

	}

	@After
	public void afterHooks(Scenario scenario) {
		tearDown();
		logger.info( scenario.getName() + " " + scenario.getStatus());
		scenario.log(scenario.getName()+ " " + scenario.getStatus());

	}

	
}
