package P5_SchemaValidation;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Ex1_JSONSchemaValidation
{
    @Test
    public void jsonSchemaValidation()
    {
        given()
        .when()
                .get("http://localhost:3000/store")
        .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StoreJSONSchema.json"));
    }

}
