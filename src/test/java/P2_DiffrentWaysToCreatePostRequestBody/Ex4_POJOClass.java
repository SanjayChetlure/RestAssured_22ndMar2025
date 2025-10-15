package P2_DiffrentWaysToCreatePostRequestBody;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex4_POJOClass
{

    @Test
    public void TC4_addNewStudent()
    {
        StudentPOJO data=new StudentPOJO();
        data.setId("7");
        data.setName("Shivani");
        data.setLocation("Pune");
        data.setPhone("7777");

        String [] courses={"APITesting","DBTesting"};
        data.setCourses(courses);


        given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all()
                .body("id",equalTo("7"));
    }

}
