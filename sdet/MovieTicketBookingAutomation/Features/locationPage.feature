@location
Feature: Movie ticket booking location feature
Background: 
Given user is already in location/home page
 
Scenario Outline: Movie ticket booking location feature test scenario
When user clicks location "<location name>" radio button
And user clicks on search button
Then verify user is redirected to movies page 

Examples:
	| location name |
	| hyderabad  | 
	|  mumbai   |

	
Scenario Outline: Movie ticket booking location feature negative test scenario with multiple radio button selection
When user clicks multiple locations "<location name>" radio button
And user clicks on search button
Then verify user is in same page 
Examples:
	| location name |
	| hyderabad  | 
	|  mumbai   |

Scenario: Movie ticket booking location feature negative test scenario without radio button selection
When user clicks on search button #this hasnt been done
Then verify user is in same page 


Scenario: Movie ticket booking location feature negative test scenario with clicking radio button twice
When user clicks location radio button twice
And user clicks on search button
Then verify user is in same page 
