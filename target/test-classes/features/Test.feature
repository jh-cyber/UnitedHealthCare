Feature: Test UnitedHealthCare website 

@Test 
Scenario: Sign in to myuhc 
	Given user is on healthcare website 
	When user click on sign in 
	Then user should see sign in to myuhc.come