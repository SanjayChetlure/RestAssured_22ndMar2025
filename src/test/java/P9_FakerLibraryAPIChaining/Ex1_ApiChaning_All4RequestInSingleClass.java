package P9_FakerLibraryAPIChaining;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ex1_ApiChaning_All4RequestInSingleClass
{

    String id="";

    @Test(priority = 1)
    public void TC1_CreateStudent()
    {
        Faker f=new Faker();
        JSONObject data=new JSONObject();
        data.put("name", f.name().fullName());
        data.put("Location", "Pune");
        data.put("Phone", f.number().digits(6));

        String [] cources= {"C", "C++"};
        data.put("Cources", cources);


        Response resp = given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students");
//                        .jsonPath().getString("id");
        id=resp.jsonPath().getString("id");

        resp.prettyPrint();

    }


    @Test(priority = 2)
    public void TC2_getNewlyCreatedStudent()
    {
            given()
                .contentType("application/json")
            .when()
                .get("http://localhost:3000/students/"+id)
            .then()
                    .statusCode(200)
                    .log().body();
    }


    @Test(priority = 3)
    public void TC3_updateNewlyCreatedStudentDetails()
    {
        Faker f=new Faker();
        JSONObject data=new JSONObject();
        data.put("name", f.name().fullName());
        data.put("Location", "Pune");
        data.put("Phone", f.number().digits(6));

        String [] cources= {"C", "C++"};
        data.put("Cources", cources);


         given()
                .contentType("application/json")
                .body(data.toString())
        .when()
                .put("http://localhost:3000/students/"+id)
        .then()
                .statusCode(200)
                 .log().body();
    }



    @Test(priority = 4)
    public void TC4_deleteNewlyCreatedStudent()
    {
        given()
                .contentType("application/json")
        .when()
                .delete("http://localhost:3000/students/"+id)
        .then()
                .statusCode(200)
                .log().body();
    }

}
