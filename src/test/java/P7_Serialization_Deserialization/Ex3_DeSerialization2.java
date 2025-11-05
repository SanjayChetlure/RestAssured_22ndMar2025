package P7_Serialization_Deserialization;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Ex3_DeSerialization2
{
    ObjectMapper mapper=new ObjectMapper();

    @Test
    public void MapResponseToPojoClass() throws StreamWriteException, DatabindException, IOException
    {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/students");


        List<StudentsPojo> studentAllData = mapper.readValue(resp.body().asString(), new TypeReference<List<StudentsPojo>>() {});

        Assert.assertEquals(studentAllData.get(0).getName(), "john");
        Assert.assertEquals(studentAllData.get(0).getPhone(), "1111");
        Assert.assertEquals(studentAllData.get(0).getCourses()[0], "Java");
        Assert.assertEquals(studentAllData.get(1).getName(), "KIM");
    }




}
