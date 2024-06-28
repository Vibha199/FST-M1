package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import static io.restassured.RestAssured.given;


public class SpecificationTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp() {

        //Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status",equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000l))
                .build();
    }
    @Test(priority = 1)
    public void postRequest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id",777232);
        reqBody.put("name","Rilley");
        reqBody.put("status","alive");

        Response response =  given().spec(requestSpec).body(reqBody).when().post();
        petId= response.then().extract().path("id");

        response.then().spec(responseSpec);
    }

    @Test(priority = 2)
    public void getResponse(){
        given().spec(requestSpec).pathParams("petId",petId).
                when().get("/{petId}").
                then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequest(){
        given().spec(requestSpec).pathParams("petId",petId).
                when().delete("/{petId}").
                then().statusCode(200).body("message",equalTo(""+petId));
    }

}