package P2_DiffrentWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex3_ExternalJsonFile
{

    @Test
    public void TC3_addNewStudent()
    {
        File path=new File("C:\\Users\\sanja\\IdeaProjects\\RestAssured_22ndMar\\JSON Files\\studentPostRequestBody.json");

        given()
                .contentType("application/json")
                .body(path)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all()
                .body("id",equalTo("6"));
    }
}
