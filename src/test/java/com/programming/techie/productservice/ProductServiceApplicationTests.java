package com.programming.techie.productservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort
	private Integer port;
	
	@BeforeEach
	void setup() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;
	}
	
	static{
		mongoDBContainer.start();
	}
	
	@Test
	void shouldCreateProduct() {
		String requestBody = """
			{
			    "name": "Iphone",
			    "description": "This is a new phone from Canada",
			    "price": 50000
			}
			""";
		RestAssured.given()
			.contentType("application/json")
			.body(requestBody)
			.when()
			.post("api/product")
			.then()
			.statusCode(201)
			.body("id",Matchers.notNullValue())
			.body("name",Matchers.equalTo("Iphone 15"))
			.body("description",Matchers.equalTo("Iphone 15 is a smartphone"))
			.body("price",Matchers.equalTo(40000));
	}

}
