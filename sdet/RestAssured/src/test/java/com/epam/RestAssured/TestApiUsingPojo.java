package com.epam.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TestApiUsingPojo {
	PetPojo pet ;

	@Test
	public void TestPostUsingSerialization() {
		baseURI =  "https://petstore.swagger.io/v2";
		ObjectMapper mapper = new ObjectMapper();
		pet = new PetPojo(1111 , "lion","pending");
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(pet);
			given().
			contentType("application/json").
			body(objectAsJson).
			when().
			post("/pet").
			then().
			assertThat().
			statusCode(200);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void TestPost() {
		baseURI =  "https://petstore.swagger.io/v2";
		ObjectMapper mapper = new ObjectMapper();
		pet = new PetPojo(1281 , "dog","pending");
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(pet);
			RequestSpecification request = given();
			request.header("Content-Type", "application/json");
			request.body(objectAsJson);
			Response response = request.request(Method.POST,"/pet");
			int code = response.getStatusCode();
			assertThat(code, is(equalTo(200)));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}							
	}

	@Test
	public void TestGet() {
		baseURI =  "https://jsonplaceholder.typicode.com";
		given().
		when().
		get("/users").
		then().
		body("findAll { it.username.length() < 5}.id",hasItems(1));
	}	
	
	@Test
	public void TestResponseList()
	{
		baseURI =  "https://jsonplaceholder.typicode.com/users";
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		List<Object> ids = response.getBody().jsonPath().getList("id");
		List<Map<String,Object>> users = response.as(new TypeRef<List<Map< String,Object>>>() {});
		Assert.assertEquals(ids.size(),10);
		assertThat(users, hasSize(10));
		
		
	}
}
