package P7_Serialization_Deserialization;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Ex2_DeSerialization
{

//    Example of DeSerialization:-    Converting network or file supported form into java object

    ObjectMapper mapper=new ObjectMapper();

    @Test(priority = 2)
    public void DeSerialization() throws StreamWriteException, DatabindException, IOException
    {
        Response resp = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students/1");

        StudentsPojo sp = mapper.readValue(resp.body().asString(), StudentsPojo.class);   //de-serialization  convert json -> java object

        System.out.println(sp.getId());
        System.out.println(sp.getName());
        System.out.println(sp.getLocation());
        System.out.println(sp.getPhone());
        System.out.println(sp.getCourses()[0]);
        System.out.println(sp.getCourses()[1]);
    }



}
