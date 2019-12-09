@location
Feature: Movie ticket booking location feature
Background: 
Given user opens location page
 
Scenario Outline: Movie ticket booking location feature test scenario
When user clicks location "<location name>" radio button
And user clicks on search button
Then verify user is redirected to movies page 

Examples:
	| location name |
	|Hyderabad| 
	|Chennai|
	|Bangalore|

	
Scenario: Movie ticket booking location feature negative test scenario without radio button selection
When user clicks on search button 
Then verify user is in location page 
