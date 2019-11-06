TASK:
There are there test cases that should be automated by using Rest Assured.

A. Create a test to verify an http status code.
The test case is 
1. Send the http request by using the GET method. 
The URL is https://jsonplaceholder.typicode.com/users, https://petstore.swagger.io/#/pet
2. Validation: status code of the obtained response is 200 OK

B. Create a test to verify an http response header.
The test case is 
1. Send the http request by using the GET method. 
The URL is https://jsonplaceholder.typicode.com/users, https://petstore.swagger.io/#/pet

2. Validation: -the content-type header exists in the obtained response
                         -the value of the content-type header is application/json; charset=utf-8

С. Create a test to verify an http response body.
The test case is 
1. Send the http request by using the GET method. 
The URL is https://jsonplaceholder.typicode.com/users , https://petstore.swagger.io/#/pet

2. Validation: the content of the response body is the array of 10 users.


D. Create a post request to verify status code, header and response
1. Send the http request by using the POST method. 
The URL is https://jsonplaceholder.typicode.com/users, https://petstore.swagger.io/#/pet
2.Validate the response body post request.

