Feature: MMT flight page feature

Scenario: MMT flight link test scenario
Given user is already opened browser and opening home page
When verify title of home page 
Then click flight link

Scenario: applyting filters scenario
Given user is already opened browser
When verify title of flight page 
Then user enters flight data 
Then click filters
Then verify sort filter
Then track progress bar
