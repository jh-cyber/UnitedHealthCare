package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HealthHomePageObject extends Base{
	 public HealthHomePageObject() {
		 PageFactory.initElements(driver, this);
		 
	 }
@FindBy (xpath="//span[text()='Sign in' and@class ='mr-4']")
private WebElement signIn;

@FindBy (xpath= " //header/div[1]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]")
private WebElement plan;

@FindBy (xpath= " //h2[contains(text(),'for you')]")
private WebElement seeHowYourHealthPlanIsHereForYou;


public void clickOnPlan() {
	plan.click();
	
}

public void clickOnSignIn() {
	signIn.click();
}
// at the end we go to TestStepDef class to create an object definition for HealthHomePageObject
public boolean isSeeHowYourHealthPlanIsHereForYouDispayed() {
	if (seeHowYourHealthPlanIsHereForYou.isDisplayed())
		return true;
	else
		return false;
}
}
