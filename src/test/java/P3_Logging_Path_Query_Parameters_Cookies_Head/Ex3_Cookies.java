package P3_Logging_Path_Query_Parameters_Cookies_Head;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class Ex3_Cookies
{
   // @Test
    public void TC1_testCookies()
    {
        given()

        .when()
                .get("https://google.com/")

        .then()
                .cookie("AEC","AaJma5szHfloPhBGY-MpK4IipSLqx8QZtcFjvOc5b0mbPBJQIvp3orSvsA")
                .log().all();
    }

   // @Test
    public void TC2_getCookieInfo()
    {
        Response resp = given()
                .when()
                .get("https://google.com/");

        String cookieValue = resp.getCookie("AEC");
        System.out.println("----Cookie Info----"+cookieValue);
    }

    @Test
    public void TC3_getAllCookies()
    {
        Response resp = given()
                .when()
                .get("https://google.com/");

        Map<String, String> mp = resp.cookies();         //stores all cookie info into map
        Set<String> allCookieNames = mp.keySet();        //get only cookie names

        for(String cookieName:allCookieNames)
        {
            System.out.println(cookieName+" : "+mp.get(cookieName));
        }
    }

}
