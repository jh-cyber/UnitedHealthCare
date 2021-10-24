package stepDefinitions;


import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.HealthHomePageObject;

public class TestStepDef extends Base{

//	after creating obj for HealthHomePageObject we should write codes in line 16-17
	HealthHomePageObject healthHomePage= new HealthHomePageObject();
	@Given("user is on healthcare website")
	public void user_is_on_healthcare_website() {
//	    throw new io.cucumber.java.PendingException();
	    String actualTitle =driver.getTitle();
	    System.out.println("title is:   " + actualTitle);
	    String expectedTitle = properties.getProperty("title");
	    
	    Assert.assertEquals(expectedTitle, actualTitle);
	    logger.info(actualTitle + "is equal to" + expectedTitle);
	    
	}
	@When("user click on sign in")
	public void user_click_on_sign_in() {
//	    throw new io.cucumber.java.PendingException();
		logger.info("user click on signIn");
		healthHomePage.clickOnSignIn();
	}
	@Then("user should see sign in to myuhc.come")
	public void user_should_see_sign_in_to_myuhc_come() {
//	    throw new io.cucumber.java.PendingException();
		Assert.assertTrue(healthHomePage.isSeeHowYourHealthPlanIsHereForYouDispayed());
		logger.info("user should see sign in to myuhc");
	}
}
