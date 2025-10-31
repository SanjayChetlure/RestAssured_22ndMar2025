package P3_Logging_Path_Query_Parameters_Cookies_Head;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Ex2_PathQueryParam
{
//    https://reqres.in/api/users?page=2

//    @Test
    public void TC1()
    {
        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
                .pathParam("Path1","api")
                .pathParam("Path2","users")
                .queryParam("page","2")

        .when()
                .get("https://reqres.in/{Path1}/{Path2}")
        .then()
                .log().all()
                .statusCode(200);
    }

//    @Test
    public void TC2()
    {
        given()
                .headers("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .pathParams("Path1","api","Path2","users")
                .queryParams("page","2")

        .when()
                .get("https://reqres.in/{Path1}/{Path2}")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void TC3()
    {
        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
                .pathParams("Path1","api","Path2","users","Path3","2")
        .when()
                .get("https://reqres.in/{Path1}/{Path2}/{Path3}")
        .then()
                .log().all()
                .statusCode(200);
    }

}
