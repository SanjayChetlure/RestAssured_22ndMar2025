package P1_basicHttpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Ex1_get
{

    @Test
    public void m1()
    {
       given()
               .contentType("application/json")
       .when()
               .get("https://reqres.in/api/users/2")
       .then()
               .log().all()
               .statusCode(401);
     }


}
