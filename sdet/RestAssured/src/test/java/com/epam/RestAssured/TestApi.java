package com.epam.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestApi {
	@Test
	public void TestStatusCode()
	{
		baseURI =  "https://petstore.swagger.io/#/pet";
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void TestResponseHeader()
	{
		baseURI =  "https://jsonplaceholder.typicode.com/users";
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		String contentType = response.header("Content-Type");
		String server = response.header("Server");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		Assert.assertEquals(server, "cloudflare");
	}	
	
	@Test
	public void TestResponseBody()
	{
		baseURI =  "https://petstore.swagger.io/v2/pet";
		RequestSpecification request = given();
		Response response = request.request(Method.GET,"/1000");
		ResponseBody body = response.body();
		Assert.assertEquals(body.asString().contains("kitten"), true);
	}
	
	@Test
	public void TestResponseList()
	{
		baseURI =  "https://jsonplaceholder.typicode.com/users";
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		List<Object> ids = response.getBody().jsonPath().getList("id");
		Assert.assertEquals(ids.size(),10);
	}
	
	
	
	
	@Test
	public void TestPost()
	{
		baseURI = "https://petstore.swagger.io/v2/pet";
		RequestSpecification request = given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 1003);
		requestParams.put("name", "kitten");
		requestParams.put("status", "available"); 
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.request(Method.POST);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void TestDelete()
	{
		baseURI =  "https://petstore.swagger.io/v2/pet";
		RequestSpecification request = given();
		Response response = request.request(Method.DELETE, "/1003");
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	}
}
