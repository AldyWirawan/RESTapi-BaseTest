package com.xtremax.qabase.microservices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected String host;
	protected String path = "/"; // prefix to the API, will be overriden depend on the API
	
	@BeforeClass
	public void setup() {
		// get parameter to override the host, if not available, fill with constants
		// invoke parameter using mvn test -Dhost=<host> to override host in constant
		host = System.getProperty("host");
		if (host == null) {
			host = Constants.Config.HOST;
		}
	}
	
	@AfterClass
	public void teardown() {
		
	}
	
	public String getUrl() {
		return host + path;
	}
	
	public String getUrl(String append) {
		return getUrl() + append;
	}
	
}