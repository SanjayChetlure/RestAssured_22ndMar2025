package P7_Serialization_Deserialization;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Ex1_Serialization
{

//    Example of Serialization:-    Converting java object into network or file supported form (json/txt)
//    Using map & pojo

    ObjectMapper mapper=new ObjectMapper();

    @Test(priority = 1)
    public void serialization() throws StreamWriteException, DatabindException, IOException
    {
        StudentsPojo sp=new StudentsPojo();                 //create Pojo class with constructor parameter
        sp.setId("8");
        sp.setName("abc8");
        sp.setLocation("Pune");
        sp.setPhone("8888");
        String [] cources={"sub1","sub2"};
        sp.setCourses(cources);

        given()
                .contentType("application/json")
                .body(sp)                      //serialization (java to JSON)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .log().all();
    }

}
