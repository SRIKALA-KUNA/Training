Feature: Movie ticket booking feature
Background:
Given user opens application

@Regression 
Scenario: Movie ticket booking feature test scenario
When user enters details for movie booking
|username|password|location|movie|theater|date|time|seats|
 |appy|kumar|Hyderabad|Chichore  |INOX|2019-12-13|15:30|C1|
Then verify the ticketBooked contains all the details
# Examples:
# |location|movie|theater|time|seats|
# |Hyderabad|Chichore  |INOX|10:30|A1,A2,A3|

@login
Scenario Outline: Movie ticket booking login feature negative test scenario
When user enters details"<username>""<password>" for movie booking
Then verify the user is in login Page
Examples:
| username | password |
| apurv@gmail.com  | ku |
| apurv@gmail  | kumar |

@location
Scenario: Movie ticket booking location feature negative test scenario
When user is in location page and clicks on next button
| username | password |
|appy|kumar|
Then verify the user is in location Page

@movie
Scenario: Movie ticket booking movie feature negative test scenario
When user is in movie page and clicks on next button
| username | password |location|
|appy|kumar|Hyderabad|
Then verify the user is in movie Page


@theatre
Scenario: Movie ticket booking theatre feature negative test scenario
When user is in theatre page and clicks on next button
| username | password |location|movie|
|appy|kumar|Hyderabad|Chichore|
Then verify the user is in theatre Page


@date
Scenario: Movie ticket booking date feature negative test scenario
When user is in date page and clicks on next button
| username | password |location|movie|theatre|
|appy|kumar|Hyderabad|Chichore|INOX|
Then verify the user is in date Page


@time
Scenario: Movie ticket booking time feature negative test scenario
When user is in time page and clicks on next button
| username | password |location|movie|theatre|date|
|appy|kumar|Hyderabad|Chichore|INOX|2019-12-13|
Then verify the user is in time Page




