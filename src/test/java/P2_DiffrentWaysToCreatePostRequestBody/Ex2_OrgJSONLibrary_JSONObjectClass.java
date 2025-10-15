package P2_DiffrentWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex2_OrgJSONLibrary_JSONObjectClass
{


    @Test
    public void TC2_addNewStudent()
    {
        JSONObject jObj=new JSONObject();
        jObj.put("id","5");
        jObj.put("name","Ganesh");
        jObj.put("location","Shirdi");
        jObj.put("phone","5555");

        String [] s1={"SQL","python"};
        jObj.put("courses",s1);


        given()
                .contentType("application/json")
                .body(jObj.toString())
        .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
        .log().all()
                .body("id",equalTo("5"));
    }

}
