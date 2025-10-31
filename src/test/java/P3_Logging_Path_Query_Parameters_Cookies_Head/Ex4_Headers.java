package P3_Logging_Path_Query_Parameters_Cookies_Head;
import static io.restassured.RestAssured.given;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class Ex4_Headers
{
//    @Test
    public void TC1_testHeades()
    {
        given()

        .when()
                .get("https://google.com/")

        .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().headers();
    }

//    @Test
    public void TC2_getHeadersInfo()
    {
        Response resp = given()
                .when()
                    .get("https://google.com/");

        String header = resp.getHeader("Content-Type");
        System.out.println("----Content type----"+header);
    }

    @Test
    public void TC3_getAllHeadersInfo()
    {
        Response resp = given()

                .when()
                .get("https://google.com/");

        Headers allHeader = resp.getHeaders();

        for(Header s1:allHeader)
        {
            System.out.println(s1.getName()+" : "+s1.getValue());
        }
    }



}
