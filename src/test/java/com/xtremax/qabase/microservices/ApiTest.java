package com.xtremax.qabase.microservices;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.hamcrest.CoreMatchers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import com.google.gson.*;

public class ApiTest extends BaseTest {
	
	@BeforeClass
	public void setup() {
		super.setup();
		path = "/test1/users";
	}
	
	@Test
	public void getAllUserData() {
		when().
			get(getUrl()).
		then().
			statusCode(200).
		and().
			body("size()",greaterThanOrEqualTo(50));
	}
	
	@Test
	public void getUserDataById() {
		when().
			get(getUrl("/1")).
		then().
			statusCode(200).
		and().
			body(CoreMatchers.containsString("Albin"));
	}
	
	@Test
	public void createNewUser() {
		
		JsonObject json = new JsonObject();
		json.addProperty("name", "test");
		json.addProperty("email", "test@test.com");
		json.addProperty("imageUrl", "www.test.com/test");
		
		given().
			body(json.toString()).
		when().
			post(getUrl()).
		then().
			statusCode(201);
	}
}
