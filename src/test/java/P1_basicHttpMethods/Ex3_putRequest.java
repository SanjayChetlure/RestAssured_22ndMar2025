package P1_basicHttpMethods;

import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex3_putRequest
{
    @Test
    public void TC1_updateStudent()
    {
        LinkedHashMap map=new LinkedHashMap();
        map.put("id","4");
        map.put("name","PALLAVI");
        map.put("location","Nanded");
        map.put("phone","4444");

        String [] s1={"SELENIUM","PYTHON"};
        map.put("courses",s1);


        given()
                .contentType("application/json")
                .body(map)
        .when()
                .put("http://localhost:3000/students/4")
        .then()
                .statusCode(200)
                .log().all();

    }
}
