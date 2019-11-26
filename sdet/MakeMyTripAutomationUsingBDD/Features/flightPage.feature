@flightPage
Feature: MMT flight page feature

Scenario: MMT flight link test scenario
Given user is opening home page
When verify url of home page 
Then click flight link

Scenario: applyting filters scenario
Given user is opening flight page
When verify url of flight page 
Then user enters flight data 
Then click filters
Then verify sort filter
Then track progress bar
