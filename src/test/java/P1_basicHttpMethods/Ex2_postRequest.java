package P1_basicHttpMethods;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Ex2_postRequest
{

    @Test
    public void TC1_addNewStudent()
    {
        LinkedHashMap map=new LinkedHashMap();
        map.put("id","4");
        map.put("name","Pallavi");
        map.put("location","Mumbai");
        map.put("phone","4444");

        String [] s1={"Selenium","python"};
        map.put("courses",s1);


        given()
                .contentType("application/json")
                .body(map)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all()
                .body("id",equalTo("4"));

    }

}
