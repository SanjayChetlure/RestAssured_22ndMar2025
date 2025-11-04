package P6_Request_And_Response_Validation;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ex1_ReusableRequestResponseSpecification
{
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;


    @BeforeClass
    public void beforeClass() {
          requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.zippopotam.us").setContentType(ContentType.JSON).build();

        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).build();
    }

    @Test
    public void TC1_verifyPalcesNames() {
        given()
                .spec(requestSpec)
        .when()
                .get("us/90210")
        .then()
                .spec(responseSpec)
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }


    //@Test
    public void TC1() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("https://api.zippopotam.us/us/90210")
        .then()
                .statusCode(200)
                .body("places[0].'place name'", equalTo("Beverly Hills"));
    }


}

