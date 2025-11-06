package P8_ExtentReporter;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex1_getStudent
{
    @Test
    public void TC1_getStudent()
    {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/students")
        .then()
                .statusCode(200);
    }
}
