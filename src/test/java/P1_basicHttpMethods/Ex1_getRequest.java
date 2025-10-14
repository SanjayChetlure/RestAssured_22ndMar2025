package P1_basicHttpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Ex1_getRequest
{

//    @Test
    public void TC1()
    {
       given()
               .contentType("application/json")
       .when()
               .get("https://reqres.in/api/users/2")
       .then()
               .log().all()
               .statusCode(401);
     }


    @Test
    public void TC2()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students")
        .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    public void TC3()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students/1")
        .then()
                .log().all()
                .statusCode(200)
                .body("id",equalTo("1"))
                .body("name",equalTo("john"))
                .body("courses[0]",equalTo("Java"));
    }


    @Test
    public void TC4()
    {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students/4")
                .then()
                .log().all()
                .statusCode(404);
    }
}
