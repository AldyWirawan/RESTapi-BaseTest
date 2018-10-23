package com.xtremax.qabase.microservices;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import org.hamcrest.CoreMatchers;

public class ApiTest extends BaseTest {

	@Test
	public void getUserData() {
		given().
			contentType("application/json").
		when().
			get("http://5bcdec43a0c99b001337a9a6.mockapi.io/test1/users/1").
		then().
			body(CoreMatchers.containsString("Albin")).
			statusCode(200);
	}
}
