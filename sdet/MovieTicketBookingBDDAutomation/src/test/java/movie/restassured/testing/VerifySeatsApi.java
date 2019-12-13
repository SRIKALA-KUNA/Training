package movie.restassured.testing;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifySeatsApi {
	static RequestSpecification request;
	static Response response;
	static Logger logger = Logger.getLogger(VerifySeatsApi.class.getName());
	@BeforeClass
	public static void getEmployees() {
		PropertyConfigurator.configure("./log4j.properties");
		RestAssured.baseURI=Utils.URIUtils.SeatsURI;
		request=RestAssured.given();
		 response= request.request(Method.GET);
	}
	
	@Test
	public void CheckResponseBody() {
		
		String responseBody=response.getBody().asString();
		logger.info(responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	@Test
	public void CheckStatusCode() {
	
		int statuscode=response.getStatusCode();
		logger.info(statuscode);
		Assert.assertEquals( 200,statuscode);
		
	}
	@Test
	public void CheckResponseTime() {
		
		long responseTime=response.getTime();
		logger.info(responseTime);
		if(responseTime>5000) 
			logger.warn("Response Time is Greater Than 5000");
			
		Assert.assertTrue(responseTime<5000);
		
		
	}
	

}