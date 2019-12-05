@movie
Feature: Movie ticket booking movie feature
Background: 
Given user is already in movie page
 
Scenario Outline: Movie ticket booking movie feature test scenario
When user clicks movie "<movie name>" radio button
And user clicks on search button
Then verify user is redirected to theater page 

Examples:
	| movie name |
	|   | 
	|     |

	
Scenario Outline: Movie ticket booking movie feature negative test scenario with multiple radio button selection
When user clicks multiple movies "<movie name>" radio button
And user clicks on search button
Then verify user is in same page 
Examples:
	| movie name |
	|   | 
	|     |

Scenario: Movie ticket booking movie feature negative test scenario without radio button selection
When user clicks on search button #this hasnt been done
Then verify user is in same page 


Scenario: Movie ticket booking movie feature negative test scenario with clicking radio button twice
When user clicks movie radio button twice
And user clicks on search button
Then verify user is in same page 
