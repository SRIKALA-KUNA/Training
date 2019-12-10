@login
Feature: Movie ticket booking location feature
Background: 
Given user opens login page


Scenario Outline: Movie ticket booking login feature test scenario
When user enters "<username>" and "<password>" 
And user clicks on login button
Then verify user is redirected to locations page 

Examples:
	| username | password |
	| apurv@gmail.com  | kumar |

	
Scenario Outline: Movie ticket booking login feature negative test scenario without radio button selection
When user enters "<username>" and "<password>" 
And user clicks on login button
Then verify user is in login page 
Examples:
	| username | password |
	| apurv@gmail.com  | ku |
	| apurv@gmail  | kumar |
