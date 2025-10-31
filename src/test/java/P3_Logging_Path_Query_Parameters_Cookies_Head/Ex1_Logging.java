package P3_Logging_Path_Query_Parameters_Cookies_Head;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ex1_Logging {

    public void TC1()
    {
        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .log().status()
                .log().body()
                .log().headers()
                .log().all();
    }

}

