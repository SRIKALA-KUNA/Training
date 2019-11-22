package com.epam.MakeMyTripAutomation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClass {
	public int getStatusCode(String url) {
		baseURI = url;
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		return response.statusCode();
	}

}
