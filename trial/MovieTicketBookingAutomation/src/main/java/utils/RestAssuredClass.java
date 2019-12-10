package utils;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.baseURI;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestAssuredClass {
	static Logger logger  = Logger.getLogger( RestAssuredClass.class.getName()); 
	
	public static int getStatusCode(String url) {
		baseURI = url;
		RequestSpecification request = given();
		Response response = request.request(Method.GET);
		return response.statusCode();
	}
	public static void verifyFooterLinksThroughtRestAssured(List<String> footerLinks) {
		for (String href : footerLinks) {
			try {
				int responseCode = getStatusCode(href);
				if(responseCode != 200)
				{
					logger.info(href+"server problem");	

				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
	}

}
