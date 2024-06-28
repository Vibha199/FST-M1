package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class First_test {

    //GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    @Test(enabled = false)
    public void getRequestWithQueryParamter(){
        Response response = given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type","application/json").
                queryParam("status","alive").
                when().
                get("/findByStatus");
        System.out.println(response.getHeaders());
        System.out.println(response.getBody().asString());
        //System.out.println(response.getBody().asPrettyString());
        String petStatus =response.then().extract().path("[0]['status']");
        System.out.println("Pet status is : "+ petStatus );
        Assert.assertEquals(petStatus,"alive");

    }

    // GET https://petstore.swagger.io/v2/pet/{petId}
    @Test
    public void getRequestWithPathParamter() {
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type","application/json").
                pathParam("petId",772321).
                log().all().
                when().
                get("/{petId}").
                then()
                .statusCode(200)
                .body("name",equalTo("Riley"))
                .body("status",equalTo("alive"))
                .log().all();
    }

}