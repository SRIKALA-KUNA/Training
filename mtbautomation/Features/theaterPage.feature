@theater
Feature: Movie ticket booking movie feature
Background: 
Given user is already in theater page
 
Scenario Outline: Movie ticket booking theater feature test scenario
When user clicks theater "<theater name>" radio button
And user clicks on search button
Then verify user is redirected to #next  page 

Examples:
	| theater name |
	|   | 
	|     |

Scenario: Movie ticket booking theater feature negative test scenario without radio button selection
When user clicks on search button 
Then verify user is in same page 

