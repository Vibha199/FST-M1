package GitHub_API;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHub_Activity {

	String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCsoiYtWv/RYh82TWMqshph3Mn6YY2e1SqHLSwnaXz6JF65HAL9JSicGQEEWdwJb0ENGNn7HSczVaNamhiEgorf8BXHT0do1WT7PtODNWqKF+5ff2jLrOUf67zAk0uqqIeGdubjURP0/TmWB7jDy38SqjcH+G4rHDw7cEqgb0X2bjWjc8wky1dFHInM/4jdRCxf4dwnGBgL2n9Gs0WUb2BoK09TUqh0iCYanzm9SESqb/s9GXaNRy0Tdvb8kzwQZ2iW4uwH+Ye5DrwFyZZvYzKnMHH5Mnskv8tWnbCGFYXg3200lsjqYNk6VSRpCQXWZU9rs64mGPgPytN+Z2ZwITtzyuPkU+kj/minrv8z7+TqhPqJoDWQkzH6UUm9OUNVL2gw348oHiNI3id0wvPkYgBwhxDUQ51xCPUH4IrRMAITs8EHj3IESCzTwsrzIapFL9sKI1irDPHUwg4ToXcNTbsHm/nKQMKNqzUOMRde9NzUsRWDsL8/dBEi+z8xfYfARJ8=";
	int id;
	// Declare request & Response specification
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {

		// Create request specification
		requestSpec = new RequestSpecBuilder()
				.addHeader("Authorization", "token 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")
				.setContentType(ContentType.JSON).setBaseUri("https://api.github.com").build();
		responseSpec = new ResponseSpecBuilder()

				// Check response content type
				.expectContentType("application/json")
				// Build response specification
				.build();

	}

	@Test(priority = 1)

	public void PostRequest() {

		String reqBody = "{ \"title\": \"TestAPIKey\",  \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCsoiYtWv/RYh82TWMqshph3Mn6YY2e1SqHLSwnaXz6JF65HAL9JSicGQEEWdwJb0ENGNn7HSczVaNamhiEgorf8BXHT0do1WT7PtODNWqKF+5ff2jLrOUf67zAk0uqqIeGdubjURP0/TmWB7jDy38SqjcH+G4rHDw7cEqgb0X2bjWjc8wky1dFHInM/4jdRCxf4dwnGBgL2n9Gs0WUb2BoK09TUqh0iCYanzm9SESqb/s9GXaNRy0Tdvb8kzwQZ2iW4uwH+Ye5DrwFyZZvYzKnMHH5Mnskv8tWnbCGFYXg3200lsjqYNk6VSRpCQXWZU9rs64mGPgPytN+Z2ZwITtzyuPkU+kj/minrv8z7+TqhPqJoDWQkzH6UUm9OUNVL2gw348oHiNI3id0wvPkYgBwhxDUQ51xCPUH4IrRMAITs8EHj3IESCzTwsrzIapFL9sKI1irDPHUwg4ToXcNTbsHm/nKQMKNqzUOMRde9NzUsRWDsL8/dBEi+z8xfYfARJ8=\" }";

		Response response = given().spec(requestSpec).body(reqBody).post("/user/keys");
		// Assertion with response specification
		response.then().spec(responseSpec);

		// Print response
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		id = response.then().extract().path("id");
		System.out.println("Id: " + id);
		Assert.assertEquals(response.getStatusCode(), 201);

	}

	@Test(priority = 2)
	public void GetRequest() {

		Response response = given().spec(requestSpec).get("/user/keys");
		System.out.println(response.getBody().asPrettyString());
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3)
	public void DeleteRequest() {

		Response response = given().spec(requestSpec).pathParam("keyId", id).delete("/user/keys/{keyId}");
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}
}